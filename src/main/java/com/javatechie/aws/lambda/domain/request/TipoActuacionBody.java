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
public class TipoActuacionBody {
	@Schema(title = "Id de Tipo de actuacion", name = "id", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	private String id;
	@Schema(title = "Nombre tipo de actuacion", name = "nombre_tipo_actuacion", required = true, type = "String", example = "Requerimiento de comparecencia")
	@NotNull
	@NotEmpty
	@JsonProperty("nombre_tipo_actuacion")
	private String nombreTipoActuacion;
	@Schema(title = "estado", name = "estado", required = true, type = "Boolean", example = "True|False")
	private Boolean estado;
}
