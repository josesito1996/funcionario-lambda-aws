package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

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
public class InspectorBody implements Serializable {
    
    private static final long serialVersionUID = -8310422928094926618L;
    
    @Schema(title = "Id de Inspector", name = "id", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	private String id;
	
	@NotNull
	@NotEmpty
	@JsonProperty("nombre_inspector")
	@Schema(title = "Nombre de Inspector", name = "nombre_inspector", required = true, type = "String", example = "TU INSPECTOR FAVORITO")
	private String nombreInspector;
	
	@NotNull
	@NotEmpty
	@JsonProperty("tipo_inspector")
	@Schema(title = "Tipo de inspector", name = "tipo_inspector", required = true, type = "String", example = "AUXILIAR",description = "Este campo sera usado como filtro para poder identificar el tipo de INSPECTOR puede ser AUXLIAR o TRABAJO")
	private String tipoInspector;
	
	@NotNull
	@Schema(title = "estado", name = "estado", required = true, type = "Boolean", example = "True|False")
	private Boolean estado;
}
