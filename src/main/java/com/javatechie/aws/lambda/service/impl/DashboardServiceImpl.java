package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorAnioQuery;
import com.javatechie.aws.lambda.domain.jdbc.InspeccionesPorMesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.respository.jdbc.ControlTotalJdbc;
import com.javatechie.aws.lambda.service.DashboardService;

@Service
public class DashboardServiceImpl implements DashboardService {

	@Autowired
	private ControlTotalJdbc controlJdbc;

	@Override
	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio, String dpto) {
		List<InspeccionesPorMesQuery> inspecciones = controlJdbc.inspeccionesPorMes(anio, dpto);
		if (inspecciones.isEmpty()) {
			return BarChartResponse.builder().build();
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
			return BarChartResponse.builder().build();
		}
		return BarChartResponse.builder()
				.items(inspecciones.stream().map(item -> String.valueOf(item.getAnio())).collect(Collectors.toList()))
				.totales(inspecciones.stream().map(InspeccionesPorAnioQuery::getCantidad).collect(Collectors.toList()))
				.build();
	}

}
