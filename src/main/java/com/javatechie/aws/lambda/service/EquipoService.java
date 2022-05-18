package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Equipo;
import com.javatechie.aws.lambda.domain.request.EquipoBody;
import com.javatechie.aws.lambda.domain.response.EquipoResponse;

public interface EquipoService extends ICrud<Equipo, String> {

	EquipoResponse registrar(EquipoBody request);

	EquipoResponse actualizar(EquipoBody request);

	EquipoResponse verPorIdEquipo(String id);

	List<EquipoResponse> listarEquipoResponse();
	
	List<EquipoResponse> listarEquipoPorEstado(Boolean estado);

}
