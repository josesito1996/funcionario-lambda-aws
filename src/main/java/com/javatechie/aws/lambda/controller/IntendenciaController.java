package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.IntendenciaService;

@RestController
@RequestMapping("/api-intendencia")
public class IntendenciaController {

	@Autowired
	private IntendenciaService service;
	
	@GetMapping(path = "/listAll")
	public List<ReactSelectResponse> listIntendencias(){
		return service.listIntendencias();
	}
	
}
