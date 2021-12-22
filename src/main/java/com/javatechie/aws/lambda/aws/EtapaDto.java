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
public class EtapaDto {
	@JsonProperty("id_etapa")
	private String id;

	@JsonProperty("nombre_etapa")
	private String nombreEtapa;
	
	private Integer nroOrden;
}
