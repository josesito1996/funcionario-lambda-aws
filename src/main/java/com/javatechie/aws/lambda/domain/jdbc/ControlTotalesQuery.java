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
public class ControlTotalesQuery implements Serializable {

	private static final long serialVersionUID = -794740623492389391L;

	private Integer totalInspecciones;

	private Integer totalPrimera;

	private Integer totalSegunda;

	private Integer totalTfl;

}
