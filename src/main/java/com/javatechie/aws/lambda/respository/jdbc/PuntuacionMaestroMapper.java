package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;

public class PuntuacionMaestroMapper implements RowMapper<PuntuacionMaestro> {

    @Override
    public PuntuacionMaestro mapRow(ResultSet rs, int rowNum) throws SQLException {

        return PuntuacionMaestro.builder().idItem(rs.getInt(1)).itemValoracion(rs.getString(2))
                .puntajeMaximo(rs.getInt(3)).estado(rs.getBoolean(4)).build();
    }

}
