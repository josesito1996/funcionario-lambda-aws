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
public class EtapaBody implements Serializable{
    
    private static final long serialVersionUID = 375758912473060322L;
    
    @Schema(title = "Id Etapa", name = "id_etapa", type = "String", example = "67b37518-97ea-4359-9b6d-6a41b0214b6b")
	@JsonProperty("id_etapa")
	private String idEtapa;
	
    @NotNull
	@NotEmpty
	@Schema(title = "Nombre Etapa", name = "nombre_etapa", type = "String", example = "INVESTIGACION", description = "Etapas de la actuacion Ejemplo INVESTIGACION,INSTRUCCION,SANCIONADORA")
	@JsonProperty("nombre_etapa")
	private String nombreEtapa;
	
    @NotNull
	@Schema(title = "Estado", name = "estado", type = "boolean", example = "true")
	private Boolean estado;
	
    @NotNull
    @Schema(title = "Numero de orden", name = "nro_orden", type = "Integer", example = "1")
	@JsonProperty("nro_orden")
	private Integer nroOrden;
}
