package com.javatechie.aws.lambda.service;

import java.util.List;
import java.util.Map;

import com.javatechie.aws.lambda.domain.ResourceSami;
import com.javatechie.aws.lambda.domain.request.ContractSamiCreateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiChangeRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSamiUpdateRequest;
import com.javatechie.aws.lambda.domain.request.ResourceSendFileMailRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.domain.response.custom.ResourceGroupResponse;

public interface ResourceSamiService extends ICrud<ResourceSami, String>{

	ResourceSami verUnoPorId(String idResource);
	
	ResourceSamiCreateResponse createResource(ResourceSamiCreateRequest request);
	
	ResourceSamiCreateResponse createContract(ContractSamiCreateRequest request);
	
	ResourceSamiCreateResponse updateContract(ResourceSamiUpdateRequest request);
	
	Boolean sendFileToMail(ResourceSendFileMailRequest request);
	
	ResourceSamiCreateResponse changeIsUtil(ResourceSamiChangeRequest request);
	
	List<Map<String, Object>> listContractsByUserName(String userName);
	
	List<ResourceGroupResponse> listByUserName(String userName);
}
