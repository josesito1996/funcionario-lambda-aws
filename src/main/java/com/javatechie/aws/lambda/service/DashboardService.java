package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;

public interface DashboardService {

	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio);
	
	public ControlTotalesQuery totales();
	
	public BarChartResponse inspeccionesPorMes();
	
}
