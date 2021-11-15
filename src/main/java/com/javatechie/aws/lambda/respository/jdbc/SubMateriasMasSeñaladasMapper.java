package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSenaladasQuery;


public class SubMateriasMasSeñaladasMapper implements RowMapper<SubMateriasMasSenaladasQuery>{

    @Override
    public SubMateriasMasSenaladasQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SubMateriasMasSenaladasQuery.builder()
                .subMateria(rs.getString("sub_materia_inspeccion"))
                .cantidad(rs.getDouble("cantidad"))
                .build();
    }

}
