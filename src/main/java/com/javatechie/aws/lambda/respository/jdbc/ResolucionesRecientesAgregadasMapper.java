package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.ResolucionesRecientesAgregadasQuery;

public class ResolucionesRecientesAgregadasMapper implements RowMapper<ResolucionesRecientesAgregadasQuery> {

    @Override
    public ResolucionesRecientesAgregadasQuery mapRow(ResultSet rs, int rowNum)
            throws SQLException {
        return ResolucionesRecientesAgregadasQuery.builder()
                .cantidad(rs.getInt("ultimas_resoluciones"))
                .build();
    }

}
