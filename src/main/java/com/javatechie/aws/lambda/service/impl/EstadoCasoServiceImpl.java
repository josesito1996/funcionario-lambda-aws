package com.javatechie.aws.lambda.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.EstadoCaso;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoEstadoCaso;
import com.javatechie.aws.lambda.service.EstadoCasoService;

@Service
public class EstadoCasoServiceImpl extends CrudImpl<EstadoCaso, String> implements EstadoCasoService {

	@Autowired
	private RepoEstadoCaso repo;

	@Override
	protected GenericRepo<EstadoCaso, String> getRepo() {

		return repo;
	}

	@Override
	public List<EstadoCaso> listarActivos(Boolean estado) {

		return repo.findByEstado(estado);
	}

	@Override
	public List<ReactSelectResponse> listEstadosCasoByEstado(Boolean estado) {

		return listarActivos(estado).stream()
				.sorted(Comparator.comparing(EstadoCaso::getOrden))
				.map(this::transformReactSelect)
				.collect(Collectors.toList());
	}

	private ReactSelectResponse transformReactSelect(EstadoCaso estadoCaso) {
		ReactSelectResponse response = new ReactSelectResponse();
		response.setLabel(estadoCaso.getOrden() + " - " + estadoCaso.getNombreEstado());
		response.setValue(estadoCaso.getIdEstadoCaso());
		response.setCampoAux(estadoCaso.getOrden().toString());
		return response;
	}
}
