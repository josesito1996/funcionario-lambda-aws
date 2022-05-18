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
public class EvolucionUltimosMesesQuery implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -3499881821632639043L;

    private Integer mes;

    private Integer año;

    private Integer cantidad;

}
