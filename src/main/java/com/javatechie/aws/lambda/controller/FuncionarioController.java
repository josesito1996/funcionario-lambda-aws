package com.javatechie.aws.lambda.controller;

import java.util.List;

import javax.validation.Valid;

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
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.FuncionarioService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-funcionario")
public class FuncionarioController {

	@Autowired
	private FuncionarioService service;

	@Operation(summary = "Lista los Funcionario de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ReactSelectResponse.class)))) })	
	@GetMapping(path = "/listAll")
	public List<ReactSelectResponse> listarTodos() {
		return service.listarFuncionariosParaReact();
	}

	@Operation(summary = "Busca Funcionario por ID")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FuncionarioResponse.class))) })	
	@GetMapping(path = "/findById/{id}")
	public FuncionarioResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdFuncionario(id);
	}

	@Operation(summary = "Registra nuevo Funcionario")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FuncionarioResponse.class))) })	
	@PostMapping(path = "/save")
	public FuncionarioResponse registrar(@Valid @RequestBody FuncionarioBody request) {
		return service.registrar(request);
	}

	@Operation(summary = "Actualiza funcionario de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = FuncionarioResponse.class))) })	
	@PutMapping(path = "/update")
	public FuncionarioResponse modificar(@Valid @RequestBody FuncionarioBody request) {
		return service.actualizar(request);
	}

}
