package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.fechaFormateadaOther;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Comentario;
import com.javatechie.aws.lambda.domain.request.ComentarioInspectorCreateRequestBody;
import com.javatechie.aws.lambda.domain.response.ComentarioResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoComentario;
import com.javatechie.aws.lambda.service.ComentarioService;

@Service
public class ComentarioServiceImpl extends CrudImpl<Comentario, String> implements ComentarioService {

	@Autowired
	private RepoComentario repo;

	@Override
	protected GenericRepo<Comentario, String> getRepo() {
		return repo;
	}

	@Override
	public List<Comentario> buscarPorIdentificador(String identificador) {

		return repo.findByIdentificador(identificador);
	}

	@Override
	public List<ComentarioResponse> listarPorIdFuncionario(String id) {

		return buscarPorIdentificador(id).stream().sorted(Comparator.comparing(Comentario::getFechaRegistro).reversed())
				.map(this::transformToResponse).collect(Collectors.toList());
	}

	@Override
	public ComentarioResponse registrarComentarioInspector(ComentarioInspectorCreateRequestBody request) {
		return transformToResponse(registrar(transformFromRequest(request)));
	}

	private ComentarioResponse transformToResponse(Comentario item) {
		return ComentarioResponse.builder().id(item.getIdComentario()).text(item.getComentario())
				.fecha(fechaFormateadaOther(item.getFechaRegistro())).cantStars(item.getPuntuacion()).build();
	}

	private Comentario transformFromRequest(ComentarioInspectorCreateRequestBody request) {
		return Comentario.builder().fechaRegistro(LocalDateTime.now()).usuario(request.getUsuario())
				.identificador(request.getIdFuncionario()).comentario(request.getComentario())
				.puntuacion(request.getPuntuacion()).activo(true).build();
	}

}
