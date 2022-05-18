package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;

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
public class InfraccionResponseBody implements Serializable {

    private static final long serialVersionUID = -9132029959994235318L;

    @Schema(title = "Nombre Materia", name = "nombreMateria", example = "Promocion y formacion")
    private String nombreMateria;
    
    @Schema(title = "Nombre SubMateria", name = "nombreSubMateria", example = "Limites de contratacion")
    private String nombreSubMateria;
    
    @Schema(title = "Infracciones", name = "infracciones", example = "DECRETO SUPREMPO....... N° XX-XXXX")
    private String infracciones;
    
    private List<ArticuloResponseBody> articulos;
}
