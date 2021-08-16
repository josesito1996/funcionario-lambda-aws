package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;

public interface InfraccionService extends ICrud<Infraccion, String> {

    List<Infraccion> verPorIdMateria(String idMateria);
    
    List<Infraccion> verPorIdSubMateria(String idSubMateria);
    
    List<Infraccion> verPorIdMateriaYPrioridad(String idMateria, Boolean prioridad);
    
    List<SubMateriaResponse> listarSubMateriasPorIdMateria(String idMateria);

    List<InfraccionResponse> listarInfracciones();

    List<InfraccionResponse> registrarInfraccion(List<InfraccionRequestBody> request);
}
