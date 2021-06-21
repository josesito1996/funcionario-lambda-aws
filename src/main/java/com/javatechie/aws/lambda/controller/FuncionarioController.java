package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.FuncionarioBody;
import com.javatechie.aws.lambda.domain.response.FuncionarioResponse;
import com.javatechie.aws.lambda.service.FuncionarioService;

import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;

@RestController
@RequestMapping("/api-funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@ApiResponse(description = "Lista todos los funcionarios de la BD", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(type = "application/json")))
	@GetMapping(path = "/listAll")
	public List<FuncionarioResponse> listarTodos() {
		return service.listarFuncionarios();
	}

	@ApiResponse(description = "Busca por Id a un funcionario de la BD", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(type = "application/json")))
	@GetMapping(path = "/findById/{id}")
	public FuncionarioResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdFuncionario(id);
	}

	@ApiResponse(description = "Registra a un Funcionario en la BD", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(type = "application/json")))
	@PostMapping(path = "/save")
	public FuncionarioResponse registrar(@RequestBody FuncionarioBody request) {
		return service.registrar(request);
	}

	@ApiResponse(description = "Actualiza a un funcionario de la BD", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(type = "application/json")))
	@PutMapping(path = "/update")
	public FuncionarioResponse modificar(@RequestBody FuncionarioBody request) {
		return service.actualizar(request);
	}

}
