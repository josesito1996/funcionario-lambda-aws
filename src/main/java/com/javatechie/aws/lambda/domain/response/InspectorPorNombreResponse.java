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
public class InspectorPorNombreResponse implements Serializable {

	private static final long serialVersionUID = 8121401179221655721L;
	
	private String nombreFuncionario;
	
	private Integer cantidadCasos;
	
	private String fechaRegistro;
	
}
