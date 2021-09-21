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
public class ReactSelect implements Serializable{

    private static final long serialVersionUID = -6081358605671465612L;

    @DynamoDBAttribute
    private String value;

    @DynamoDBAttribute
    private String label;
}
