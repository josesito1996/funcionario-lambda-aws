package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.InspectorPorNombreQuery;

public class InspectorPorNombreQueryMapper implements RowMapper<InspectorPorNombreQuery>{

	@Override
	public InspectorPorNombreQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return InspectorPorNombreQuery.builder()
				.nombreFuncionario(rs.getString("nombre_funcionario"))
				.cantidadCasos(rs.getInt("cantidad_casos"))
				.fechaAsignacion(rs.getString("fecha_asignacion"))
				.build();
	}

}
