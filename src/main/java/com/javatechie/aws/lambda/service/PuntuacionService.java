package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;
import com.javatechie.aws.lambda.domain.request.PuntuacionRequest;

public interface PuntuacionService {

    public PuntuacionMaestro verPorId(int idMaestro);
    
    public PuntuacionMaestro insertarPuntuacionMaestro(PuntuacionMaestro puntuacion);
    
    public List<PuntuacionMaestro> listarPuntuacionMaestro();
    
    public List<PromedioPuntajeInspectorQuery> listarPromedioPuntajeInspector(String idInspector);
    
    public int [][] registrarMasivoPuntuacionInspector(PuntuacionRequest puntuacionInspectores);
    
}
