package com.javatechie.aws.lambda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.PuntuacionRequest;
import com.javatechie.aws.lambda.service.PuntuacionService;

@RestController
@RequestMapping("/api-puntuacion")
public class PuntuacionController {

    @Autowired
    PuntuacionService service;
    
    @PostMapping(path = "/qualify")
    public int[][] calificar(@RequestBody @Valid PuntuacionRequest request) {
        return service.registrarMasivoPuntuacionInspector(request);
    }
    
}
