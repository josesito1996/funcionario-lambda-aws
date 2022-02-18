package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponseV2;
import com.javatechie.aws.lambda.domain.response.chart.DonnutChartCustomResponse;

public interface DashboardService {

	public BarChartResponse inspeccionesPorMesesByAnio(Integer anio, String dpto,String desde,String hasta);

	public ControlTotalesQuery totales(String dpto, String desde, String hasta);

	public BarChartResponseV2 inspeccionesPorMes(String dpto, String desde, String hasta);
	
	public DonnutChartCustomResponse graficosDeDonnas(String intendencia);

}
