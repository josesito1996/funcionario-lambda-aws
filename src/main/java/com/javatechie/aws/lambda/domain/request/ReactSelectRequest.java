package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class ReactSelectRequest implements Serializable{

    private static final long serialVersionUID = -5926740853582360357L;

    @NotEmpty(message = "no debe estar vacio")
	@NotNull(message = "no debe ser nulo")
	@Schema(title = "Value", name = "value", example = "123e4567-e89b-42d3-a456-556642440000", required = true)
	private String value;
	
	@NotEmpty(message = "no debe estar vacio")
	@NotNull(message = "no debe ser nulo")
	@Schema(title = "Label", name = "label", example = "", required = true)
	private String label;
	
	@Schema(title = "Campo auxiliar", name = "campoAux", example = "1")
	private String campoAux;
}
