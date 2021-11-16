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
public class ResolucionesPorInstanciaQuery implements Serializable {

    private static final long serialVersionUID = -5538248364884491428L;

    private Integer primera;
    private Integer segunda;
    private Integer tercera;

}
