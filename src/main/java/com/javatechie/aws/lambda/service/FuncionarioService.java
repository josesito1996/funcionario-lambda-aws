package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.domain.request.FuncionarioBody;
import com.javatechie.aws.lambda.domain.response.FuncionarioResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface FuncionarioService extends ICrud<Funcionario, String> {

	FuncionarioResponse registrar(FuncionarioBody request);
	
	FuncionarioResponse actualizar(FuncionarioBody request);
	
	FuncionarioResponse verPorIdFuncionario(String id);
	
	List<FuncionarioResponse> listarFuncionarios();
	
	List<Funcionario> listarFuncionariosPorEstado(Boolean estado);
	
	List<ReactSelectResponse> listarFuncionariosParaReact();
}
