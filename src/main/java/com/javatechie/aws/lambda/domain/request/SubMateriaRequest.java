package com.javatechie.aws.lambda.domain.request;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class SubMateriaRequest {

    @JsonProperty("id_sub_materia")
    private String idSubMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("id_materia")
    private String idMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("nombre_sub_materia")
    private String nombreSubMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("prioridad")
    private Boolean prioridad;

}
