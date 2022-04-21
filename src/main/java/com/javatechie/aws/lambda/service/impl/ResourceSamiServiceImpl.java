package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.getExtension;
import static com.javatechie.aws.lambda.util.Utils.convertToLocalDateTime;
import static com.javatechie.aws.lambda.util.Utils.fechaFormateadaOther;
import static com.javatechie.aws.lambda.util.Utils.getBase64Fragment;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.gson.JsonObject;
import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.lambda.Attachment;
import com.javatechie.aws.lambda.domain.lambda.LambdaFileBase64Request;
import com.javatechie.aws.lambda.domain.lambda.LambdaMailRequestSendgrid;
import com.javatechie.aws.lambda.domain.request.ContractSamiCreateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiChangeRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiUpdateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSendFileMailRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.domain.response.custom.ResourceGroupResponse;
import com.javatechie.aws.lambda.exception.BadRequestException;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoResourceSami;
import com.javatechie.aws.lambda.rest.model.ColaboradorPojo;
import com.javatechie.aws.lambda.rest.model.ExternalEndpoint;
import com.javatechie.aws.lambda.rest.model.UsuarioPojo;
import com.javatechie.aws.lambda.service.LambdaService;
import com.javatechie.aws.lambda.service.ResourceSamiService;

@Service
public class ResourceSamiServiceImpl extends CrudImpl<ResourceSami, String> implements ResourceSamiService {

	@Autowired
	private RepoResourceSami repo;

	@Autowired
	private LambdaService lambdaService;
	
	@Autowired
	private ExternalEndpoint externalEndpoint;

	@Override
	protected GenericRepo<ResourceSami, String> getRepo() {
		return repo;
	}

	@Override
	public ResourceSami verUnoPorId(String idResource) {
		Optional<ResourceSami> optionalResource = verPorId(idResource);
		if (!optionalResource.isPresent()) {
			throw new NotFoundException("Recurso no encontrado " + idResource);
		}
		return optionalResource.get();
	}

	@Override
	public ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request) {

		return transformResponse(registrar(transformRequest(request)));
	}


	@Override
	public ResourceSamiCreateResponse updateContract(ResourceSamiUpdateRequest request) {
		ResourceSami resource = verUnoPorId(request.getId());
		resource.setUrl(request.getUrl());
		return transformResponse(modificar(resource));
	}
	
	@Override
	public ResourceSamiCreateResponse createContract(ContractSamiCreateRequest request) {

		return transformResponse(registrar(transformRequestContract(request)));
	}

	@Override
	public List<ResourceGroupResponse> listByUserName(String userName) {
		List<ResourceSami> listado = repo.findByUserName(getUserNamePrincipal(userName)).stream()
				.filter(item -> item.getIsRemoved() != null && !item.getIsRemoved() && item.getCategory()!=null).collect(Collectors.toList());
		Map<String, List<ResourceSamiCreateResponse>> mapGroup = listado.stream().map(this::transformResponse)
				.collect(Collectors.groupingBy(ResourceSamiCreateResponse::getCategoria));
		List<ResourceGroupResponse> newList = new ArrayList<>();
		for (Map.Entry<String, List<ResourceSamiCreateResponse>> item : mapGroup.entrySet()) {
			newList.add(ResourceGroupResponse.builder().category(item.getKey()).items(item.getValue()).build());
		}
		return newList.stream().sorted(Comparator.comparing(ResourceGroupResponse::getCategory))
				.collect(Collectors.toList());
	}

	@Override
	public List<Map<String, Object>> listContractsByUserName(String userName) {

		return listar().stream()
				.filter(item -> item.getTypeResource() != null && item.getTypeResource().equals("CONTRACT"))
				.map(item -> {
					Map<String, Object> map = new HashMap<>();
					map.put("id", item.getId());
					map.put("idFileExtension", item.getId().concat(getExtension(item.getFileName())));
					map.put("nombreArchivo", item.getCustomFileName());
					map.put("url", item.getUrl());
					return map;
				}).collect(Collectors.toList());
	}

	@Override
	public ResourceSamiCreateResponse changeIsUtil(ResourceSamiChangeRequest request) {
		ResourceSami resource = verUnoPorId(request.getId());
		if (request.getIsFavorite() != null) {
			resource.setIsFavorite(request.getIsFavorite());
		}
		if (request.getIsUtil() != null) {
			resource.setIsUtil(request.getIsUtil());
		}
		if (request.getIsRemoved() != null) {
			resource.setIsRemoved(request.getIsRemoved());
		}
		return transformResponse(modificar(resource));
	}

	private ResourceSami transformRequestContract(ContractSamiCreateRequest request) {
		return ResourceSami.builder().fileName(request.getFileName())
				.customFileName(request.getFileNameAux().concat(getExtension(request.getFileName())))
				.description(request.getDescription()).uploadDate(LocalDateTime.now().toString())
				.type(request.getType()).isUtil(null).isFavorite(null).bytes(request.getSize()).isRemoved(false)
				.userName(request.getUserName()).typeResource("CONTRACT").build();
	}

	private ResourceSami transformRequest(ResourceSamiCreateRequest request) {
		return ResourceSami.builder().fileName(request.getFileName())
				.customFileName(request.getFileNameAux().concat(getExtension(request.getFileName())))
				.description(request.getDescription()).uploadDate(LocalDateTime.now().toString())
				.type(request.getType()).isUtil(null).isFavorite(null).bytes(request.getSize()).isRemoved(false)
				.userName(request.getUserName()).category(request.getCategory()).build();
	}

	private ResourceSamiCreateResponse transformResponse(ResourceSami resourceSami) {
		return ResourceSamiCreateResponse.builder().idFile(resourceSami.getId())
				.idFileExtension(resourceSami.getId().concat(getExtension(resourceSami.getFileName())))
				.nombreArchivo(resourceSami.getCustomFileName()).description(resourceSami.getDescription())
				.categoria(resourceSami.getCategory())
				.upLoadDate(fechaFormateadaOther(convertToLocalDateTime(resourceSami.getUploadDate())))
				.esUtil(resourceSami.getIsUtil()).esFavorito(resourceSami.getIsFavorite()).type(resourceSami.getType())
				.url(resourceSami.getUrl()).build();
	}

	@Override
	public Boolean sendFileToMail(ResourceSendFileMailRequest request) {
		ResourceSami resourceSami = verUnoPorId(request.getIdFile());
		String base64 = lambdaService.obtenerBase64(LambdaFileBase64Request.builder()
				.idFile(request.getIdFile().concat(getExtension(resourceSami.getFileName())))
				.bucketName("recursos-sami").fileName(resourceSami.getCustomFileName()).httpMethod("GET")
				.type(resourceSami.getType()).build());

		if (base64.equals("---")) {
			throw new BadRequestException("Archivo no existe " + resourceSami.getCustomFileName());
		}
		JsonObject obj = lambdaService
				.enviarCorreo(LambdaMailRequestSendgrid.builder().emailFrom("notificacion.sami@sidetechsolutions.com")
						.emailTo(request.getDestinatario()).subject("Mensaje con archivo Adjunto")
						.content("Contenido del mensaje")
						.archivos(Arrays.asList(Attachment.builder().content64(getBase64Fragment(base64))
								.disposition("attachment").fileName(resourceSami.getCustomFileName())
								.type(resourceSami.getType()).build()))
						.build());
		int statusCode = obj.get("code").getAsInt();
		return statusCode == 202;
	}
	
	private String getUserNamePrincipal(String userName) {
		UsuarioPojo usuario = externalEndpoint.viewByUserName(userName);
		if (usuario == null) {
			ColaboradorPojo colaborador = externalEndpoint.viewColaboratorByUserName(userName);
			return colaborador.getUserName();
		}
		return usuario.getNombreUsuario();
	}
}
