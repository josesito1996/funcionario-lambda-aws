package com.javatechie.aws.lambda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.ComentarioInspectorCreateRequestBody;
import com.javatechie.aws.lambda.domain.response.ComentarioResponse;
import com.javatechie.aws.lambda.service.ComentarioService;

@RestController
@RequestMapping(path = "/api-comentario")
public class ComentarioController {

	@Autowired
	private ComentarioService service;
	
	@PostMapping(path = "/registerCommentForInspector")
	private ComentarioResponse registrar(@RequestBody @Valid ComentarioInspectorCreateRequestBody request) {
		return service.registrarComentarioInspector(request);
	}
	
}
