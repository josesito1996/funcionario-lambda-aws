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

import com.javatechie.aws.lambda.domain.request.EtapaBody;
import com.javatechie.aws.lambda.domain.response.EtapaResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.EtapaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-etapa")
public class EtapaController {

	@Autowired
	private EtapaService service;

	@Operation(summary = "Lista Todas las Etapas de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EtapaResponse.class)))) })	
	@GetMapping(path = "/listAll")
	public List<EtapaResponse> listarTodos() {
		return service.ListarEtapaResponse();
	}
	
	@Operation(summary = "Lista Todas las Etapas de la BD para el Filtro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", 
                    content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = EtapaResponse.class)))) })  
    @GetMapping(path = "/listAllFilter")
    public List<ReactSelectResponse> listarTodosFiltro() {
        return service.ListarEtapaResponseFilters();
    }
	
	@Operation(summary = "Lista las Etapas activas de la BD")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ReactSelectResponse.class)))) })	
	@GetMapping(path = "/listAllActives")
	public List<ReactSelectResponse> listarActivos() {
		return service.listarTipoActuacionParaReact();
	}

	@Operation(summary = "Busca una Etapa por ID")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EtapaResponse.class))) })	
	@GetMapping(path = "/findById/{id}")
	public EtapaResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdEtapa(id);
	}

	@Operation(summary = "Registra una nuevo Etapa")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EtapaResponse.class))) })	
	@PostMapping(path = "/save")
	public EtapaResponse registrar(@Valid @RequestBody EtapaBody request) {
		return service.registrar(request);
	}

	@Operation(summary = "Actualiza la Etapa")
	@ApiResponses(value = {
	        @ApiResponse(responseCode = "200", description = "successful operation", 
	                content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = EtapaResponse.class))) })	
	@PutMapping(path = "/update")
	public EtapaResponse modificar(@Valid @RequestBody EtapaBody request) {
		return service.actualizar(request);
	}

}
