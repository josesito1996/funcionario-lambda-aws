package com.javatechie.aws.lambda.controller;

import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;
import com.javatechie.aws.lambda.service.AnalisisRiesgoService;

@RestController
@RequestMapping(path = "/api-analisisRiesgo")
public class AnalisisRiesgoController {

    @Autowired
    private AnalisisRiesgoService service;
    
    @GetMapping(path = "/listAll")
    public List<AnalisisRiesgo> listarTodos(){
        return service.listar();
    }
    
    @PostMapping(path = "/saveAnalisis")
    public Map<String, Object> registrarAnalisis(@Valid @RequestBody InfraccionAnalisisRequest request){
        return service.registrarAnalisisRiesgo(request);
    }
    
}
