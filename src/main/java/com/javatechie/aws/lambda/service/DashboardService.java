package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.domain.response.chart.DonnutChartCustomResponse;

public interface DashboardService {

	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio, String dpto);

	public ControlTotalesQuery totales();

	public BarChartResponse inspeccionesPorMes(String dpto);
	
	public DonnutChartCustomResponse graficosDeDonnas(String intendencia);

}
