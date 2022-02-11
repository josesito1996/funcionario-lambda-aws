package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.CasosConMultaQuery;

public class CasosConMultaQueryMapper implements RowMapper<CasosConMultaQuery> {

	@Override
	public CasosConMultaQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return CasosConMultaQuery.builder()
				.nroOrdenInspeccion(rs.getString("orden_inspeccion"))
				.totalMulta(rs.getInt("cantidad_infracciones"))
				.build();
	}

}
