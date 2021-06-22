package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.response.InspectorResponse;

public interface InspectorService extends ICrud<Inspector, String> {

	InspectorResponse registrar(InspectorBody request);
	
	InspectorResponse actualizar(InspectorBody request);
	
	InspectorResponse verPorIdInspector(String id);
	
	List<InspectorResponse> buscarPorNombreFiltro(String nombreInspector, String tipo);
	
	List<InspectorResponse> listarInspectores();
}
