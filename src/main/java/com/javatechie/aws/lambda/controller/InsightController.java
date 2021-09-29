package com.javatechie.aws.lambda.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.Insight;
import com.javatechie.aws.lambda.service.InsightService;

@RestController
@RequestMapping(path = "/api-insight")
public class InsightController {

    @Autowired
    private InsightService service;
    
    @GetMapping(path = "/listActives")
    List<Map<String, Object>> listarActivos(){
        return service.listarIsnights();
    }
    
    @GetMapping(path = "/findById/{id}")
    Insight verUnoPorId(@PathVariable String id) {
        return service.verUnoPorId(id);
    }
    
}
