package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class SubMateriaRequest implements Serializable {

    private static final long serialVersionUID = 8977643639636560849L;

    @JsonProperty("id_sub_materia")
    @Schema(title = "Id Submateria", name = "id_sub_materia", example = "2db25423-7c3d-4bea-885b-7fcb070be751")
    private String idSubMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("id_materia")
    @Schema(title = "Id Materia", name = "id_materia", example = "d5dead7f-859e-446a-aea5-3d8eb86e9ca0")
    private String idMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("nombre_sub_materia")
    @Schema(title = "Nombre submateria", name = "nombre_sub_materia", example = "Vih")
    private String nombreSubMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("prioridad")
    @Schema(title = "Prioridad", name = "prioridad", example = "true")
    private Boolean prioridad;

}
