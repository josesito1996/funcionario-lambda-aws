package com.javatechie.aws.lambda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.domain.request.FuncionarioBody;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoFuncionario;
import com.javatechie.aws.lambda.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl extends CrudImpl<Funcionario, String> implements FuncionarioService {

	@Autowired
	private RepoFuncionario repo;

	@Override
	public Funcionario registrar(FuncionarioBody request) {

		return registrar(
				bodyToEntity(request));
	}
	@Override
	protected GenericRepo<Funcionario, String> getRepo() {

		return repo;
	}

	@Override
	public Funcionario verPorIdFuncionario(String id) {
		Optional<Funcionario> option = verPorId(id);
		return option.isPresent() ? option.get() : new Funcionario();
	}
	@Override
	public Funcionario actualizar(FuncionarioBody request) {
		
		return modificar(bodyToEntity(request));
	}
	private Funcionario bodyToEntity(FuncionarioBody request) {
		return new Funcionario(request.getId(), request.getNombres(), request.getApellidos(), request.getEstado());
	};
}
