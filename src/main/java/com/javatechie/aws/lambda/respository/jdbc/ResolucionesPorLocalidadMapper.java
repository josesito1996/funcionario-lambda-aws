package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorLocalidadQuery;

public class ResolucionesPorLocalidadMapper implements RowMapper<ResolucionesPorLocalidadQuery> {

    @Override
    public ResolucionesPorLocalidadQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ResolucionesPorLocalidadQuery.builder()
                .indice(rowNum)
                .departamento(rs.getString("departamento"))
                .cantidad(rs.getInt("cantidad"))
                .build();
    }

}
