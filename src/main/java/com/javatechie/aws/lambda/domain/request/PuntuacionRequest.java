package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

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
public class PuntuacionRequest implements Serializable {
    
    private static final long serialVersionUID = -7288230946334035135L;

    @NotNull
    @NotEmpty
    private String idFuncionario;
    
    @NotNull
    @NotEmpty
    private String usuario;
    
    @NotNull
    @Size(min = 1)
    @Valid
    private List<PuntajeRequest> puntajes;
    
}
