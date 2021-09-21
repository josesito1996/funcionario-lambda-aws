package com.javatechie.aws.lambda.domain;

import java.io.Serializable;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;

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
    private ReactSelect materia;
    
    @DynamoDBAttribute
    private ReactSelect subMaterias;
    
    @DynamoDBAttribute
    private ReactSelect baseLegal;
    
    @DynamoDBAttribute
    private String gravedad;
    
    @DynamoDBAttribute
    private Integer provision;
    
    @DynamoDBAttribute
    private String descripcion;
    
    @DynamoDBAttribute
    private Integer trabajadoresAfectados;
    
}
