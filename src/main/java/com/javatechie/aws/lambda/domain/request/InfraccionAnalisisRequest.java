package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class InfraccionAnalisisRequest implements Serializable {

    private static final long serialVersionUID = 8855950427581179242L;

    @Valid
    @NotNull
    //@Schema(title = "Origen Caso", name = "origenCaso", required = true, description = "Request para el origen del Caso")
    private ReactSelectRequest origenCaso;

    @NotNull
    @NotEmpty
    @Schema(title = "Nombre asesor", name = "nameAsesor", required = true, description = "Pedro Perez Castillo")
    private String nameAsesor;

    @Valid
    @NotNull
    //@Schema(title = "Infracciones", name = "infractions", required = true, description = "Lista de infracciones a registrar")
    private List<InfraccionItemRequest> infractions;

    @Valid
    @NotNull
    //@Schema(title = "Nivel de Riesgo", name = "nivelRiesgo", required = true)
    private ReactSelectRequest nivelRiesgo;
    
    @NotNull
    @Schema(title = "Cantidad de trabajadores involucrados", name = "cantInvolucrados", required = true)
    private Integer cantInvolucrados;
    
    @Valid
    @NotNull
    @Pattern(regexp = REGEX_UUID,message = "no tiene el formato correcto")
    @Schema(title = "Id Caso", name = "idCaso", example = "f8c3de3d-1fea-4d7c-a8b0-29f63c4c3454", description = "Id del caso que esta relacionado", required = true)
    private String idCaso;

}
