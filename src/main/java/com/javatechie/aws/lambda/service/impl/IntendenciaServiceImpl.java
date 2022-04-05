package com.javatechie.aws.lambda.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Intendencia;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoIntendencia;
import com.javatechie.aws.lambda.service.IntendenciaService;

@Service
public class IntendenciaServiceImpl extends CrudImpl<Intendencia, String> implements IntendenciaService {

	@Autowired
	private RepoIntendencia repo;

	@Override
	protected GenericRepo<Intendencia, String> getRepo() {
		return repo;
	}

	@Override
	public List<ReactSelectResponse> listIntendencias() {

		return listar().stream().filter(item -> !item.getNoMostrar()).map(item -> {
			String departamento = item.getOficina().equals("Zona de Trabajo de Ancash (Chimbote)")
					? "Ancash (Chimbote)"
					: item.getDepartamento();
			return new ReactSelectResponse(item.getIdIntendencia(), departamento, null, null);
		}).sorted(Comparator.comparing(ReactSelectResponse::getLabel)).collect(Collectors.toList());
	}

}
