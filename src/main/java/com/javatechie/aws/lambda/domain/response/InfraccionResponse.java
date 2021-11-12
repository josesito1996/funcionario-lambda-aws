package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(title = "ID Infraccion", name = "id_infraccion", example = "05b8b7cf-76a2-40e6-8c57-603c4cf8a58a")
    private String idInfraccion;

    @JsonProperty("base_legal")
    @Schema(title = "Base legal", name = "base_legal", example = "46.6")
    private String baseLegal;

    @JsonProperty("sub_materia")
    @Schema(title = "Sub Materia", name = "sub_materia", example = "INASISTENCIA")
    private String subMateria;

}
