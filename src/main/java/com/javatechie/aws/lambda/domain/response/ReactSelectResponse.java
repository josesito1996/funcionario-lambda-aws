package com.javatechie.aws.lambda.domain.response;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	private Integer nroOrden;
	
	@JsonInclude(Include.NON_NULL)
	private String campoAux;
}
