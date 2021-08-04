package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

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
public class InfraccionRequestBody implements Serializable {
    private static final long serialVersionUID = -5209286050194639216L;

    @NotNull
    @NotEmpty
    @JsonProperty("base_legal")
    private String baseLegal;

    @NotNull
    @NotEmpty
    @JsonProperty("id_materia")
    private String idMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("sub_materia")
    private String subMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("descripcion")
    private String descripcion;

    @NotNull
    @NotEmpty
    @JsonProperty("gravedad")
    private String gravedad;
}
