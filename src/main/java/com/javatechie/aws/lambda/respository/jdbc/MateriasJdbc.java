package com.javatechie.aws.lambda.respository.jdbc;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.jdbc.MateriaInspeccionadasQuery;

import lombok.extern.slf4j.Slf4j;

@Repository
@Slf4j
public class MateriasJdbc {

	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<MateriaInspeccionadasQuery> materiasInspeccionadasQueries(String intendencia,String desde,String hasta) {
		log.info("MateriasJdbc.materiasInspeccionadasQueries");
		log.info("Intendencia {}", intendencia);
		List<MateriaInspeccionadasQuery> materias = jdbcTemplate.query("CALL SP_VIEW_MATERIAS_MAS_INSPECCIONADAS(?,?,?)",
				new MateriaInspeccionMapper(), new Object[] { intendencia, desde, hasta });
		log.info("MateriaInspeccionadasQuery {}", materias);
		return materias;
	}

	public List<MateriaInspeccionadasQuery> materiasSancionadasQueries(String intendencia,String desde,String hasta) {
		log.info("MateriasJdbc.materiasSancionadasQueries");
		List<MateriaInspeccionadasQuery> materias = jdbcTemplate.query("CALL SP_VIEW_MATERIAS_MAS_SANCIONADAS(?,?,?)",
				new MateriaInspeccionMapper(), new Object[] { intendencia, desde, hasta});
		log.info("MateriaInspeccionadasQuery {}", materias);
		return materias;
	}

}
