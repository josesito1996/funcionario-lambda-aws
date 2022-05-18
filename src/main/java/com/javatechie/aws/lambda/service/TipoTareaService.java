package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.TipoTarea;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface TipoTareaService extends ICrud<TipoTarea, String> {
	
    public List<ReactSelectResponse> listarEtapasTarea();
    
}
