package com.javatechie.aws.lambda.controller;

import java.util.List;
import java.util.Map;

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

import com.javatechie.aws.lambda.domain.request.MateriaBody;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequestBody;
import com.javatechie.aws.lambda.domain.response.MateriaResponse;
import com.javatechie.aws.lambda.service.MateriaService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping("/api-materia")
public class MateriaController {

    @Autowired
    private MateriaService service;

    @Operation(summary = "Lista Todas las materias de la BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = MateriaResponse.class)))) })
    @GetMapping(path = "/listAll")
    public List<MateriaResponse> listarTodos() {
        return service.ListarMateriaResponse();
    }

    @Operation(summary = "Lista las materias activas de la BD")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, array = @ArraySchema(schema = @Schema(implementation = MateriaResponse.class)))) })
    @GetMapping(path = "/listAllActives")
    public List<MateriaResponse> lsitarActivos() {
        return service.listarMateriasPorEstado(true);
    }

    @Operation(summary = "Busca una Materia por ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MateriaResponse.class))) })
    @GetMapping(path = "/findById/{id}")
    public MateriaResponse buscarPorId(@PathVariable String id) {
        return service.verPorIdMateria(id);
    }

    @Operation(summary = "Registra una nueva materia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MateriaResponse.class))) })
    @PostMapping(path = "/save")
    public MateriaResponse registrar(@Valid @RequestBody MateriaBody request) {
        return service.registrar(request);
    }

    @Operation(summary = "Actualiza la materia")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(mediaType = MediaType.APPLICATION_JSON_VALUE, schema = @Schema(implementation = MateriaResponse.class))) })
    @PutMapping(path = "/update")
    public MateriaResponse modificar(@Valid @RequestBody MateriaBody request) {
        return service.actualizar(request);
    }

    @GetMapping(path = "/listMateriasAndSubmaterias")
    public List<MateriaResponse> listarMateriasYSubmateria() {
        return service.ListarMateriasYSubmaterias();
    }

    @PostMapping(path = "/listSubMaterias")
    public List<Map<String, Object>> verSubMateriasDelaMateria(
            @Valid @RequestBody SubMateriaRequestBody request) {
        return service.verSubMaterias(request.getIds());
    }

}
