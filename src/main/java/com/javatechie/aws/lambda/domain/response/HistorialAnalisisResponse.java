package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;

import com.javatechie.aws.lambda.domain.AnalisisRiesgoTableResponse;

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
public class HistorialAnalisisResponse implements Serializable  {

	private static final long serialVersionUID = -5408116156671462695L;

	private String fecha;
	
	private List<AnalisisRiesgoTableResponse> table;
	
}
