package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.TipoTarea;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoTipoTarea;
import com.javatechie.aws.lambda.service.TipoTareaService;

@Service
public class TipoTareaServiceImpl extends CrudImpl<TipoTarea, String> implements TipoTareaService {

    @Autowired
    private RepoTipoTarea repo;

    @Override
    protected GenericRepo<TipoTarea, String> getRepo() {
        return repo;
    }

    @Override
    public List<ReactSelectResponse> listarEtapasTarea() {
        return repo.findByEstado(true).stream().map(this::transformReactSelectResponse)
                .collect(Collectors.toList());
    }

    private ReactSelectResponse transformReactSelectResponse(TipoTarea tipo) {
        return new ReactSelectResponse(tipo.getIdTipoTarea(), tipo.getNombreTipo(), null);
    }
}
