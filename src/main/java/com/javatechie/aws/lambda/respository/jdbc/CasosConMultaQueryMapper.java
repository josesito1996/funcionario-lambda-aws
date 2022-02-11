package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.CasosConMultaQuery;

public class CasosConMultaQueryMapper implements RowMapper<CasosConMultaQuery> {

	@Override
	public CasosConMultaQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return CasosConMultaQuery.builder()
				.cantidadMulta(rs.getInt("cantidad_multa"))
				.cantidadSinMulta(rs.getInt("cantidad_sin_multa"))
				.cantidadTotal(rs.getInt("cantidad_total"))
				.build();
	}

}
