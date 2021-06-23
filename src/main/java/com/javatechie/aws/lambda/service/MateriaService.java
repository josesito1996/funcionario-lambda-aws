package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.request.MateriaBody;
import com.javatechie.aws.lambda.domain.response.MateriaResponse;

public interface MateriaService extends ICrud<Materia, String> {

	MateriaResponse registrar(MateriaBody request);

	MateriaResponse actualizar(MateriaBody request);

	MateriaResponse verPorIdMateria(String id);

	List<MateriaResponse> ListarMateriaResponse();
	
	List<MateriaResponse> listarMateriasPorEstado(Boolean estado);
}
