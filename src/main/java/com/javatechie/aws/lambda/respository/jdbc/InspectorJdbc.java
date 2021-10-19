package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.CasosPorInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspectorQuery;

@Repository
public class InspectorJdbc {

    private static final String SQL_QUERY = "select" + " DISTINCT TRIM(inspector_asignado)"
            + " as nombreInspector from inspectores" + " ORDER BY inspector_asignado asc;";

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<InspectorQuery> inspectores() {
        return jdbcTemplate.query(SQL_QUERY, new InspectorQueryMapper());
    }

    public List<CasosPorInspectorQuery> listar(String inspectorAsignado) {
        List<SqlParameter> parameters = Arrays.asList(new SqlParameter(Types.NVARCHAR));
        return transformToList(jdbcTemplate.call(new CallableStatementCreator() {
            @Override
            public CallableStatement createCallableStatement(Connection con) throws SQLException {
                CallableStatement cs = con.prepareCall("{call SP_listar_casos_por_inspector(?)}");
                cs.setString(1, inspectorAsignado);
                return cs;
            }
        }, parameters));
    }

    @SuppressWarnings("unchecked")
    private List<CasosPorInspectorQuery> transformToList(Map<String, Object> mapResult) {
        if (mapResult.isEmpty()) {
            return new ArrayList<CasosPorInspectorQuery>();
        }
        List<CasosPorInspectorQuery> lista = new ArrayList<CasosPorInspectorQuery>();
        Object result = mapResult.get("#result-set-1");
        if (result instanceof List) {
            List<Map<String, Object>> newList = (List<Map<String, Object>>) result;
            for (Map<String, Object> map : newList) {
                lista.add(CasosPorInspectorQuery.builder()
                        .ordenInspeccion(map.get("orden_inspeccion").toString())
                        .cantidadInfracciones(Integer.parseInt(map.get("cantidad_infracciones").toString()))
                        .fechaAsignacion(map.get("fecha_asignacion").toString())
                        .razonSocial(map.get("razon_social").toString()).build());
            }
        }
        return lista;
    }

}
