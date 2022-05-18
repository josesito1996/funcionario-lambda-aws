package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;

public class ControlTotalesQueryMapper implements RowMapper<ControlTotalesQuery> {

	@Override
	public ControlTotalesQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return ControlTotalesQuery
				.builder()
				.totalInspecciones(rs.getInt("total_inspecciones"))
				.totalPrimera(rs.getInt("total_primera"))
				.totalSegunda(rs.getInt("total_segunda"))
				.totalTfl(rs.getInt("total_tfl"))
				.build();
	}

}
