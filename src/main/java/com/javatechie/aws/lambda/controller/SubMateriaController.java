package com.javatechie.aws.lambda.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.SubMateriaRequest;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseBody;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.service.SubMateriaService;

@RestController
@RequestMapping("/api-SubMateria")
public class SubMateriaController {

    @Autowired
    private SubMateriaService service;

    @PostMapping(path = "/saveAll")
    public List<SubMateriaResponse> saveAll(@Valid @RequestBody List<SubMateriaRequest> request) {
        return service.registrarInfraccion(request);
    }

    @GetMapping(path = "/viewDetailSubMateriaByIdSubMateria/{idSubMateria}")
    public InfraccionResponseBody infraccionResponseBody(@PathVariable String idSubMateria) {
        return service.infraccionResponseBodyByIdSubMateria(idSubMateria);
    }
}
