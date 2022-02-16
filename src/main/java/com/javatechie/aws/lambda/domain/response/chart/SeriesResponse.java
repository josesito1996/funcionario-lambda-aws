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
public class SeriesResponse implements Serializable {

	private static final long serialVersionUID = -1075928851767453026L;
	
	private String name;
	
	private List<Integer> data;

	private String color;
	
}
