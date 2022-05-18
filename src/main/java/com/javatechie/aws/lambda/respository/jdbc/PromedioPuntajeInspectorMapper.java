package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;

public class PromedioPuntajeInspectorMapper implements RowMapper<PromedioPuntajeInspectorQuery> {

    @Override
    public PromedioPuntajeInspectorQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        
        return PromedioPuntajeInspectorQuery.builder()
        		.idItem(rs.getInt("id_item"))
                .itemScore(rs.getString("itemScore"))
                .max(rs.getInt("max"))
                .score(rs.getInt("score"))
                .build();
    }

}
