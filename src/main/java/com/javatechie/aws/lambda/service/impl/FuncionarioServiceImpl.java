package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.domain.request.FuncionarioBody;
import com.javatechie.aws.lambda.domain.response.FuncionarioResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoFuncionario;
import com.javatechie.aws.lambda.service.FuncionarioService;

@Service
public class FuncionarioServiceImpl extends CrudImpl<Funcionario, String> implements FuncionarioService {

	@Autowired
	private RepoFuncionario repo;

	@Override
	public FuncionarioResponse registrar(FuncionarioBody request) {

		return transformToResponse(registrar(bodyToEntity(request)));
	}

	@Override
	protected GenericRepo<Funcionario, String> getRepo() {

		return repo;
	}

	@Override
	public FuncionarioResponse verPorIdFuncionario(String id) {
		Optional<Funcionario> option = verPorId(id);
		return option.isPresent() ? transformToResponse(option.get()) : new FuncionarioResponse();
	}

	@Override
	public FuncionarioResponse actualizar(FuncionarioBody request) {

		return transformToResponse(modificar(bodyToEntity(request)));
	}

	private Funcionario bodyToEntity(FuncionarioBody request) {
		return new Funcionario(request.getId(), request.getNombres(), request.getApellidos(), request.getEstado());
	}

	@Override
	public List<FuncionarioResponse> listarFuncionarios() {
		return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
	};

	private FuncionarioResponse transformToResponse(Funcionario funcionario) {
		String datos = funcionario.getNombres().concat(" ").concat(funcionario.getApellidos());
		return new FuncionarioResponse(funcionario.getIdFuncionario(), datos, funcionario.getEstado());
	}

	@Override
	public List<Funcionario> listarFuncionariosPorEstado(Boolean estado) {

		return repo.findByEstado(estado);
	}

	@Override
	public List<ReactSelectResponse> listarFuncionariosParaReact() {
		return listarFuncionariosPorEstado(true).stream().map(this::transfromReact).collect(Collectors.toList());
	}

	private ReactSelectResponse transfromReact(Funcionario funcionario) {
		String datos = funcionario.getNombres().concat(" ").concat(funcionario.getApellidos());
		return new ReactSelectResponse(funcionario.getIdFuncionario(), datos, null,null);
	}
}
