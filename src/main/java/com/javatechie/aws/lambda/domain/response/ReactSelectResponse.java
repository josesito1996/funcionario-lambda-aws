package com.javatechie.aws.lambda.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class ReactSelectResponse {
	private String value;
	private String label;
	@JsonIgnore
	private Integer nroOrden;
}
