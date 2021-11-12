package com.javatechie.aws.lambda.domain;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@DynamoDBDocument
@Getter
@NoArgsConstructor
@Setter
@ToString
public class InfraccionItem  implements Serializable {

    private static final long serialVersionUID = 954561636716012629L;

    @DynamoDBAttribute
    @Schema(title = "Materia", name = "materia", example = "{\"foo\": \"bar\",\"baz\": true}", description = "Este objeto representa a la materia")
    private ReactSelect materia;
    
    @DynamoDBAttribute
    @Schema(title = "Sub Materias", name = "subMaterias", example = "{\"foo\": \"bar\",\"baz\": true}", description = "Este objeto representa a las submaterias")
    private ReactSelect subMaterias;
    
    @DynamoDBAttribute
    @Schema(title = "Base legal", name = "baseLegal", example = "{\"foo\": \"bar\",\"baz\": true}", description = "Este objeto representa a las bases legales")
    private ReactSelect baseLegal;
    
    @DynamoDBAttribute
    @Schema(title = "Gravedad", name = "gravedad", example = "GRAVE", description = "Gravedad de la infraccion")
    private String gravedad;
    
    @DynamoDBAttribute
    @Schema(title = "Provision", name = "provision", example = "10000")
    private Double provision;
    
    @DynamoDBAttribute
    @Schema(title = "Descripcion", name = "descripcion", example = "Esta es una nueva infraccion registrada")
    private String descripcion;
    
    @DynamoDBAttribute
    @Schema(title = "Trabajdores afectados", name = "trabajadoresAfectados", example = "10")
    private Integer trabajadoresAfectados;
    
    @DynamoDBAttribute
    @Schema(title = "Uit multa potencial", name = "uitMultaPotencial", example = "10000")
    private Double uitMultaPotencial;
    
    @DynamoDBAttribute
    @Schema(title = "Multa potencial", name = "multaPotencial", example = "13200")
    private Double multaPotencial;
    
}
