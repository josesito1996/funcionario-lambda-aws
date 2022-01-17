package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;

public interface ResourceSamiService extends ICrud<ResourceSami, String>{

	
	ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request);
}
