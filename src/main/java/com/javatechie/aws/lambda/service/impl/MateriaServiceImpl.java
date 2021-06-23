package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.request.MateriaBody;
import com.javatechie.aws.lambda.domain.response.MateriaResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoMateria;
import com.javatechie.aws.lambda.service.MateriaService;

@Service
public class MateriaServiceImpl extends CrudImpl<Materia, String> implements MateriaService {

	@Autowired
	private RepoMateria repo;

	@Override
	public MateriaResponse registrar(MateriaBody request) {

		return transformToResponse(registrar(bodyToEntity(request)));
	}

	@Override
	protected GenericRepo<Materia, String> getRepo() {

		return repo;
	}

	@Override
	public MateriaResponse verPorIdMateria(String id) {
		Optional<Materia> option = verPorId(id);
		return option.isPresent() ? transformToResponse(option.get()) : new MateriaResponse();
	}

	@Override
	public MateriaResponse actualizar(MateriaBody request) {

		return transformToResponse(modificar(bodyToEntity(request)));
	}

	private Materia bodyToEntity(MateriaBody request) {
		return new Materia(request.getIdMateria(), request.getNombreMateria(), request.getColor(), request.getIcono(),
				request.getEstado());
	}

	@Override
	public List<MateriaResponse> ListarMateriaResponse() {
		return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
	};

	private MateriaResponse transformToResponse(Materia materia) {
		return new MateriaResponse(materia.getIdMateria(), materia.getNombreMateria(), materia.getColor(),
				materia.getIcono(), materia.getEstado());
	}

	@Override
	public List<MateriaResponse> listarMateriasPorEstado(Boolean estado) {
		return repo.findByEstado(true).stream().map(this::transformToResponse).collect(Collectors.toList());
	}
}
