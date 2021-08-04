package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoInfraccion;
import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.impl.builder.InfraccionRequestBuilder;

@Service
public class InfraccionServiceImpl extends CrudImpl<Infraccion, String>
        implements InfraccionService {

    @Autowired
    private RepoInfraccion repo;

    @Autowired
    private InfraccionRequestBuilder builder;

    @Override
    protected GenericRepo<Infraccion, String> getRepo() {
        return repo;
    }

    @Override
    public List<InfraccionResponse> registrarInfraccion(List<InfraccionRequestBody> request) {
        return registrarMasivo(builder.infraccionListBuilder(request)).stream()
                .map(this::responseTransform).collect(Collectors.toList());
    }

    @Override
    public List<InfraccionResponse> listarInfracciones() {
        return listar().stream().map(this::responseTransform).collect(Collectors.toList());
    }

    @Override
    public List<SubMateriaResponse> listarSubMateriasPorIdMateria(String idMateria) {
        return repo.findByIdMateria(idMateria).stream().map(this::getSubmateriaResponse)
                .collect(Collectors.toList());
    }

    private InfraccionResponse responseTransform(Infraccion infraccion) {
        return InfraccionResponse.builder().idInfraccion(infraccion.getIdInfraccion())
                .baseLegal(infraccion.getBaseLegal()).subMateria(infraccion.getSubMateria())
                .build();
    }

    private SubMateriaResponse getSubmateriaResponse(Infraccion infraccion) {
        return SubMateriaResponse.builder()
                .baseLegal(infraccion.getBaseLegal())
                .descripcion(infraccion.getDescripcion())
                .gravedad(infraccion.getGravedad())
                .subMateria(infraccion.getSubMateria())
                .build();
    }

}
