package com.javatechie.aws.lambda.domain;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@DynamoDBTable(tableName = "analisis-riesgo")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class AnalisisRiesgo implements Serializable {

    private static final long serialVersionUID = -8582041954209540735L;

    @DynamoDBHashKey
    @DynamoDBAttribute(attributeName = "id_analisis")
    @Schema(title = "Id materia", name = "idAnalisis", type = "String", example = "114b2a36-e915-4253-936c-b18b6fb8d25f")
    private String idAnalisis;

    @DynamoDBAttribute
    @Schema(title = "Origen Caso", name = "origenCaso", example = "{\"foo\": \"bar\",\"baz\": true}", description = "Este objeto es reutilizable por varios Servicios devuelve un objeto para que React lo pueda pintar en un Select")
    private ReactSelect origenCaso;

    @DynamoDBAttribute
    @Schema(title = "Nombre asesor", name = "nombreAsesor", type = "String", example = "Pedro Gomez Calderon")
    private String nombreAsesor;

    @DynamoDBAttribute
    @Schema(title = "Infracciones", name = "infracciones", description = "Lista de Infracciones")
    private List<InfraccionItem> infracciones;

    @DynamoDBAttribute
    @Schema(title = "Nivel de riesgo", name = "nivelRiesgo", description = "Nivel de riesgo")
    private ReactSelect nivelRiesgo;

    @DynamoDBAttribute
    @Schema(title = "Cantidad de involucrados", name = "cantidadInvolucrados", type = "Integer", example = "25")
    private Integer cantidadInvolucrados;

    @DynamoDBAttribute
    private Boolean estado;

    @DynamoDBAttribute(attributeName = "id_caso")
    @Schema(title = "Id Caso", name = "idCaso", type = "String", example = "114b2a36-e915-4253-936c-b18b6fb8d25f", description = "Es el campo con el cual vamos a identificar a que caso pertenece")
    private String idCaso;

    @DynamoDBAttribute
    @Schema(title = "Suma multa potencial", name = "sumaMultaPotencial", type = "Double", example = "13200", description = "La suma total de las multas potenciales en la lista de infracciones")
    private Double sumaMultaPotencial;

    @DynamoDBAttribute
    @Schema(title = "Suma provision", name = "sumaProvision", type = "Double", example = "10000", description = "La suma total de las provisiones en la lista de infracciones")
    private Double sumaProvision;
}
