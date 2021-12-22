package com.javatechie.aws.lambda.aws;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class EstadoCasoPojo implements Serializable  {

    private static final long serialVersionUID = -6122644555826757692L;

    @JsonProperty("id_estado_caso")
    private String idEstadoCaso;
    
    private String nombreEstado;
    
    private Integer orden;
}
