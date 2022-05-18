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
public class ComentarioResponse implements Serializable{

	private static final long serialVersionUID = -5909860040638854640L;

	private String id;
	
	private String fecha;
	
	private String text;
	
	private Integer cantStars;
	
}
