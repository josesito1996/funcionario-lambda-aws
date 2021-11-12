package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

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
public class FuncionarioResponse implements Serializable {

    private static final long serialVersionUID = 3278716102289836864L;

    @Schema(title = "Id Funcionario", name = "id", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	private String id;
	
    @Schema(title = "Nombres y apellidos", name = "nombres_apellidos", example = "Pablito Apellido1 Apellido2")
	@JsonProperty("nombres_apellidos")
	private String nombresApellidos;
	
    @Schema(title = "Estado", name = "estado", type = "boolean", example = "false")
	private Boolean estado;
}
