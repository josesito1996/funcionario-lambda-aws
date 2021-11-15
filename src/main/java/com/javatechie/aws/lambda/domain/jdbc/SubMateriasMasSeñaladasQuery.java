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
public class SubMateriasMasSeñaladasQuery implements Serializable {

    private static final long serialVersionUID = -4230917402581522019L;
    
    private String subMateria;
    
    private Double cantidad;
    
}
