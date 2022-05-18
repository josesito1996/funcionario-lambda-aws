package com.javatechie.aws.lambda.aws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.javatechie.aws.lambda.domain.request.ReactSelectRequest;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExternalDbAws {

	@Autowired
	private DynamoDB dynamoDB;

	public Map<String, Object> getTable(String idCaso) {
		log.info("ExternalDbAws.getTable");
		Table tableCasos = dynamoDB.getTable("casos");
		GetItemSpec spec = new GetItemSpec().withPrimaryKey("id_caso", idCaso);
		Item casoItem = tableCasos.getItem(spec);
		if (casoItem == null) {
			return new HashMap<String, Object>();
		}
		return casoItem.asMap();
	}

	public AnalisisRiesgoPojo tableInfraccion(String idAnalisis) {
		log.info("ExternalDbAws.tableInfraccion");
		Table tableMaterias = dynamoDB.getTable("analisis-riesgo");
		GetItemSpec spec = new GetItemSpec().withPrimaryKey("id_analisis", idAnalisis);
		Item materiaItem = tableMaterias.getItem(spec);
		if (materiaItem == null) {
			return AnalisisRiesgoPojo.builder()
					.nivelRiesgo(new ReactSelectRequest())
					.infracciones(new ArrayList<>()).build();
		}
		final ObjectMapper mapper = new ObjectMapper();
		return mapper.convertValue(materiaItem.asMap(), AnalisisRiesgoPojo.class);
	}
	
	/*
	 * Nueva version pero con Clases
	 */
	public CasoPojo tableCaso(String idCaso) {
		log.info("ExternalDbAws.tableCaso");
		Table tableCaso = dynamoDB.getTable("casos");
		GetItemSpec spec = new GetItemSpec().withPrimaryKey("id_caso", idCaso);
		Item casoItem = tableCaso.getItem(spec);
		if (casoItem == null) {
			return CasoPojo.builder().actuaciones(new ArrayList<>()).build();
		}
		final ObjectMapper mapper = new ObjectMapper();
		mapper.registerModule(new JavaTimeModule());
		mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);;
		return mapper.convertValue(casoItem.asMap(), CasoPojo.class);
	}

}
