package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.responseChecksFilterEtapaActuacion;
import static com.javatechie.aws.lambda.util.ListUtils.selectResponseOrderByNroOrdenDesc;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Etapa;
import com.javatechie.aws.lambda.domain.request.EtapaBody;
import com.javatechie.aws.lambda.domain.response.EtapaResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoEtapa;
import com.javatechie.aws.lambda.service.EtapaService;

@Service
public class EtapaServiceImpl extends CrudImpl<Etapa, String> implements EtapaService {

    @Autowired
    private RepoEtapa repo;

    @Override
    public EtapaResponse registrar(EtapaBody request) {

        return transformToResponse(registrar(bodyToEntity(request)));
    }

    @Override
    protected GenericRepo<Etapa, String> getRepo() {

        return repo;
    }

    @Override
    public EtapaResponse verPorIdEtapa(String id) {
        Optional<Etapa> option = verPorId(id);
        return option.isPresent() ? transformToResponse(option.get()) : new EtapaResponse();
    }

    @Override
    public EtapaResponse actualizar(EtapaBody request) {

        return transformToResponse(modificar(bodyToEntity(request)));
    }

    private Etapa bodyToEntity(EtapaBody request) {
        return new Etapa(request.getIdEtapa(), request.getNombreEtapa(), request.getEstado(),
                request.getNroOrden());
    }

    @Override
    public List<EtapaResponse> ListarEtapaResponse() {
        return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
    };

    private EtapaResponse transformToResponse(Etapa etapa) {
        return new EtapaResponse(etapa.getIdEtapa(), etapa.getNombreEtapa(), etapa.getEstado(),
                etapa.getNroOrden());
    }

    @Override
    public List<EtapaResponse> ListarEtapaPorEstado(Boolean estado) {

        return repo.findByEstado(estado).stream().map(this::transformToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Etapa> listarTipoActuacionPorEstado(Boolean estado) {
        return repo.findByEstado(estado);
    }

    @Override
    public List<ReactSelectResponse> listarTipoActuacionParaReact() {
        return selectResponseOrderByNroOrdenDesc(listarTipoActuacionPorEstado(true).stream()
                .map(this::transformTo).collect(Collectors.toList()));
    }

    public ReactSelectResponse transformTo(Etapa etapa) {
        return new ReactSelectResponse(etapa.getIdEtapa(), etapa.getNombreEtapa(),
                etapa.getNroOrden(),null);
    }

    @Override
    public List<ReactSelectResponse> ListarEtapaResponseFilters() {
        List<EtapaResponse> list = ListarEtapaResponse();
        if (list.isEmpty()) {
            return responseChecksFilterEtapaActuacion(list);
        }
        list = list.stream().sorted(Comparator.comparing(EtapaResponse::getNroOrden))
                .collect(Collectors.toList());
        list.add(0, EtapaResponse.builder()
                .IdEtapa("0")
                .nombreEtapa("Todos")
                .build());
        return responseChecksFilterEtapaActuacion(list);
    }
}
