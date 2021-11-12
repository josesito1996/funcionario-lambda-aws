package com.javatechie.aws.lambda.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;
import com.javatechie.aws.lambda.service.AnalisisRiesgoService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(path = "/api-analisisRiesgo")
public class AnalisisRiesgoController {

    @Autowired
    private AnalisisRiesgoService service;

    @Operation(summary = "Lista Todas analisis de riesgo pertenecientes a cada caso registrado en la BD.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = AnalisisRiesgo.class)))) })
    @GetMapping(path = "/listAll")
    public List<AnalisisRiesgo> listarTodos() {
        return service.listar();
    }

    @PostMapping(path = "/saveAnalisis")
    public Map<String, Object> registrarAnalisis(
            @Valid @RequestBody InfraccionAnalisisRequest request) {
        return service.registrarAnalisisRiesgo(request);
    }

}
