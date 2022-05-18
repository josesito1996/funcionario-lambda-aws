package com.javatechie.aws.lambda.domain.dto;

import java.io.Serializable;
import java.util.List;

import com.javatechie.aws.lambda.domain.InfraccionItem;
import com.javatechie.aws.lambda.domain.ReactSelect;

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
public class AnalisisRiesgoDto implements Serializable {
    private static final long serialVersionUID = -8582041954209540735L;

   
    private String idAnalisis;

    private List<InfraccionItem> infracciones;

    private ReactSelect nivelRiesgo;

    private Integer cantidadInvolucrados;

    private Boolean estado;

    private String idCaso;

    private Double sumaMultaPotencial;

    private Double sumaProvision;
    
    private String fecha;
}
