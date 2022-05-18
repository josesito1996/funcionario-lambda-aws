package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.MateriaInspeccionadasQuery;

public class MateriaInspeccionMapper implements RowMapper<MateriaInspeccionadasQuery> {

	@Override
	public MateriaInspeccionadasQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		return MateriaInspeccionadasQuery.builder()
				.nombreMateria(rs.getString("materia_inspeccion"))
				.cantidad(rs.getInt("cantidad"))
				.build();
	}

}
