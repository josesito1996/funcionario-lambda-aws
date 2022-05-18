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
public class PuntuacionMaestro {
    private Integer idItem;
    private String itemValoracion;
    private int puntajeMaximo;
    private boolean estado;
}
