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
public class DonnutChartCustomResponse implements Serializable {

	private static final long serialVersionUID = 2095628697515589727L;

	private DonnutChart1Response chart1;

	private List<List<Object>> chart2;

}
