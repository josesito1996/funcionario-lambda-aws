package com.javatechie.aws.lambda.domain.request;

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
public class EquipoBody {
	@Schema(title = "Id Equipo", name = "id", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	private String id;
	@Schema(title = "Nombre de Equipo", name = "nombre_equipo", required = true, type = "String", example = "Equipo 1")
	@NotNull
	@NotEmpty
	@JsonProperty("nombre_equipo")
	private String nombreEquipo;
	@Schema(title = "Color", name = "color", required = true, type = "string", example = "red|green|yellow")
	@NotNull
	@NotEmpty
	private String color;
	@Schema(title = "estado", name = "estado", required = true, type = "Boolean", example = "True|False")
	@NotNull
	private Boolean estado;
}
