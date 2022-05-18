package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.TipoActuacion;
import com.javatechie.aws.lambda.domain.request.TipoActuacionBody;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.TipoActuacionResponse;

public interface TipoActuacionService extends ICrud<TipoActuacion, String> {

	TipoActuacionResponse registrar(TipoActuacionBody request);

	TipoActuacionResponse actualizar(TipoActuacionBody request);

	TipoActuacionResponse verPorIdTipoActuacion(String id);

	List<TipoActuacionResponse> listarTipoActuacions();

	List<TipoActuacion> listarTipoActuacionPorEstado(Boolean estado);

	List<ReactSelectResponse> listarTipoActuacionParaReact();
	/**
	 * Para Filtros.
	 */
	List<ReactSelectResponse> listarTipoActuacionFiltro();
}
