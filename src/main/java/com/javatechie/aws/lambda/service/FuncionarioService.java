package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.domain.request.FuncionarioBody;

public interface FuncionarioService extends ICrud<Funcionario, String> {

	Funcionario registrar(FuncionarioBody request);
	
	Funcionario actualizar(FuncionarioBody request);
	
	Funcionario verPorIdFuncionario(String id);
}
