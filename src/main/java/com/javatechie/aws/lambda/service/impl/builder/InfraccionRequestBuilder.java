package com.javatechie.aws.lambda.service.impl.builder;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;

@Component
public class InfraccionRequestBuilder {

    public List<Infraccion> infraccionListBuilder(List<InfraccionRequestBody> request) {
        return request.stream().map(this::transformInfraccion).collect(Collectors.toList());
    }

    private Infraccion transformInfraccion(InfraccionRequestBody request) {
        return Infraccion.builder().baseLegal(request.getBaseLegal())
                .descripcion(request.getDescripcion()).idMateria(request.getIdMateria())
                .gravedad(request.getGravedad()).subMateria(request.getSubMateria()).build();
    }
}
