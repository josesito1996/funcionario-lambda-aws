package com.javatechie.aws.lambda.domain.response.chart;

import java.io.Serializable;
import java.util.List;

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
public class BarChartResponse implements Serializable {

	private static final long serialVersionUID = -810968814995000570L;

	private List<String> items;

	private List<Integer> totales;

}
