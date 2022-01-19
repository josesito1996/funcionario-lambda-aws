package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ResourceSamiChangeRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.domain.response.custom.ResourceGroupResponse;

public interface ResourceSamiService extends ICrud<ResourceSami, String>{

	ResourceSami verUnoPorId(String idResource);
	
	ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request);
	
	ResourceSamiCreateResponse changeIsUtil(ResourceSamiChangeRequest request);
	
	List<ResourceGroupResponse> listByUserName(String userName);
}
