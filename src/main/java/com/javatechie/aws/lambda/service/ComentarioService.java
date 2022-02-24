package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Comentario;
import com.javatechie.aws.lambda.domain.request.ComentarioInspectorCreateRequestBody;
import com.javatechie.aws.lambda.domain.response.ComentarioResponse;

public interface ComentarioService extends ICrud<Comentario, String>{
	
	List<ComentarioResponse> listarPorIdFuncionario(String id);

	List<Comentario> buscarPorIdentificador(String identificador);
	
	ComentarioResponse registrarComentarioInspector(ComentarioInspectorCreateRequestBody request);
}
