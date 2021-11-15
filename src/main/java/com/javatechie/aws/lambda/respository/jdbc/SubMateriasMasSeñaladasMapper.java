package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.SubMateriasMasSeñaladasQuery;


public class SubMateriasMasSeñaladasMapper implements RowMapper<SubMateriasMasSeñaladasQuery>{

    @Override
    public SubMateriasMasSeñaladasQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
        return SubMateriasMasSeñaladasQuery.builder()
                .subMateria(rs.getString("sub_materia_inspeccion"))
                .cantidad(rs.getDouble("cantidad"))
                .build();
    }

}
