package com.javatechie.aws.lambda.service.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.PuntuacionInspector;
import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;
import com.javatechie.aws.lambda.domain.request.PuntajeRequest;
import com.javatechie.aws.lambda.domain.request.PuntuacionRequest;
import com.javatechie.aws.lambda.respository.jdbc.PuntuacionJdbc;
import com.javatechie.aws.lambda.service.PuntuacionService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PuntuacionServiceImpl implements PuntuacionService {

    @Autowired
    PuntuacionJdbc puntuacionJdbc;

    @Override
    public PuntuacionMaestro verPorId(int idMaestro) {
        log.info("PuntuacionServiceImpl.verPorId");
        return puntuacionJdbc.verPorId(idMaestro);
    }

    @Override
    public PuntuacionMaestro insertarPuntuacionMaestro(PuntuacionMaestro puntuacion) {
        log.info("PuntuacionServiceImpl.insertarPuntuacionMaestro");
        return puntuacionJdbc.insertarPuntuacionMaestro(puntuacion);
    }

    @Override
    public int[][] registrarMasivoPuntuacionInspector(PuntuacionRequest request) {

        return puntuacionJdbc.insertarPuntuacionInspector(puntuacionInspectorBuilder(request));
    }

    private List<PuntuacionInspector> puntuacionInspectorBuilder(PuntuacionRequest request) {
        List<PuntuacionInspector> listPuntuaciones = new ArrayList<PuntuacionInspector>();
        for (PuntajeRequest puntaje : request.getPuntajes()) {
            listPuntuaciones.add(PuntuacionInspector.builder()
                    .userName(request.getUsuario())
                    .fechaRegistro(LocalDateTime.now())
                    .idInspector(request.getIdFuncionario())
                    .idPuntuacionMaestro(puntaje.getIdItem())
                    .calificacion(puntaje.getPuntaje())
                    .build());
        }
        return listPuntuaciones;
    }

    @Override
    public List<PuntuacionMaestro> listarPuntuacionMaestro() {
        return puntuacionJdbc.listarMaestroPuntuaciones();
    }

    @Override
    public List<PromedioPuntajeInspectorQuery> listarPromedioPuntajeInspector(String idInspector) {
        return puntuacionJdbc.listarPromedioPuntajeInspector(idInspector);
    }
}
