package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorAnioQuery;

public class InspeccionesPorAnioMapper implements RowMapper<InspeccionesPorAnioQuery> {

	@Override
	public InspeccionesPorAnioQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return InspeccionesPorAnioQuery.builder()
				.anio(rs.getInt("año"))
				.cantidad(rs.getInt("cantidad"))
				.build();
	}

}
