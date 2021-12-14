package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.jdbc.CasosPorInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;
import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.request.InspectorUpdateRequest;
import com.javatechie.aws.lambda.domain.response.CaseByInspectorResponse;
import com.javatechie.aws.lambda.domain.response.InspectorPorNombreResponse;
import com.javatechie.aws.lambda.domain.response.InspectorResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface InspectorService extends ICrud<Inspector, String> {

	Inspector buscarPorId(String id);
	
	Inspector buscarPorNombre(String nombreInspector);
    
    InspectorResponse registrar(InspectorBody request);
	
	InspectorResponse actualizar(InspectorBody request);
	
	InspectorResponse actualizar(InspectorUpdateRequest request);
	
	InspectorResponse verPorIdInspector(String id);
	
	List<InspectorResponse> buscarPorNombreFiltro(String nombreInspector, String tipo);
	
	List<ReactSelectResponse> listarInspectoresPorTipo(String tipo);
	
	List<InspectorResponse> listarInspectores();
	
	/**
	 * JDBC
	 */
	
	List<InspectorQuery> listarInspectoresJdbcAsc();
	
	List<CasosPorInspectorQuery> storedProcedure(String isnpectorName);

	CaseByInspectorResponse casosPorInspector(String idInspector);
	
	List<InspectorPorNombreResponse> inspectorPorNombreResponses(String nombreInspector);
}
