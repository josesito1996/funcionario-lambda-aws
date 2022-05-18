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

import com.javatechie.aws.lambda.domain.request.TipoActuacionBody;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.TipoActuacionResponse;
import com.javatechie.aws.lambda.service.TipoActuacionService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-tipoActuacion")
public class TipoActuacionController {

	@Autowired
	private TipoActuacionService service;

	@Operation(summary = "Lista los tipo de actuaciones de la BD")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ReactSelectResponse.class)))) })
	@GetMapping(path = "/listAll")
	public List<ReactSelectResponse> listarTodos() {
		return service.listarTipoActuacionParaReact();
	}
	
	@Operation(summary = "Lista los tipo de actuaciones de la BD para los filtros")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = ReactSelectResponse.class)))) })
    @GetMapping(path = "/listAllFilters")
    public List<ReactSelectResponse> listarTodosFilteros() {
        return service.listarTipoActuacionFiltro();
    }

	@Operation(summary = "Busca TIpo de actuacion por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoActuacionResponse.class))) })
	@GetMapping(path = "/findById/{id}")
	public TipoActuacionResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdTipoActuacion(id);
	}

	@Operation(summary = "Registra el tipo de Actuacion")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoActuacionResponse.class))) })
	@PostMapping(path = "/save")
	public TipoActuacionResponse registrar(@Valid @RequestBody TipoActuacionBody request) {
		return service.registrar(request);
	}

	@Operation(summary = "Actualiza el tipo de ACtuacion")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = TipoActuacionResponse.class))) })
	@PutMapping(path = "/update")
	public TipoActuacionResponse modificar(@Valid @RequestBody TipoActuacionBody request) {
		return service.actualizar(request);
	}

}
