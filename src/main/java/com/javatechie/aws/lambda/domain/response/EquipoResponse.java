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
public class EquipoResponse implements Serializable {
    
    private static final long serialVersionUID = 7013444476551976935L;
    
    @Schema(title = "ID Equipo", name = "id", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	private String id;
	
    @Schema(title = "Nombre de Equipo", name = "nombres_apellidos", example = "Equipo de abogados")
	@JsonProperty("nombre_equipo")
	private String nombreEquipo;
	
    @Schema(title = "Color Equipo", name = "color", example = "red|green|orange")
	private String color;
	
    @Schema(title = "Estado", name = "estado", type = "boolean", example = "false")
	private Boolean estado;
}
