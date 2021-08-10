package com.javatechie.aws.lambda.domain.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.javatechie.aws.lambda.domain.SubMateria;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@JsonIgnoreProperties(ignoreUnknown = true)
@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class MateriaResponse {

    @Schema(title = "Id materia", name = "id_materia", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
    @JsonProperty("id_materia")
    private String idMateria;

    @Schema(title = "Nombre materia", name = "nombre_materia", type = "String", example = "Relaciones laborales", description = "Materias del caso Ejemplo : Relaciones Laboreales, Promocion y formacion, Seguridad y salud en el Trabajo, Extranjeros, Empleo y colocacion, Seguridad Social, Intermediacion LAboral, Labor inspectiva")
    @JsonProperty("nombre_materia")
    private String nombreMateria;

    @JsonInclude(Include.NON_NULL)
    @Schema(title = "color", name = "color", type = "String", example = "red", description = "SEgun color el cual se mostrará en el Front.")
    private String color;

    @JsonInclude(Include.NON_NULL)
    @Schema(title = "icono", name = "icono", type = "String", example = "cardIcon", description = "Iconos que se encuentran en el Front")
    private String icono;

    @JsonInclude(Include.NON_NULL)
    @JsonProperty("sub_materias")
    private List<SubMateria> subMaterias;

    @Schema(title = "Estado", name = "estado", type = "boolean", example = "true")
    private Boolean estado;
}
