package com.javatechie.aws.lambda.service;

import java.util.Map;

import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;

public interface AnalisisRiesgoService extends ICrud<AnalisisRiesgo, String> {

    Map<String, Object> registrarAnalisisRiesgo(InfraccionAnalisisRequest request);
    
    AnalisisRiesgo buscarPorId(String id);
    
}
