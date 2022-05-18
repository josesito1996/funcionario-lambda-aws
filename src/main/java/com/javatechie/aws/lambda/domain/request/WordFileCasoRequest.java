package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;
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
@Setter
@ToString
public class WordFileCasoRequest implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9059542105414892682L;

	private String nombreCaso;
	
	private String fechaCreacion;
	
	private Map<String, Object> estadoCaso;
	
	private String etapa;
	
}
