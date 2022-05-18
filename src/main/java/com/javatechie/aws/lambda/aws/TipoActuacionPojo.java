package com.javatechie.aws.lambda.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@DynamoDBDocument
@Getter
@NoArgsConstructor
@Setter
@ToString
public class TipoActuacionPojo {
	@JsonProperty("id_tipo_actuacion")
	private String id;
	@JsonProperty("nombre_tipo_actuacion")
	private String nombreTipoActuacion;
}
