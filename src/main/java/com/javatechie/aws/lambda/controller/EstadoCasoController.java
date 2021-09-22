package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.EstadoCasoService;

@RestController
@RequestMapping("/api-estadoCaso")
public class EstadoCasoController {

	@Autowired
	private EstadoCasoService service;
	
	@GetMapping(path = "/listActives")
	public List<ReactSelectResponse> listarActivos(){
	    return service.listEstadosCasoByEstado(true);
	}

}
