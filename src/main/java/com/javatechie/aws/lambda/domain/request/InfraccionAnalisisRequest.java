package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class InfraccionAnalisisRequest implements Serializable {

    private static final long serialVersionUID = 8855950427581179242L;

    @Valid
    @NotNull
    private ReactSelectRequest origenCaso;

    @NotNull
    @NotEmpty
    private String nameAsesor;

    @Valid
    @NotNull
    private List<InfraccionItemRequest> infractions;

    @Valid
    @NotNull
    private ReactSelectRequest nivelRiesgo;
    
    @NotNull
    private Integer cantInvolucrados;
    
    @Valid
    @NotNull
    @Pattern(regexp = REGEX_UUID,message = "no tiene el formato correcto")
    private String idCaso;

}
