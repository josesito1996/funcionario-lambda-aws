package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorInstanciaQuery;
import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorLocalidadQuery;
import com.javatechie.aws.lambda.domain.jdbc.ResolucionesRecientesAgregadasQuery;
import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSenaladasQuery;
import com.javatechie.aws.lambda.domain.response.EvolucionUltimosMesesResponse;
import com.javatechie.aws.lambda.service.JurisprudenciaService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api-jurisprudencia")
@Slf4j
public class JurisprudenciaController {

    @Autowired
    private JurisprudenciaService service;

    @GetMapping(path = "/evolutionRecentMonths")
    public List<EvolucionUltimosMesesResponse> evolucionUltimosMesesQueries() {
        log.info("JurisprudenciaController.evolucionUltimosMesesQueries");
        return service.evolucionUltimosMesesQueries();
    }

    @GetMapping(path = "/subjectsMostIndicated")
    public List<SubMateriasMasSenaladasQuery> subMateriasMasSeñaladasQueries() {
        log.info("JurisprudenciaController.subMateriasMasSeñaladasQueries");
        return service.subMateriasMasSeñaladasQueries();
    }

    @GetMapping(path = "/resolutionsByLocation")
    public List<ResolucionesPorLocalidadQuery> resolucionesPorLocalidadQueries() {
        return service.resolucionesPorLocalidadQueries();
    }

    @GetMapping(path = "/resolutionsByIntance")
    public ResolucionesPorInstanciaQuery resolucionesPorInstanciaQueries() {
        return service.resolucionesPorInstanciaQueries();
    }

    @GetMapping(path = "/recentResolutionsAdded/{semanas}")
    public ResolucionesRecientesAgregadasQuery resolucionesRecientesAgregadasQuery(
            @PathVariable(name = "semanas") Integer semanas) {
        return service.resolucionesRecientesAgregadasQuery(semanas);
    }

}
