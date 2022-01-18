package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.getExtension;
import static com.javatechie.aws.lambda.util.Utils.convertToLocalDateTime;
import static com.javatechie.aws.lambda.util.Utils.fechaFormateadaOther;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.domain.response.custom.ResourceGroupResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoResourceSami;
import com.javatechie.aws.lambda.service.ResourceSamiService;

@Service
public class ResourceSamiServiceImpl extends CrudImpl<ResourceSami, String> implements ResourceSamiService {

	@Autowired
	private RepoResourceSami repo;

	@Override
	protected GenericRepo<ResourceSami, String> getRepo() {
		return repo;
	}

	@Override
	public ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request) {

		return transformResponse(registrar(transformRequest(request)));
	}

	@Override
	public List<ResourceGroupResponse> listByUserName(String userName) {
		List<ResourceSami> listado = repo.findByUserName(userName);
		Map<String, List<ResourceSamiCreateResponse>> mapGroup = listado.stream()
		.map(this::transformResponse)
		.collect(Collectors.groupingBy(ResourceSamiCreateResponse::getCategoria));
		List<ResourceGroupResponse> newList = new ArrayList<>();
		for (Map.Entry<String, List<ResourceSamiCreateResponse>> item : mapGroup.entrySet()) {
			newList.add(ResourceGroupResponse.builder()
					.category(item.getKey())
					.items(item.getValue())
					.build());
		}
		return newList.stream().sorted(Comparator.comparing(ResourceGroupResponse::getCategory)).collect(Collectors.toList());
	}
	
	private ResourceSami transformRequest(ResourceSamiCreateRequest request) {
		return ResourceSami.builder()
				.fileName(request.getFileName())
				.customFileName(request.getFileNameAux().concat(getExtension(request.getFileName())))
				.description(request.getDescription())
				.uploadDate(LocalDateTime.now().toString())
				.type(request.getType())
				.isUtil(false)
				.isFavorite(false)
				.bytes(request.getSize())
				.isRemoved(false)
				.userName(request.getUserName())
				.category(request.getCategory())
				.build();
	}

	private ResourceSamiCreateResponse transformResponse(ResourceSami resourceSami) {
		return ResourceSamiCreateResponse.builder()
				.idFile(resourceSami.getId())
				.idFileExtension(resourceSami.getId().concat(getExtension(resourceSami.getFileName())))
				.nombreArchivo(resourceSami.getCustomFileName())
				.description(resourceSami.getDescription())
				.categoria(resourceSami.getCategory())
				.upLoadDate(fechaFormateadaOther(convertToLocalDateTime(resourceSami.getUploadDate())))
				.esUtil(resourceSami.getIsUtil())
				.esFavorito(resourceSami.getIsFavorite())
				.type(resourceSami.getType())
				.build();
	}
}
