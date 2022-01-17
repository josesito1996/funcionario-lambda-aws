package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.getExtension;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
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

	private ResourceSami transformRequest(ResourceSamiCreateRequest request) {
		return ResourceSami.builder()
				.fileName(request.getFileName())
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
				.idFile(resourceSami.getId().concat(getExtension(resourceSami.getFileName())))
				.nombreArchivo(resourceSami.getFileName())
				.build();
	}

}
