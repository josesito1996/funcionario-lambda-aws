package com.javatechie.aws.lambda.respository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;


@Repository
public class InspectorJdbc {

    private static final String SQL_QUERY = "select"
            + " DISTINCT TRIM(inspector_asignado)"
            + " as nombreInspector from inspectores"
            + " ORDER BY inspector_asignado asc;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<InspectorQuery> inspectores() {
        return jdbcTemplate.query(SQL_QUERY, new InspectorQueryMapper());
    }

}
