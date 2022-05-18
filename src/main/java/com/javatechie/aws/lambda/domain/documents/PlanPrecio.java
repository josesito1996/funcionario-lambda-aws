package com.javatechie.aws.lambda.domain.documents;

import java.io.Serializable;
import java.util.List;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class PlanPrecio implements Serializable {

    private static final long serialVersionUID = -8346163805527978312L;

    @DynamoDBAttribute(attributeName = "tipo_plan")
    @JsonInclude(Include.NON_NULL)
    private String tipoPlan;
    
    @DynamoDBAttribute
    @JsonInclude(Include.NON_NULL)
    private Double costo;
    
    @DynamoDBAttribute
    @JsonInclude(Include.NON_NULL)
    private String moneda;
    
    @DynamoDBAttribute
    @JsonInclude(Include.NON_NULL)
    private List<String> detalles;
    
}
