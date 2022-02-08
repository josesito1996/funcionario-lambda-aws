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
	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio) {
		List<InspeccionesPorMesQuery> inspecciones = controlJdbc.inspeccionesPorMes(anio);
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
	public BarChartResponse inspeccionesPorMes() {
		List<InspeccionesPorAnioQuery> inspecciones = controlJdbc.inspeccionesPorAño();
		if (inspecciones.isEmpty()) {
			return BarChartResponse.builder().build();
		}
		return BarChartResponse.builder()
				.items(inspecciones.stream().map(item -> String.valueOf(item.getAnio())).collect(Collectors.toList()))
				.totales(inspecciones.stream().map(InspeccionesPorAnioQuery::getCantidad).collect(Collectors.toList()))
				.build();
	}

}
