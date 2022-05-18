package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

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
public class TipoActuacionResponse implements Serializable {

    private static final long serialVersionUID = -3501358736563478372L;
    
    @Schema(title = "Id Funcionario", name = "id", example = "0c72985d-65bf-4f1f-b3f3-9b91b6b49eee")
	@JsonInclude(Include.NON_NULL)
	private String id;
	
    @Schema(title = "Nombre tipo de Actuacion", name = "nombre_tipo_actuacion", example = "Requerimiento de comparecencia")
	@JsonProperty("nombre_tipo_actuacion")
	@JsonInclude(Include.NON_NULL)
	private String nombreTipoActuacion;
}
