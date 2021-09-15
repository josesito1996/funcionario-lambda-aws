package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Origen;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface OrigenService extends ICrud<Origen, String> {

    Origen buscarPorId(String idOrigen);
    
    List<ReactSelectResponse> listarSelect();
    
}
