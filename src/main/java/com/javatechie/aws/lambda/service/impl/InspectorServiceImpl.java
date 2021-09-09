package com.javatechie.aws.lambda.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;
import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.response.InspectorResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoInspector;
import com.javatechie.aws.lambda.respository.jdbc.InspectorJdbc;
import com.javatechie.aws.lambda.service.InspectorService;

@Service
public class InspectorServiceImpl extends CrudImpl<Inspector, String> implements InspectorService {

	@Autowired
	private RepoInspector repo;
	
	@Autowired
	private InspectorJdbc inspectorJdbc;

	@Override
	public InspectorResponse registrar(InspectorBody request) {

		return transformToResponse(registrar(bodyToEntity(request)));
	}

	@Override
	protected GenericRepo<Inspector, String> getRepo() {

		return repo;
	}

	@Override
	public InspectorResponse verPorIdInspector(String id) {
		Optional<Inspector> option = verPorId(id);
		return option.isPresent() ? transformToResponse(option.get()) : new InspectorResponse();
	}

	@Override
	public InspectorResponse actualizar(InspectorBody request) {

		return transformToResponse(modificar(bodyToEntity(request)));
	}

	@Override
	public List<InspectorResponse> listarInspectores() {
		return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
	};

	@Override
	public List<InspectorResponse> buscarPorNombreFiltro(String nombreInspector, String tipo) {
		return repo.findByNombreInspectorContaining(nombreInspector).stream()
				.filter(inspector -> inspector.getEstado() && inspector.getTipo().equals(tipo))
				.map(this::transformToResponse).collect(Collectors.toList());
	}

	private InspectorResponse transformToResponse(Inspector inspector) {
		return new InspectorResponse(inspector.getId(), inspector.getNombreInspector(), inspector.getTipo(),inspector.getEstado());
	}

	private Inspector bodyToEntity(InspectorBody request) {
	    
		return Inspector.builder()
		        .id(request.getId())
		        .nombreInspector(request.getNombreInspector())
		        .tipo(request.getTipoInspector())
		        .estado(request.getEstado())
		        .build();
	}

	@Override
	public List<ReactSelectResponse> listarInspectoresPorTipo(String tipo) {
		List<ReactSelectResponse> list = repo.findByTipoAndEstado(tipo, true).stream().map(this::reactREponse).collect(Collectors.toList());
		list.sort(Comparator.comparing(ReactSelectResponse::getLabel));
		return list;
	}
	
	private ReactSelectResponse reactREponse(Inspector inspector) {
		return new ReactSelectResponse(inspector.getId(), inspector.getNombreInspector(), null);
	}

    @Override
    public List<InspectorQuery> listarInspectoresJdbcAsc() {
        
        return inspectorJdbc.inspectores();
    }

}
