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
@DynamoDBTable(tableName = "tipo_actuacion")
@Getter
@NoArgsConstructor
@Setter
@ToString
public class TipoActuacion {
	@DynamoDBHashKey
	@DynamoDBAutoGeneratedKey
	@DynamoDBAttribute(attributeName = "id_tipo_actuacion")
	private String idTipoActuacion;
	@DynamoDBAttribute
	private String nombreTipoActuacion;
	@DynamoDBAttribute
	private Boolean estado;
}
