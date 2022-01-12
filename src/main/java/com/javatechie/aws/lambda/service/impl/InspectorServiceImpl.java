package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.separadorDeCadenas;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.jdbc.CasosPorInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspectorPorNombreQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;
import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.request.InspectorUpdateRequest;
import com.javatechie.aws.lambda.domain.response.CaseByInspectorResponse;
import com.javatechie.aws.lambda.domain.response.ContactResponse;
import com.javatechie.aws.lambda.domain.response.InspectorPorNombreResponse;
import com.javatechie.aws.lambda.domain.response.InspectorResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.RecentCaseResponse;
import com.javatechie.aws.lambda.domain.response.ScoreResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoInspector;
import com.javatechie.aws.lambda.respository.jdbc.InspectorJdbc;
import com.javatechie.aws.lambda.service.InspectorService;
import com.javatechie.aws.lambda.service.PuntuacionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class InspectorServiceImpl extends CrudImpl<Inspector, String> implements InspectorService {

	@Autowired
	private RepoInspector repo;

	@Autowired
	private InspectorJdbc inspectorJdbc;

	@Autowired
	private PuntuacionService puntuacionService;

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
		return InspectorResponse.builder().id(inspector.getId()).nombresApellidos(inspector.getNombreInspector())
				.tipoInspector(inspector.getTipo()).telefono(inspector.getTelefono()).correo(inspector.getCorreo())
				.estado(inspector.getEstado()).build();
	}

	private Inspector bodyToEntity(InspectorBody request) {

		return Inspector.builder().id(request.getId()).nombreInspector(request.getNombreInspector())
				.tipo(request.getTipoInspector()).estado(request.getEstado()).build();
	}

	@Override
	public List<ReactSelectResponse> listarInspectoresPorTipo(String tipo, String etapa) {
		List<ReactSelectResponse> list = new ArrayList<>();
		if (etapa != null) {
			list = repo.findByTipoAndEtapaAndEstado(tipo, etapa, true).stream().map(this::reactREponse)
					.sorted(Comparator.comparing(ReactSelectResponse::getLabel))
					.collect(Collectors.toList());
		} else {
			list = repo.findByTipoAndEstado(tipo, true).stream().map(this::reactREponse)
					.sorted(Comparator.comparing(ReactSelectResponse::getLabel))
					.collect(Collectors.toList());
		}
		return list;
	}

	private ReactSelectResponse reactREponse(Inspector inspector) {
		return new ReactSelectResponse(inspector.getId(), inspector.getNombreInspector(), null, null);
	}

	@Override
	public List<InspectorQuery> listarInspectoresJdbcAsc() {

		return inspectorJdbc.inspectores();
	}

	@Override
	public List<CasosPorInspectorQuery> storedProcedure(String isnpectorName) {

		return inspectorJdbc.listar(isnpectorName);
	}

	@Override
	public CaseByInspectorResponse casosPorInspector(String idInspector) {
		/**
		 * Se cambia el IdInspector por el nombre
		 */
		Inspector inspector = buscarPorNombre(idInspector);
		log.info("Inspector {}",inspector);
		String nombreInspector = inspector.getNombreInspector();
		List<CasosPorInspectorQuery> casosInspector = storedProcedure(nombreInspector);
		List<RecentCaseResponse> recentCases = new ArrayList<RecentCaseResponse>();
		log.info("Casos de BD : {}", casosInspector);
		int acumuladorMulta = 0;
		if (!casosInspector.isEmpty()) {
			int limit = 4;
			int contador = 0;
			for (CasosPorInspectorQuery caso : casosInspector) {
				if (contador < limit) {
					recentCases.add(RecentCaseResponse.builder()
							.caseName(separadorDeCadenas(caso.getRazonSocial(), "/", 1)).date(caso.getFechaAsignacion())
							.inspectionOrder(caso.getOrdenInspeccion()).build());
				}
				acumuladorMulta = acumuladorMulta + caso.getCantidadInfracciones();
				contador++;
			}
		}
		return CaseByInspectorResponse.builder()
				.idInspector(inspector.getId())
				.hasDataContact(inspector.getCorreo() != null && inspector.getTelefono() != null)
				.casesFound(casosInspector.size()).fineCases(acumuladorMulta)
				.contact(ContactResponse.builder().email(inspector.getCorreo()).phone(inspector.getTelefono()).build())
				.name(inspector.getNombreInspector()).position(inspector.getCargo())
				.score(transformScoreResponse(puntuacionService.listarPromedioPuntajeInspector(inspector.getId())))
				.recentCases(recentCases).build();
	}

	private List<ScoreResponse> transformScoreResponse(List<PromedioPuntajeInspectorQuery> queryList) {
		return queryList.stream().map(this::transformScoreResponse).collect(Collectors.toList());
	}

	private ScoreResponse transformScoreResponse(PromedioPuntajeInspectorQuery query) {
		return ScoreResponse.builder()
				.idItem(query.getIdItem())
				.itemScore(query.getItemScore()).max(query.getMax()).score(query.getScore())
				.build();
	}

	@Override
	public Inspector buscarPorId(String id) {
		Optional<Inspector> inspectorOp = verPorId(id);
		if (!inspectorOp.isPresent()) {
			throw new NotFoundException("Inspector con ID : " + id + " no existe.");
		}
		return inspectorOp.get();
	}

	@Override
	public InspectorResponse actualizar(InspectorUpdateRequest request) {
		Inspector inspector = buscarPorId(request.getIdInspector());
		inspector.setCorreo(request.getCorreo());
		inspector.setTelefono(request.getTelefono());
		inspector.setCargo(request.getNombreCargo());
		return transformToResponse(modificar(inspector));
	}

	@Override
	public Inspector buscarPorNombre(String nombreInspector) {
		return repo.findOneByNombreInspector(nombreInspector);
	}

	@Override
	public List<InspectorPorNombreResponse> inspectorPorNombreResponses(String nombreInspector) {
		List<InspectorPorNombreQuery> inspectores = inspectorJdbc.inspectorPorNombreQueries(nombreInspector);
		return inspectores.stream().map(item -> {
			return InspectorPorNombreResponse
					.builder()
					.nombreFuncionario(item.getNombreFuncionario())
					.cantidadCasos(item.getCantidadCasos())
					.fechaRegistro(item.getFechaAsignacion())
					.build();
		}).collect(Collectors.toList());
	}
}
