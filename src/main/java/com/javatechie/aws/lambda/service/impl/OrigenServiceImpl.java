package com.javatechie.aws.lambda.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Origen;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoOrigen;
import com.javatechie.aws.lambda.service.OrigenService;

@Service
public class OrigenServiceImpl extends CrudImpl<Origen, String> implements OrigenService {

    @Autowired
    private RepoOrigen repo;
    
    @Override
    public Origen buscarPorId(String idOrigen) {
        Optional<Origen> origenOptional = verPorId(idOrigen);
        if (!origenOptional.isPresent()) {
            throw new NotFoundException("No hay ningun registro con el ID : " + idOrigen);
        }
        return origenOptional.get();
    }

    @Override
    protected GenericRepo<Origen, String> getRepo() {
        return repo;
    }

    @Override
    public List<ReactSelectResponse> listarSelect() {
        List<Origen> origenes = listar();
        List<ReactSelectResponse> newList = new ArrayList<ReactSelectResponse>();
        for (Origen origen : origenes) {
            newList.add(new ReactSelectResponse(origen.getIdOrigen(), origen.getNombreOrigen(), null));
        }
        return newList;
    }

}
