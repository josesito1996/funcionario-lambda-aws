package com.javatechie.aws.lambda.domain.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
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
public class TipoActuacionResponse {
	@Schema(title = "Id Funcionario", name = "id", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	@JsonInclude(Include.NON_NULL)
	private String id;
	@Schema(title = "Nombre tipo de Actuacion", name = "nombre_tipo_actuacion", example = "Pablito Apellido1 Apellido2")
	@JsonProperty("nombre_tipo_actuacion")
	@JsonInclude(Include.NON_NULL)
	private String nombreTipoActuacion;
}
