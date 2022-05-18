package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

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
public class InfraccionResponseSelect implements Serializable {

    private static final long serialVersionUID = -4747120920978383406L;

    @Schema(title = "Id Infraccion", name = "idInfraccion", example = "4a561da2-7021-4398-a7ae-0ce17706e723")
    private String idInfraccion;
    
    @Schema(title = "Base legal", name = "baseLegal", example = "40.3")
    private String baseLegal;
    
    @Schema(title = "Descripcion", name = "descripcion", example = "No cubrir los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
    private String descripcion;

}
