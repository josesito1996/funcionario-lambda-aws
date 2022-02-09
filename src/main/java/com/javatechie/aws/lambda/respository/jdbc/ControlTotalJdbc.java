package com.javatechie.aws.lambda.respository.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.CallableStatementCreator;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorAnioQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorMesQuery;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class ControlTotalJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	@SuppressWarnings("static-access")
	public ControlTotalesQuery controlTotalesQuery() {
		log.info("ControlTotalJdbc.controlTotalesQuery");
		List<SqlParameter> parameters = new ArrayList<>();
		Map<String, Object> queryResult = jdbcTemplate.call(new CallableStatementCreator() {
			@Override
			public CallableStatement createCallableStatement(Connection con) throws SQLException {
				CallableStatement cs = con.prepareCall("{call SP_CONTROL_TOTALES()}");
				return cs;
			}
		}, parameters);
		if (queryResult.isEmpty()) {
			return ControlTotalesQuery.builder().build();
		}
		Object result = queryResult.get("#result-set-1");
		if (result instanceof List) {
			ControlTotalesQuery response = null;
			@SuppressWarnings("unchecked")
			List<Map<String, Object>> newList = (List<Map<String, Object>>) result;
			for (Map<String, Object> map : newList) {
				response = response.builder()
						.totalInspecciones(Integer.parseInt(map.get("total_inspecciones").toString()))
						.totalPrimera(Integer.parseInt(map.get("total_primera").toString()))
						.totalSegunda(Integer.parseInt(map.get("total_segunda").toString()))
						.totalTfl(Integer.parseInt(map.get("total_tfl").toString())).build();
				break;
			}
			return response;
		}
		return ControlTotalesQuery.builder().build();
	}

	public List<InspeccionesPorAnioQuery> inspeccionesPorAño(String dpto) {
		return jdbcTemplate.query("CALL SP_INSPECCIONES_POR_ANIO(?)", new InspeccionesPorAnioMapper(),
				new Object[] { dpto });
	}

	public List<InspeccionesPorMesQuery> inspeccionesPorMes(Integer año, String dpto) {
		return jdbcTemplate.query("CALL SP_INSPECCIONES_POR_MES(?,?)", new InspeccionesPorMesMapper(),
				new Object[] { año, dpto });
	}

}
