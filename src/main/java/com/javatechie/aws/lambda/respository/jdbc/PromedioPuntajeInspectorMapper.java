package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;

public class PromedioPuntajeInspectorMapper implements RowMapper<PromedioPuntajeInspectorQuery> {

    @Override
    public PromedioPuntajeInspectorQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return PromedioPuntajeInspectorQuery.builder()
                .itemScore(rs.getString(1))
                .max(rs.getInt(2))
                .score(rs.getInt(3))
                .build();
    }

}
