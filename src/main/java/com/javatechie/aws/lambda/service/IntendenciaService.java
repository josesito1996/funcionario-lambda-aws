package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Intendencia;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface IntendenciaService extends ICrud<Intendencia, String> {

	public List<ReactSelectResponse> listIntendencias();
	
}
