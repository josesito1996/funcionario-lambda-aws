package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@NoArgsConstructor
@Getter
@Setter
@ToString
public class PuntajeRequest implements Serializable {
    
    private static final long serialVersionUID = 7024259703870875125L;

    @NotNull
    @Schema(title = "Id Item", name = "idItem", example = "3")
    private Integer idItem;
    
    @NotNull
    @Schema(title = "Puntaje", name = "puntaje", example = "2", description = "El puntaje varia , puede ser del 1 al 5")
    private Integer puntaje;
    
}
