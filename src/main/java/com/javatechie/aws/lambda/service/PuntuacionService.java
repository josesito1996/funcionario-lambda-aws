package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;
import com.javatechie.aws.lambda.domain.request.PuntuacionRequest;

public interface PuntuacionService {

    public PuntuacionMaestro verPorId(int idMaestro);
    
    public PuntuacionMaestro insertarPuntuacionMaestro(PuntuacionMaestro puntuacion);
    
    public int [][] registrarMasivoPuntuacionInspector(PuntuacionRequest puntuacionInspectores);
    
}
