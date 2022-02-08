package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorAñoQuery;

public class InspeccionesPorAñoMapper implements RowMapper<InspeccionesPorAñoQuery> {

	@Override
	public InspeccionesPorAñoQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return InspeccionesPorAñoQuery.builder()
				.año(rs.getInt("año"))
				.cantidad(rs.getInt("cantidad"))
				.build();
	}

}
