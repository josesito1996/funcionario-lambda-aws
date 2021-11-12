package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class ReactSelectResponse implements Serializable {
    
    private static final long serialVersionUID = 4935736065819624561L;

    @Schema(title = "Value", example = "63fb6512-3f46-4d48-a0d5-bd478e815a0a", description = "Representa la clave primaria")
	private String value;
	
    @Schema(title = "Label", example = "Label")
	private String label;
	
	@JsonInclude(Include.NON_NULL)
	@JsonIgnore
	@Schema(title = "Nro Orden",name = "nroOrden", example = "5", description = "Este campo es opcional en el response")
	private Integer nroOrden;
	
	@JsonInclude(Include.NON_NULL)
	@Schema(title = "Campo Auxiliar",name = "campoAux", example = "--", description = "Este campo es opcional en el response")
	private String campoAux;
}
