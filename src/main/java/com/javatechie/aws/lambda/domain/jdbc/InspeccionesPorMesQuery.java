package com.javatechie.aws.lambda.domain.jdbc;

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
public class InspeccionesPorMesQuery implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = -7189298965501691879L;

	private Integer anioNumber;
	
	private Integer numeroMes;
	
	private String nombreMes;
	
	private Integer cantidad;
	
}
