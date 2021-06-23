package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Etapa;
import com.javatechie.aws.lambda.domain.request.EtapaBody;
import com.javatechie.aws.lambda.domain.response.EtapaResponse;

public interface EtapaService extends ICrud<Etapa, String> {
	EtapaResponse registrar(EtapaBody request);

	EtapaResponse actualizar(EtapaBody request);

	EtapaResponse verPorIdEtapa(String id);

	List<EtapaResponse> ListarEtapaResponse();
	
	List<EtapaResponse> ListarEtapaPorEstado(Boolean estado);

}
