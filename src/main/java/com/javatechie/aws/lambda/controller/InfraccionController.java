package com.javatechie.aws.lambda.controller;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.custom.CustomSelectResponse;
import com.javatechie.aws.lambda.service.InfraccionService;

@RestController
@RequestMapping("/api-infraccion")
public class InfraccionController {

    @Autowired
    private InfraccionService service;

    /**
    @GetMapping(path = "/listSelect/{idSubMateria}")
    public List<InfraccionResponseSelect> listarSelectPorIdSubMateria(
            @PathVariable @NotEmpty @NotNull @Pattern(regexp = REGEX_UUID, message = "id no valido") String idSubMateria) {
        return service.listarSelectPorIdSubMateria(idSubMateria);
    }**/
    
    @GetMapping(path = "/viewGravedadByIdInfraccion/{idInfraccion}")
    public Map<String, Object> verGravedadPorIdInfraccion(
            @PathVariable @NotEmpty @NotNull @Pattern(regexp = REGEX_UUID, message = "id no valido") String idInfraccion) {
        return service.verGravedadPorIdInfraccion(idInfraccion);
    }
    
    /**
    @Deprecated
    @GetMapping(path = "/listSelect/{idSubMateria}")
    public Map<String, Object> listarSelectPorIdSubMateria(
            @PathVariable @NotEmpty @NotNull @Pattern(regexp = REGEX_UUID, message = "id no valido") String idSubMateria) {
        return service.listarSelectPorIdSubMateriaAux(idSubMateria);
    }
    */
    
    @GetMapping(path = "/listSelect/{idSubMateria}")
    public CustomSelectResponse listarSelectPorIdSubMateriaV2(
            @PathVariable @NotEmpty @NotNull @Pattern(regexp = REGEX_UUID, message = "id no valido") String idSubMateria) {
        return service.listarSelectPorIdSubMateriaAuxV2(idSubMateria);
    }

    @GetMapping(path = "/listAll")
    public List<InfraccionResponse> listarTodos() {
        return service.listarInfracciones();
    }

    @PostMapping(path = "/saveAll")
    public List<InfraccionResponse> registrarMasivo(
            @RequestBody @NotEmpty List<@Valid InfraccionRequestBody> request) {
        return service.registrarInfraccion(request);
    }

}
