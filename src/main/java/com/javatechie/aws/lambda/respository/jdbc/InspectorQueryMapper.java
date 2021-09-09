package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;


public class InspectorQueryMapper implements RowMapper<InspectorQuery> {

    @Override
    public InspectorQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return InspectorQuery.builder()
                .index(rowNum + 1)
                .nombreInspector(rs.getString("nombreInspector"))
                .build();
    }

}
