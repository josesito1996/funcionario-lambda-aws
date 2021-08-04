package com.javatechie.aws.lambda.domain.response;

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
public class InfraccionResponse implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = -4684631158463445755L;

    @JsonProperty("id_infraccion")
    private String idInfraccion;

    @JsonProperty("base_legal")
    private String baseLegal;

    @JsonProperty("sub_materia")
    private String subMateria;

}
