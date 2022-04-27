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
public class InspectorResponse implements Serializable {

    private static final long serialVersionUID = 5454804942245162248L;
    
    @Schema(title = "Id INSPECTOR", name = "id", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	private String id;
	
    @Schema(title = "Nombres y apellidos", name = "nombres_apellidos", example = "Pablito Apellido1 Apellido2")
	@JsonProperty("nombres_apellidos")
	private String nombresApellidos;
	
    @Schema(title = "Tipo de INspector", name = "tipo_inspector", example = "AUXILIAR")
	private String tipoInspector;
	
	@JsonInclude(Include.NON_NULL)
	@Schema(title = "Correo", name = "correo", example = "inspector@gmail.com")
	private String correo;
	
	@JsonInclude(Include.NON_NULL)
	@Schema(title = "Telefono", name = "telefono", example = "992894493")
	private String telefono;
	
	@JsonInclude(Include.NON_NULL)
	@Schema(title = "Cargo", name = "cargo", example = "Inspector Principal")
	private String cargo;
	
	@Schema(title = "Estadode INspector", name = "estado", example = "false",type = "boolean", description = "Si esta activo o no en la BD")
	private Boolean estado;
}
