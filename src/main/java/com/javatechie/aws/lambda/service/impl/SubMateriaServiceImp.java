package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequest;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoSubMateria;
import com.javatechie.aws.lambda.service.SubMateriaService;

@Service
public class SubMateriaServiceImp extends CrudImpl<SubMateria, String>
        implements SubMateriaService {

    @Autowired
    private RepoSubMateria repo;

    @Override
    public SubMateria buscarPorIdSubMateria(String idSubMateria) {
        Optional<SubMateria> optional = verPorId(idSubMateria);
        if (!optional.isPresent()) {
            throw new NotFoundException("SubMateria no existe : " + idSubMateria);
        }
        return optional.get();
    }

    @Override
    protected GenericRepo<SubMateria, String> getRepo() {
        return repo;
    }

    @Override
    public List<SubMateria> listarPorIdMateriaYPrioridad(String idMateria, Boolean prioridad) {
        return repo.findByIdMateriaAndPrioridad(idMateria, prioridad);
    }

    @Override
    public List<SubMateriaResponse> registrarInfraccion(List<SubMateriaRequest> request) {
        return registrarMasivo(toSubMateriaList(request)).stream().map(this::toSubMateriaResponse)
                .collect(Collectors.toList());
    }

    private SubMateriaResponse toSubMateriaResponse(SubMateria response) {
        return SubMateriaResponse.builder().idSubMateria(response.getIdSubMateria())
                .subMateria(response.getNombreSubMateria()).build();
    }

    private List<SubMateria> toSubMateriaList(List<SubMateriaRequest> request) {
        return request.stream().map(this::toSubMateria).collect(Collectors.toList());
    }

    private SubMateria toSubMateria(SubMateriaRequest request) {
        return SubMateria.builder().idSubMateria(request.getIdSubMateria())
                .idMateria(request.getIdMateria()).nombreSubMateria(request.getNombreSubMateria())
                .prioridad(request.getPrioridad()).build();
    }

    @Override
    public List<SubMateria> listarPorIdMateria(String idMateria) {
        return repo.findByIdMateria(idMateria);
    }
}
