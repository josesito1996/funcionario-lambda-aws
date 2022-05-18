package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;

import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class AnalisisRiesgoDetalle implements Serializable {

	private static final long serialVersionUID = -8777771653100567728L;

	private String nombreCaso;
	
	private String nroOrdenInspeccion;
	
	private BarChartResponse barChart;
	
	private Double totalMultaPotencial;
	
	private Double totalProvision;
	
	private List<HistorialAnalisisResponse> historial;
	
	
}
