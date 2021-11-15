package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.convertirNumeroAMes;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.jdbc.EvolucionUltimosMesesQuery;
import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorLocalidadQuery;
import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSenaladasQuery;
import com.javatechie.aws.lambda.domain.response.EvolucionUltimosMesesResponse;
import com.javatechie.aws.lambda.respository.jdbc.JurisprudenciaJdbc;
import com.javatechie.aws.lambda.service.JurisprudenciaService;

@Service
public class JurisprudenciaServiceImpl implements JurisprudenciaService {

    @Autowired
    JurisprudenciaJdbc jdbc;

    @Override
    public List<EvolucionUltimosMesesResponse> evolucionUltimosMesesQueries() {

        return jdbc.evolucionUltimosMesesQuerys().stream().map(this::transformToResponse)
                .collect(Collectors.toList());
    }

    private EvolucionUltimosMesesResponse transformToResponse(EvolucionUltimosMesesQuery query) {
        return EvolucionUltimosMesesResponse.builder()
                .mes(convertirNumeroAMes(query.getMes()))
                .cantidad(query.getCantidad())
                .build();
    }

    @Override
    public List<SubMateriasMasSenaladasQuery> subMateriasMasSeñaladasQueries() {
        return jdbc.subMateriasMasSeñaladasQueries();
    }

    @Override
    public List<ResolucionesPorLocalidadQuery> resolucionesPorLocalidadQueries() {
        return jdbc.resolucionesPorLocalidadQueries();
    }

}
