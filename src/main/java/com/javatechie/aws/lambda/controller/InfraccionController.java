package com.javatechie.aws.lambda.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.service.InfraccionService;

@RestController
@RequestMapping("/api-infraccion")
public class InfraccionController {

    @Autowired
    private InfraccionService service;

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
