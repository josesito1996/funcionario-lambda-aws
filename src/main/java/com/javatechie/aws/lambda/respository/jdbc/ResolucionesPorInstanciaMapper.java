package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.ResolucionesPorInstanciaQuery;

public class ResolucionesPorInstanciaMapper implements RowMapper<ResolucionesPorInstanciaQuery> {

    @Override
    public ResolucionesPorInstanciaQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return ResolucionesPorInstanciaQuery.builder().primera(rs.getInt("primera"))
                .segunda(rs.getInt("segunda")).tercera(rs.getInt("tercera")).build();
    }

}
