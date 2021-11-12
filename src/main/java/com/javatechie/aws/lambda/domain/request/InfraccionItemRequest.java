package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
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
@Getter
@NoArgsConstructor
@Setter
@ToString
public class InfraccionItemRequest implements Serializable {

    private static final long serialVersionUID = 954561636716012629L;

    @Valid
    @NotNull
    //@Schema(title = "Materia", required = true, name = "materia", example = "{}", description = "Materia seleccionada")
    private ReactSelectRequest materia;

    @Valid
    @NotNull
    private ReactSelectRequest selectSubmateria;

    @Valid
    @NotNull
    private ReactSelectRequest selectBaseLegal;

    @NotNull
    @NotEmpty
    @Schema(title = "Gravedad", name = "gravedad", example = "GRAVE")
    private String gravedad;

    @NotNull
    @Schema(title = "Provision", name = "provision", example = "16.25")
    private Double provision;

    @NotNull
    @NotEmpty
    @Schema(title = "Descripcion", name = "descripcion", example = "Descripcion de la infracion.")
    private String descripcion;

    @NotNull
    @Schema(title = "Trabajadores afectados", name = "afectados", example = "36")
    private Integer afectados;

    @NotNull
    @Schema(title = "Uit Multa Potencial", name = "uitMultaPotencial", example = "12500")
    private Double uitMultaPotencial;

    @NotNull
    @Schema(title = "Multa Potencial", name = "multaPotencial", example = "17500")
    private Double multaPotencial;

}
