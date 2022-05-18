package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.EvolucionUltimosMesesQuery;

public class EvolucionUltimosMesesMapper implements RowMapper<EvolucionUltimosMesesQuery>{

    @Override
    public EvolucionUltimosMesesQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return EvolucionUltimosMesesQuery.builder()
                .año(rs.getInt("año"))
                .mes(rs.getInt("mes"))
                .cantidad(rs.getInt("cantidad"))
                .build();
    }

}
