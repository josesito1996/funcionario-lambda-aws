package com.javatechie.aws.lambda.domain.jdbc;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class CasosPorInspectorQuery {

    @JsonProperty(value = "razon_social")
    private String razonSocial;

    @JsonProperty(value = "orden_inspeccion")
    private String ordenInspeccion;

    @JsonProperty(value = "fecha_asignacion")
    private String fechaAsignacion;
}
