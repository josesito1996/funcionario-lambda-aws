package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.javatechie.aws.lambda.domain.jdbc.IntendenciaPorRegionQuery;

public class IntendenciaPorRegionMapper implements RowMapper<IntendenciaPorRegionQuery> {

	@Override
	public IntendenciaPorRegionQuery mapRow(ResultSet rs, int rowNum) throws SQLException {
		return new IntendenciaPorRegionQuery(rowNum + 1, rs.getString("oficina"));
	}

}
