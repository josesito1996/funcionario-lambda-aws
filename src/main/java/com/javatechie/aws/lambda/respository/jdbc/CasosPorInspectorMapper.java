package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.CasosPorInspectorQuery;

public class CasosPorInspectorMapper implements RowMapper<CasosPorInspectorQuery> {

    @Override
    public CasosPorInspectorQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return CasosPorInspectorQuery.builder()
                .ordenInspeccion(rs.getString("orden_inspeccion"))
                .razonSocial(rs.getString("razon_social"))
                .fechaAsignacion(rs.getString("fecha_asignacion"))
                .build();
    }

}
