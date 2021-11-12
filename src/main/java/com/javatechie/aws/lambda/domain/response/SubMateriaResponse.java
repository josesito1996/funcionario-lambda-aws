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
public class SubMateriaResponse implements Serializable{

    private static final long serialVersionUID = 2984738086810826526L;

    @JsonProperty("id_sub_materia")
    @Schema(title = "Id Submateria", name = "idSubMateria", example = "284c70c5-bdf9-473f-8f06-6c8043b0fce1")
    private String idSubMateria;

    @JsonProperty("sub_materia")
    @Schema(title = "Sub materia", name = "subMateria", example = "Riesgos laborales")
    private String subMateria;
}
