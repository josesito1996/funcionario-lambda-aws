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
import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;
import com.javatechie.aws.lambda.domain.request.InspectorBody;
import com.javatechie.aws.lambda.domain.request.InspectorUpdateRequest;
import com.javatechie.aws.lambda.domain.response.CaseByInspectorResponse;
import com.javatechie.aws.lambda.domain.response.ContactResponse;
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

@Service
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
        return new InspectorResponse(inspector.getId(), inspector.getNombreInspector(),
                inspector.getTipo(), inspector.getEstado());
    }

    private Inspector bodyToEntity(InspectorBody request) {

        return Inspector.builder().id(request.getId()).nombreInspector(request.getNombreInspector())
                .tipo(request.getTipoInspector()).estado(request.getEstado()).build();
    }

    @Override
    public List<ReactSelectResponse> listarInspectoresPorTipo(String tipo) {
        List<ReactSelectResponse> list = repo.findByTipoAndEstado(tipo, true).stream()
                .map(this::reactREponse).collect(Collectors.toList());
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

    @Override
    public List<CasosPorInspectorQuery> storedProcedure(String isnpectorName) {

        return inspectorJdbc.listar(isnpectorName);
    }

    @Override
    public CaseByInspectorResponse casosPorInspector(String idInspector) {
        Inspector inspector = buscarPorId(idInspector);
        String nombreInspector = inspector.getNombreInspector();
        List<CasosPorInspectorQuery> casosInspector = storedProcedure(nombreInspector);
        List<RecentCaseResponse> recentCases = new ArrayList<RecentCaseResponse>();
        if (!casosInspector.isEmpty()) {
            int limit = 4;
            int contador = 0;
            for (CasosPorInspectorQuery caso : casosInspector) {
                if (contador < limit) {
                    recentCases.add(RecentCaseResponse.builder()
                            .caseName(separadorDeCadenas(caso.getRazonSocial(), "/", 1))
                            .date(caso.getFechaAsignacion())
                            .inspectionOrder(caso.getOrdenInspeccion()).build());
                }
                contador++;
            }
        }
        return CaseByInspectorResponse.builder()
                .hasDataContact(inspector.getCorreo() != null && inspector.getTelefono() != null)
                .casesFound(casosInspector.size())
                .contact(ContactResponse.builder().email(inspector.getCorreo())
                        .phone(inspector.getTelefono()).build())
                .name(inspector.getNombreInspector()).position(inspector.getCargo())
                .score(transformScoreResponse(
                        puntuacionService.listarPromedioPuntajeInspector(idInspector)))
                .recentCases(recentCases).build();
    }

    private List<ScoreResponse> transformScoreResponse(List<PromedioPuntajeInspectorQuery> queryList) {
        return queryList.stream().map(this::transformScoreResponse).collect(Collectors.toList());
    }
    
    private ScoreResponse transformScoreResponse(PromedioPuntajeInspectorQuery query) {
        return ScoreResponse.builder()
                .itemScore(query.getItemScore())
                .max(query.getMax())
                .score(query.getScore())
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
}
