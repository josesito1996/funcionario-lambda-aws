package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.TipoActuacion;
import com.javatechie.aws.lambda.domain.request.TipoActuacionBody;
import com.javatechie.aws.lambda.domain.response.TipoActuacionResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoTipoActuacion;
import com.javatechie.aws.lambda.service.TipoActuacionService;

@Service
public class TipoActuacionServiceImpl extends CrudImpl<TipoActuacion, String> implements TipoActuacionService {

	@Autowired
	private RepoTipoActuacion repo;

	@Override
	public TipoActuacionResponse registrar(TipoActuacionBody request) {

		return transformToResponse(registrar(bodyToEntity(request)));
	}

	@Override
	protected GenericRepo<TipoActuacion, String> getRepo() {

		return repo;
	}

	@Override
	public TipoActuacionResponse verPorIdTipoActuacion(String id) {
		Optional<TipoActuacion> option = verPorId(id);
		return option.isPresent() ? transformToResponse(option.get()) : new TipoActuacionResponse();
	}

	@Override
	public TipoActuacionResponse actualizar(TipoActuacionBody request) {

		return transformToResponse(modificar(bodyToEntity(request)));
	}

	private TipoActuacion bodyToEntity(TipoActuacionBody request) {
		return new TipoActuacion(request.getId(),request.getNombreTipoActuacion(), request.getEstado());
	}

	@Override
	public List<TipoActuacionResponse> listarTipoActuacions() {
		return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
	};

	private TipoActuacionResponse transformToResponse(TipoActuacion tipo) {
		return new TipoActuacionResponse(tipo.getIdTipoActuacion(), tipo.getNombreTipoActuacion());
	}
}
