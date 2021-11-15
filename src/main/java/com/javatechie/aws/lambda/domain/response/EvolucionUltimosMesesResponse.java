package com.javatechie.aws.lambda.domain.response;

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
public class EvolucionUltimosMesesResponse implements Serializable {

    private static final long serialVersionUID = 7048767820071190827L;

    private String mes;
    
    private Integer cantidad;
    
}
