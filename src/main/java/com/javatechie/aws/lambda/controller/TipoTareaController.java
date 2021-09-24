package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.TipoTareaService;

@RestController
@RequestMapping("/api-TipoTarea")
public class TipoTareaController {

	@Autowired
	private TipoTareaService service;
	
	@GetMapping(path = "/listAllActives")
	public List<ReactSelectResponse> listarTiposTarea(){
	    return service.listarEtapasTarea();
	}

}
