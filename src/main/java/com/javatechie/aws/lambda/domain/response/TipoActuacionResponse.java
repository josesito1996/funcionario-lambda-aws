package com.javatechie.aws.lambda.domain.response;

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
public class TipoActuacionResponse {
	@Schema(title = "Id Funcionario", name = "id", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	private String id;
	@Schema(title = "Nombre tipo de Actuacion", name = "nombre_tipo_actuacion", example = "Pablito Apellido1 Apellido2")
	@JsonProperty("nombre_tipo_actuacion")
	private String nombreTipoActuacion;
}
