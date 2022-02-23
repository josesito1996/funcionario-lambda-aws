package com.javatechie.aws.lambda.service;

import java.util.List;
import java.util.Map;

import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;
import com.javatechie.aws.lambda.domain.response.AnalisisRiesgoDetalle;

public interface AnalisisRiesgoService extends ICrud<AnalisisRiesgo, String> {

	
	List<AnalisisRiesgo> listarPorIdCaso(String idCaso);
	
    Map<String, Object> registrarAnalisisRiesgo(InfraccionAnalisisRequest request);
    
    AnalisisRiesgo buscarPorId(String id);
    
    InfraccionAnalisisRequest verPorIdAnalisis(String idAnalisis);
    
    AnalisisRiesgoDetalle verPorIdCaso(String idCaso);
    
}
