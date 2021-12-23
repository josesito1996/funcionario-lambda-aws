package com.javatechie.aws.lambda.domain.jdbc;

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
public class PromedioPuntajeInspectorQuery {

	private Integer idItem;
	
    private String itemScore;

    private Integer max;

    private Integer score;

}
