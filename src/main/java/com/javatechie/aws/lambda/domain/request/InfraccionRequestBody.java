package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class InfraccionRequestBody implements Serializable {
    private static final long serialVersionUID = -5209286050194639216L;

    @NotNull
    @NotEmpty
    @JsonProperty("id_infraccion")
    @Schema(title = "Id Infraccion", name = "id_infraccion", example = "fa772c29-a3f4-482a-8021-cfbe6d636a08")
    private String idInfraccion;
    
    @NotNull
    @NotEmpty
    @JsonProperty("base_legal")
    @Schema(title = "Base legal", name = "base_legal", example = "43.1")
    private String baseLegal;

    @NotNull
    @NotEmpty
    @JsonProperty("id_materia")
    @Schema(title = "Id materia", name = "id_materia", example = "38281aa7-5ce7-4bd3-a8dc-67365ffe1a7e")
    private String idMateria;
    
    @NotNull
    @NotEmpty
    @JsonProperty("id_articulo")
    @Schema(title = "Id articulo", name = "id_articulo", example = "e63d8b4b-6071-4016-a6e3-f623dd8f7163")
    private String idArticulo;
    
    @NotNull
    @NotEmpty
    @JsonProperty("id_sub_materia")
    @Schema(title = "Id Submateria", name = "id_sub_materia", example = "96fd3e46-c648-4642-965f-7ce40eca8bee")
    private String idSubMateria;
    
    @NotNull
    @NotEmpty
    @JsonProperty("sub_materia")
    @Schema(title = "Sub-Materia", name = "sub_materia", example = "CONTRATO DE TRABAJADOR EXTRANJERO")
    private String subMateria;

    @NotNull
    @NotEmpty
    @JsonProperty("descripcion")
    @Schema(title = "Descripcion", name = "descripcion", example = "Ocupar o contratar trabajadores extranjeros sin haber obtenido previamente la autorización administrativa correspondiente.")
    private String descripcion;

    @NotNull
    @NotEmpty
    @JsonProperty("gravedad")
    @Schema(title = "Gravedad", name = "gravedad", example = "MUY GRAVE")
    private String gravedad;
}
