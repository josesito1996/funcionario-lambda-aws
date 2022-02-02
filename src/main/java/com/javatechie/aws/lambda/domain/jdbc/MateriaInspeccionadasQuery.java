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
public class MateriaInspeccionadasQuery implements Serializable {

	private static final long serialVersionUID = 4385301063801114020L;

	private String nombreMateria;
	
	private Integer cantidad;
	
}
