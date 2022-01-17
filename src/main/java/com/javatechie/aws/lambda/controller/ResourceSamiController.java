package com.javatechie.aws.lambda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.ResourceSamiCreateRequest;
import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;
import com.javatechie.aws.lambda.service.ResourceSamiService;

@RestController
@RequestMapping("/api-resource-sami")
public class ResourceSamiController {

	@Autowired
	ResourceSamiService service;
	
	@PostMapping(path = "/saveResource")
	public ResourceSamiCreateResponse saveResource(@Valid @RequestBody ResourceSamiCreateRequest request) {
		return service.createResource(request);
	}
	
}
