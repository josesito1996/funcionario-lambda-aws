package com.javatechie.aws.lambda.domain.documents;

import java.io.Serializable;

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
@DynamoDBDocument
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Costo implements Serializable {

    private static final long serialVersionUID = -693647686016155771L;

    @DynamoDBAttribute(attributeName = "tiempo")
    @JsonInclude(Include.NON_NULL)
    private String tiempo;
    
    @DynamoDBAttribute(attributeName = "precio")
    @JsonInclude(Include.NON_NULL)
    private Double precio;
    
    @DynamoDBAttribute(attributeName = "moneda")
    @JsonInclude(Include.NON_NULL)
    private String moneda;
    
}
