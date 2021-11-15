package com.javatechie.aws.lambda.respository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.EvolucionUltimosMesesQuery;
import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorLocalidadQuery;
import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSenaladasQuery;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class JurisprudenciaJdbc {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<EvolucionUltimosMesesQuery> evolucionUltimosMesesQuerys() {
        log.info("JurisprudenciaJdbc.evolucionUltimosMesesQuerys");
        return jdbcTemplate.query("call SP_evolucion_ultimos_meses()",
                new EvolucionUltimosMesesMapper());
    }
    
    public List<SubMateriasMasSenaladasQuery> subMateriasMasSeñaladasQueries(){
        log.info("JurisprudenciaJdbc.subMateriasMasSeñaladasQueries");
        return jdbcTemplate.query("call SP_subMaterias_mas_senaladas()", new SubMateriasMasSeñaladasMapper());
    }
    
    public List<ResolucionesPorLocalidadQuery> resolucionesPorLocalidadQueries(){
        return jdbcTemplate.query("call SP_resoluciones_por_localidad()", new ResolucionesPorLocalidadMapper());
    }

}
