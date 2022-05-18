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

import com.javatechie.aws.lambda.domain.request.EquipoBody;
import com.javatechie.aws.lambda.domain.response.EquipoResponse;
import com.javatechie.aws.lambda.service.EquipoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-equipo")
public class EquipoController {

	@Autowired
	private EquipoService service;

	@Operation(summary = "Lista Todas las Equipos de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EquipoResponse.class)))) })	
	@GetMapping(path = "/listAll")
	public List<EquipoResponse> listarTodos() {
		return service.listarEquipoResponse();
	}
	
	@Operation(summary = "Lista las Equipos activas de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EquipoResponse.class)))) })	
	@GetMapping(path = "/listAllActives")
	public List<EquipoResponse> listarActivos() {
		return service.listarEquipoPorEstado(true);
	}

	@Operation(summary = "Busca una Equipo por ID")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EquipoResponse.class))) })	
	@GetMapping(path = "/findById/{id}")
	public EquipoResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdEquipo(id);
	}

	@Operation(summary = "Registra un nuevo Equipo")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EquipoResponse.class))) })	
	@PostMapping(path = "/save")
	public EquipoResponse registrar(@Valid @RequestBody EquipoBody request) {
		return service.registrar(request);
	}

	@Operation(summary = "Actualiza el Equipo")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EquipoResponse.class))) })	
	@PutMapping(path = "/update")
	public EquipoResponse modificar(@Valid @RequestBody EquipoBody request) {
		return service.actualizar(request);
	}

}
