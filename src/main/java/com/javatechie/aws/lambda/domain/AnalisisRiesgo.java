package com.javatechie.aws.lambda.domain;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBTable;

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
    private String idAnalisis;
    
    @DynamoDBAttribute
    private ReactSelect origenCaso;
    
    @DynamoDBAttribute
    private String nombreAsesor;
    
    @DynamoDBAttribute
    private List<InfraccionItem> infracciones;
    
    @DynamoDBAttribute
    private ReactSelect nivelRiesgo;
    
    @DynamoDBAttribute
    private Integer cantidadInvolucrados;
    
    @DynamoDBAttribute
    private Boolean estado;
    
    @DynamoDBAttribute(attributeName = "id_caso")
    private String idCaso;
    
    @DynamoDBAttribute
    private Double sumaMultaPotencial;
    
    @DynamoDBAttribute
    private Double sumaProvision;
}
