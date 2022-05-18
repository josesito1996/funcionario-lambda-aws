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
public class ReactSelect implements Serializable {

    private static final long serialVersionUID = -6081358605671465612L;

    @DynamoDBAttribute
    @Schema(title = "Value", name = "value", example = "ef00fc79-5eff-4dd6-8d25-4bec185b0f0b", type = "String")
    private String value;

    @DynamoDBAttribute
    @Schema(title = "Label", name = "label", example = "", type = "String")
    private String label;

    @DynamoDBAttribute
    @Schema(title = "Campo auxiliar", name = "campoAux", example = "", description = "Campo comodin que puede representar algun valor que puede servir para ordenacion", type = "String")
    private String campoAux;
}
