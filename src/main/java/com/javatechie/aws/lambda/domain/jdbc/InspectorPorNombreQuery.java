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
public class InspectorPorNombreQuery implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 5484136268059744020L;
	
	private String nombreFuncionario;

	private Integer cantidadCasos;

	private String fechaAsignacion;

}
