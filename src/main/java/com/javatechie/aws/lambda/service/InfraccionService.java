package com.javatechie.aws.lambda.service;

import java.util.List;
import java.util.Map;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseSelect;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.domain.response.custom.CustomSelectResponse;

public interface InfraccionService extends ICrud<Infraccion, String> {

    Infraccion verPorIdInfraccion(String idInfraccion);
    
    List<Infraccion> verPorIdMateria(String idMateria);
    
    List<Infraccion> verPorIdSubMateria(String idSubMateria);
    
    List<Infraccion> verPorIdMateriaYPrioridad(String idMateria, Boolean prioridad);
    
    List<SubMateriaResponse> listarSubMateriasPorIdMateria(String idMateria);

    List<InfraccionResponse> listarInfracciones();

    List<InfraccionResponse> registrarInfraccion(List<InfraccionRequestBody> request);
    
    List<InfraccionResponseSelect> listarSelectPorIdSubMateria(String idSubMateria);
    
    Map<String, Object> verGravedadPorIdInfraccion(String idInfraccion);
    
    Map<String, Object> listarSelectPorIdSubMateriaAux(String idSubMateria);
    
    CustomSelectResponse listarSelectPorIdSubMateriaAuxV2(String idSubMateria);
}
