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
public class CasosConMultaQuery implements Serializable {

	private static final long serialVersionUID = -1032665042762736317L;

	private String nroOrdenInspeccion;

	private Integer totalMulta;

}
