package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

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
@ToString
@Setter
public class CasoWordFileResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6282844377259450088L;

	private String denominacionCaso;

	private String ordenInspeccion;

	private String fechaInicio;

	private String estadoCaso;

	private String etapa;

	private String resumen;

	private String origenCaso;

	private Integer trabajadoresInvolucrados;

	private Double multaPotencial;

	private String provisiones;

	private String riesgo;
	
	private List<Map<String, String>> actuaciones;

}
