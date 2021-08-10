package com.javatechie.aws.lambda.domain.response;

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
public class SubMateriaResponse {
    @JsonProperty("id_sub_materia")
    private String idSubMateria;

    @JsonProperty("sub_materia")
    private String subMateria;
}
