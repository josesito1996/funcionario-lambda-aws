package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequest;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseBody;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;

public interface SubMateriaService extends ICrud<SubMateria, String> {

    public SubMateria buscarPorIdSubMateria(String idSubMateria);

    public List<SubMateria> listarPorIdMateriaYPrioridad(String idMateria, Boolean prioridad);
    
    public List<SubMateria> listarPorIdMateria(String idMateria);

    List<SubMateriaResponse> registrarInfraccion(List<SubMateriaRequest> request);
    
    InfraccionResponseBody infraccionResponseBodyByIdSubMateria(String idSubMateria);
}
