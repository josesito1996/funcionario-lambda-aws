package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@NoArgsConstructor
@Setter
@ToString
public class MateriaBody implements Serializable {
    
    private static final long serialVersionUID = -522141730560187996L;
    
	@JsonProperty("id_materia")
	@Schema(title = "Id materia", name = "id_materia", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	private String idMateria;
	
    @NotEmpty
	@NotNull
	@JsonProperty("nombre_materia")
    @Schema(title = "Nombre materia", name = "nombre_materia", type = "String", example = "Relaciones laborales", description = "Materias del caso Ejemplo : Relaciones Laboreales, Promocion y formacion, Seguridad y salud en el Trabajo, Extranjeros, Empleo y colocacion, Seguridad Social, Intermediacion LAboral, Labor inspectiva")
    private String nombreMateria;
	
    @NotEmpty
	@NotNull
	@Schema(title = "color", name = "color", type = "String", example = "red", description = "SEgun color el cual se mostrará en el Front.")
	private String color;
	
    @NotEmpty
	@NotNull
	@Schema(title = "icono", name = "icono", type = "String", example = "cardIcon", description = "Iconos que se encuentran en el Front")
	private String icono;
	
    @NotNull
	@Schema(title = "Estado", name = "estado", type = "boolean", example = "true")
	private Boolean estado;
}
