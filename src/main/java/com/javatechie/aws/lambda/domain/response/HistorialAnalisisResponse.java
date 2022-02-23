package com.javatechie.aws.lambda.domain.response;

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
public class HistorialAnalisisResponse implements Serializable  {

	private static final long serialVersionUID = -5408116156671462695L;

	private String materia;
	
	private String subMateria;
	
	private String baseLegal;
	
	private Integer trabajadoresAfectados;
	
	private String gravedad;
	
	private Integer uitsMulta;
	
	private Double multaPotencial;
	
	private Double provision;
	
	private String descripcion;
	
}
