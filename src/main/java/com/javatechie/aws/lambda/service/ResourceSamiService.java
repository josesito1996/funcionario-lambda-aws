package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.domain.response.custom.ResourceGroupResponse;

public interface ResourceSamiService extends ICrud<ResourceSami, String>{

	
	ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request);
	
	List<ResourceGroupResponse> listByUserName(String userName);
}
