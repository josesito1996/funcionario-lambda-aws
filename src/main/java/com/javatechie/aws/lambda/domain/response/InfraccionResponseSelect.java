package com.javatechie.aws.lambda.domain.response;

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
public class InfraccionResponseSelect {
    private String idInfraccion;
    private String baseLegal;
    private String descripcion;

}
