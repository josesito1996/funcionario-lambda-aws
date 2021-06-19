package com.javatechie.aws.lambda.domain.request;

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
public class FuncionarioBody {
	@Schema(title = "Id de funcionario", name = "id", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	private String id;
	@Schema(title = "Nombres", name = "nombres", type = "String", example = "Pedro Jose")
	private String nombres;
	@Schema(title = "Apellidos", name = "apellidos", type = "String", example = "Rodriguez Vela")
	private String apellidos;
	@Schema(title = "Estado", name = "estado", type = "Boolean",description = "Puede ser true|false, indica el estado de actividad del funcionario", example = "Pedro Jose")
	private Boolean estado;
}
