package com.javatechie.aws.lambda.service;

import java.util.List;

import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorLocalidadQuery;
import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSeñaladasQuery;
import com.javatechie.aws.lambda.domain.response.EvolucionUltimosMesesResponse;

public interface JurisprudenciaService {

    public List<EvolucionUltimosMesesResponse> evolucionUltimosMesesQueries();
    
    public List<SubMateriasMasSeñaladasQuery> subMateriasMasSeñaladasQueries();
    
    public List<ResolucionesPorLocalidadQuery> resolucionesPorLocalidadQueries();
    
}
