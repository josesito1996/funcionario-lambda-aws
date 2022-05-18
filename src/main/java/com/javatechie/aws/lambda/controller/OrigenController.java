package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.service.OrigenService;

@RequestMapping("/api-origen")
@RestController
public class OrigenController {

    @Autowired
    private OrigenService service;
    
    @GetMapping(path = "/listReactSelect")
    public List<ReactSelectResponse> listarSelectReact(){
        return service.listarSelect();
    }
    
}
