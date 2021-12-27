package com.javatechie.aws.lambda.aws;

import java.math.BigDecimal;
import java.util.List;

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
public class CasoPojo {

  
    @JsonProperty("id_caso")
    private String id;

    private String descripcionAdicional;

    private String descripcionCaso;

    private String fechaInicio;

    private String ordenInspeccion;

    private BigDecimal multaPotencial;

    private List<InspectorDto> inspectorTrabajo;

    private List<InspectorDto> inspectorAuxiliar;

    // private List<MateriaDto> materias;

    private List<ActuacionPojo> actuaciones;

    //private List<DynamoBodyGenerico> intendencias;

    //private List<DynamoBodyGenerico> empresas;

    //private List<DynamoBodyGenerico> sedes;

    private DynamoBodyGenericoPojo origenInspeccion;

    private Integer trabajadoresInvolucrados;

    private String emailGenerado;

    private Integer estadoCaso;

    private String usuario;

    private String registro;
}
