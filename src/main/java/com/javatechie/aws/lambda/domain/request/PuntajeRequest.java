package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

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
    private Integer idItem;
    
    @NotNull
    private Integer puntaje;
    
}
