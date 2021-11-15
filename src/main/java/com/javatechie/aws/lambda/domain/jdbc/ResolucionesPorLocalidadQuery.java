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
@Setter
@NoArgsConstructor
@ToString
public class ResolucionesPorLocalidadQuery implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 5005416953367042176L;
    
    private Integer indice;
    
    private String departamento;
    
    private Integer cantidad;

}
