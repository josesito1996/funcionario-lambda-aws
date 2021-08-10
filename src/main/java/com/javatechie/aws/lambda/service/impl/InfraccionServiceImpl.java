package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.infraccionResponseProccesor;

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
    public List<Infraccion> verPorIdMateria(String idMateria) {
        return repo.findByIdMateria(idMateria);
    }

    @Override
    public List<InfraccionResponse> registrarInfraccion(List<InfraccionRequestBody> request) {
        return registrarMasivo(builder.infraccionListBuilder(request)).stream()
                .map(infraccion -> infraccionResponseProccesor(infraccion))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfraccionResponse> listarInfracciones() {
        return listar().stream().map(infraccion -> infraccionResponseProccesor(infraccion))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubMateriaResponse> listarSubMateriasPorIdMateria(String idMateria) {
        return verPorIdMateria(idMateria).stream().map(this::getSubmateriaResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Infraccion> verPorIdMateriaYPrioridad(String idMateria, Boolean prioridad) {
        return repo.findByIdMateriaAndPrioridad(idMateria, prioridad);
    }

    private SubMateriaResponse getSubmateriaResponse(Infraccion infraccion) {
        return SubMateriaResponse.builder()
                .idSubMateria(infraccion.getIdInfraccion())
                .subMateria(infraccion.getSubMateria()).build();
    }
}
