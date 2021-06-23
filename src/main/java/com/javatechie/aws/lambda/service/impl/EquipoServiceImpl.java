package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Equipo;
import com.javatechie.aws.lambda.domain.request.EquipoBody;
import com.javatechie.aws.lambda.domain.response.EquipoResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoEquipo;
import com.javatechie.aws.lambda.service.EquipoService;

@Service
public class EquipoServiceImpl extends CrudImpl<Equipo, String> implements EquipoService {

	@Autowired
	private RepoEquipo repo;

	@Override
	public EquipoResponse registrar(EquipoBody request) {

		return transformToResponse(registrar(bodyToEntity(request)));
	}

	@Override
	protected GenericRepo<Equipo, String> getRepo() {

		return repo;
	}

	@Override
	public EquipoResponse verPorIdEquipo(String id) {
		Optional<Equipo> option = verPorId(id);
		return option.isPresent() ? transformToResponse(option.get()) : new EquipoResponse();
	}

	@Override
	public EquipoResponse actualizar(EquipoBody request) {

		return transformToResponse(modificar(bodyToEntity(request)));
	}

	private Equipo bodyToEntity(EquipoBody request) {
		return new Equipo(request.getId(), request.getNombreEquipo(), request.getColor(), request.getEstado());
	}

	@Override
	public List<EquipoResponse> listarEquipoResponse() {
		return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
	};

	private EquipoResponse transformToResponse(Equipo equipo) {
		return new EquipoResponse(equipo.getIdEquipo(), equipo.getNombreEquipo(), equipo.getColor(),
				equipo.getEstado());
	}

	@Override
	public List<EquipoResponse> listarEquipoPorEstado(Boolean estado) {
		
		return repo.findByEstado(estado).stream().map(this::transformToResponse).collect(Collectors.toList());
	}
}
