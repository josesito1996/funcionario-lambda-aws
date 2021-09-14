package com.javatechie.aws.lambda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springdoc.api.annotations.ParameterObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.request.InspectorUpdateRequest;
import com.javatechie.aws.lambda.domain.response.CaseByInspectorResponse;
import com.javatechie.aws.lambda.domain.response.InspectorResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.InspectorService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-inspector")
public class InspectorController {

	@Autowired
	private InspectorService service;

	@Operation(summary = "Lista Todos los inspectores de la BD")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = InspectorResponse.class)))) })
	@GetMapping(path = "/listAll")
	public List<InspectorResponse> listarTodos() {
		return service.listarInspectores();
	}

	@Operation(summary = "Busca Inspector por ID")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
	@GetMapping(path = "/findById/{id}")
	public InspectorResponse buscarPorId(@PathVariable String id) {
		return service.verPorIdInspector(id);
	}

	@Operation(summary = "Busca inspector por parametros")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
	@GetMapping(path = "/filterByName")
	public List<InspectorResponse> filtraPorNombre(@ParameterObject @RequestParam("name") String name, @RequestParam("type") String type) {
		return service.buscarPorNombreFiltro(name, type);
	}
	
	@Operation(summary = "Busca inspector por tipo")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
	@GetMapping(path = "/searchByTipo/{tipo}")
	public List<ReactSelectResponse> buscarPorNombre(@PathVariable String tipo) {
		return service.listarInspectoresPorTipo(tipo);
	}

	@Operation(summary = "Registra el un Inspector")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
	@PostMapping(path = "/save")
	public InspectorResponse registrar(@Valid @RequestBody InspectorBody request) {
		return service.registrar(request);
	}

	@Operation(summary = "Actualiza un Inspector")
	@ApiResponses(value = {
			@ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
	@PutMapping(path = "/update")
	public InspectorResponse modificar(@Valid @RequestBody InspectorBody request) {
		return service.actualizar(request);
	}
	
	@Operation(summary = "Actualiza Tefono y Correo de un inspector")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = InspectorResponse.class))) })
    @PutMapping(path = "/updateData")
    public InspectorResponse actualizarDatos(@Valid @RequestBody InspectorUpdateRequest request) {
        return service.actualizar(request);
    }
	
	@GetMapping(path = "/searchCasesByInspectorId/{idInspector}")
	//test
	public CaseByInspectorResponse findCasesByInspector(@PathVariable String idInspector) {
	    return service.casosPorInspector(idInspector);
	}

}
