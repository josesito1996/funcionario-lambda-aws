package com.javatechie.aws.lambda.domain.jdbc;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
public class IntendenciaPorRegionQuery implements Serializable {

	private static final long serialVersionUID = 3690177519233146784L;
	
	private Integer index;
	
	private String oficina;
	
}
