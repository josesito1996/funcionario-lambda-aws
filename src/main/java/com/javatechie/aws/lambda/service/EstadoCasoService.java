package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.EstadoCaso;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface EstadoCasoService extends ICrud<EstadoCaso, String> {

    public List<EstadoCaso> listarActivos(Boolean estado);
    
    public List<ReactSelectResponse> listEstadosCasoByEstado(Boolean estado);

}
