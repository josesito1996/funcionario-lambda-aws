package com.javatechie.aws.lambda.domain.response;

import javax.validation.constraints.NotNull;

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
public class EtapaResponse {
	@Schema(title = "ID Equipo", name = "id_etapa", example = "29752d65-ecc3-4633-a9a6-ae88fa95d3fc")
	@JsonInclude(Include.NON_NULL)
	@JsonProperty("id_etapa")
	private String IdEtapa;
	@Schema(title = "Nombre de etapa", name = "nombre_etapa", example = "Investigacion", description = "la etapa de la Actuacion Investigacion,Instruccion,Sancionadora")
	@JsonProperty("nombre_etapa")
	@JsonInclude(Include.NON_NULL)
	private String nombreEtapa;
	@Schema(title = "Estado", name = "estado", type = "boolean", example = "true")
	@JsonInclude(Include.NON_NULL)
	private Boolean estado;
	@NotNull
    @Schema(title = "Numero de orden", name = "nro_orden", type = "Integer", example = "1")
    @JsonProperty("nro_orden")
	@JsonInclude(Include.NON_NULL)
    private Integer nroOrden;
}
