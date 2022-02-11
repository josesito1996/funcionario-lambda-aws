package com.javatechie.aws.lambda.domain.response.chart;

import java.io.Serializable;

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
public class DonnutChart1Response implements Serializable {

	private static final long serialVersionUID = 1312516205034086883L;
	
	private String intendencia;
	
	private Integer porcentaje;
	
}
