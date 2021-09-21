package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
    private ReactSelectRequest materia;

    @Valid
    @NotNull
    private ReactSelectRequest selectSubmateria;

    @Valid
    @NotNull
    private ReactSelectRequest selectBaseLegal;

    @NotNull
    @NotEmpty
    private String gravedad;

    @NotNull
    private Integer provision;

    @NotNull
    @NotEmpty
    private String descripcion;

    @NotNull
    private Integer afectados;

}
