package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorMesQuery;

public class InspeccionesPorMesMapper implements RowMapper<InspeccionesPorMesQuery> {

	@Override
	public InspeccionesPorMesQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return InspeccionesPorMesQuery.builder()
				.numeroMes(rs.getInt("numero_mes"))
				.nombreMes(rs.getString("mes"))
				.cantidad(rs.getInt("cantidad"))
				.build();
	}

}
