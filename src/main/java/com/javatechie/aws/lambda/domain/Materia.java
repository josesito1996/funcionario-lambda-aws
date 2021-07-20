package com.javatechie.aws.lambda.domain;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAttribute;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBAutoGeneratedKey;
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
@DynamoDBTable(tableName = "materias")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class Materia {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	@DynamoDBAttribute(attributeName = "id_materia")
	private String idMateria;
	@DynamoDBAttribute
	private String nombreMateria;
	@DynamoDBAttribute
	private String color;
	@DynamoDBAttribute
	private String icono;
	@DynamoDBAttribute
	private Boolean estado;
}
