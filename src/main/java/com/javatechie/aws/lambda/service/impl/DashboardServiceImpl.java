package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.Utils.getPorcentaje;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.jdbc.CasosConMultaQuery;
import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorAnioQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorMesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.domain.response.chart.DonnutChart1Response;
import com.javatechie.aws.lambda.domain.response.chart.DonnutChartCustomResponse;
import com.javatechie.aws.lambda.respository.jdbc.ControlTotalJdbc;
import com.javatechie.aws.lambda.service.DashboardService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private ControlTotalJdbc controlJdbc;

	@Override
	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio, String dpto) {
		List<InspeccionesPorMesQuery> inspecciones = controlJdbc.inspeccionesPorMes(anio, dpto);
		if (inspecciones.isEmpty()) {
			return BarChartResponse.builder().items(new ArrayList<>()).totales(new ArrayList<>()).build();
		}
		return BarChartResponse.builder()
				.items(inspecciones.stream().map(InspeccionesPorMesQuery::getNombreMes).collect(Collectors.toList()))
				.totales(inspecciones.stream().map(InspeccionesPorMesQuery::getCantidad).collect(Collectors.toList()))
				.build();
	}

	@Override
	public ControlTotalesQuery totales() {
		return controlJdbc.controlTotalesQuery();
	}

	@Override
	public BarChartResponse inspeccionesPorMes(String dpto) {
		List<InspeccionesPorAnioQuery> inspecciones = controlJdbc.inspeccionesPorAño(dpto).stream().filter(item -> {
			return item.getAnio() > 2018;
		}).collect(Collectors.toList());
		if (inspecciones.isEmpty()) {
			return BarChartResponse.builder().items(new ArrayList<>()).totales(new ArrayList<>()).build();
		}
		return BarChartResponse.builder()
				.items(inspecciones.stream().map(item -> String.valueOf(item.getAnio())).collect(Collectors.toList()))
				.totales(inspecciones.stream().map(InspeccionesPorAnioQuery::getCantidad).collect(Collectors.toList()))
				.build();
	}

	@Override
	public DonnutChartCustomResponse graficosDeDonnas(String intendencia) {
		log.info("DashboardServiceImpl.graficosDeDonnas");
		CasosConMultaQuery casosConMulta = controlJdbc.casosConMultaQueries(intendencia);
		log.info("casos {}", casosConMulta);
		Long cantidadCasosConMulta = casosConMulta.getCantidadMulta().longValue();
		log.info("CAsos con multa {}", cantidadCasosConMulta);
		Integer porcentaje = getPorcentaje(cantidadCasosConMulta.intValue(), casosConMulta.getCantidadTotal());
		log.info("CAsos con multa {}", cantidadCasosConMulta);
		Integer porcentajeIn = getPorcentaje(cantidadCasosConMulta.intValue(), cantidadCasosConMulta.intValue() + casosConMulta.getCantidadSinMulta());
		/*
		 * Para el Segundo Chart
		 */
		return DonnutChartCustomResponse.builder()
				.chart1(DonnutChart1Response.builder().intendencia(intendencia).porcentaje(porcentaje).build())
				.chart2(Arrays.asList(Arrays.asList("Si", porcentajeIn), Arrays.asList("No", 100 - porcentajeIn))).build();
	}

}
