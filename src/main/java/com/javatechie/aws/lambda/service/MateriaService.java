package com.javatechie.aws.lambda.service;

import java.util.List;
import java.util.Map;

import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.request.MateriaBody;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequestBody;
import com.javatechie.aws.lambda.domain.response.MateriaResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public interface MateriaService extends ICrud<Materia, String> {

    List<ReactSelectResponse> listarReactSelect();
    
    Materia buscarPorIdMateria(String idMateria);

    MateriaResponse registrar(MateriaBody request);

    MateriaResponse actualizar(MateriaBody request);

    MateriaResponse verPorIdMateria(String id);

    List<MateriaResponse> ListarMateriaResponse();

    List<MateriaResponse> ListarMateriasYSubmaterias();

    List<MateriaResponse> listarMateriasPorEstado(Boolean estado);

    List<Map<String, Object>> verSubMaterias(SubMateriaRequestBody request);
    
    List<ReactSelectResponse> listarInfraccionesParaReactSelect(List<SubMateria> subMaterias);
    
    List<Object> materiaPieChartResponses();
    
    List<Object> materiaPieChartSancionadasResponses();
}
