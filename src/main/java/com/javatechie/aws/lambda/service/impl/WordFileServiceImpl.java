package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.estadoCaso;
import static com.javatechie.aws.lambda.util.ListUtils.etapaCaso;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.aws.ActuacionPojo;
import com.javatechie.aws.lambda.aws.AnalisisRiesgoPojo;
import com.javatechie.aws.lambda.aws.CasoPojo;
import com.javatechie.aws.lambda.aws.ExternalDbAws;
import com.javatechie.aws.lambda.domain.response.CasoWordFileResponse;
import com.javatechie.aws.lambda.service.WordFileService;
import com.javatechie.aws.lambda.util.WordUtil;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class WordFileServiceImpl implements WordFileService {

	@Autowired
	private WordUtil wordUtil;

	@Autowired
	private ExternalDbAws externalAws;

	@Override
	public ResponseEntity<ByteArrayResource> getWordFileCaso(String idCaso, HttpHeaders headers) {
		CasoPojo caso = externalAws.tableCaso(idCaso);
		log.info("Caso {} ", caso);
		headers.setContentType(new MediaType("application", "force-download"));
		headers.set(HttpHeaders.CONTENT_DISPOSITION,
				"attachment; filename=" + caso.getDescripcionCaso().concat(".docx"));
		return new ResponseEntity<>(wordUtil.getWordFile(wordFileresponse(caso)), headers, HttpStatus.OK);
	}

	private CasoWordFileResponse wordFileresponse(CasoPojo caso) {
		AnalisisRiesgoPojo analisis = externalAws.tableInfraccion(caso.getId());
		Integer trabajadoresInvolucrados = caso.getTrabajadoresInvolucrados();
		return CasoWordFileResponse.builder()
				.denominacionCaso(caso.getDescripcionCaso())
				.ordenInspeccion(caso.getOrdenInspeccion())
				.fechaInicio(caso.getFechaInicio())
				.estadoCaso(estadoCaso(caso.getActuaciones()))
				.etapa(etapaCaso(caso.getActuaciones()))
				.resumen(caso.getDescripcionAdicional())
				.origenCaso(caso.getOrigenInspeccion().getLabel())
				.trabajadoresInvolucrados(trabajadoresInvolucrados != null ? trabajadoresInvolucrados : 0)
				.multaPotencial(caso.getMultaPotencial().doubleValue())
				.provisiones("--")
				.riesgo(analisis.getNivelRiesgo().getLabel())
				.actuaciones(generateMap(caso.getActuaciones())).build();
	}

	private List<Map<String, String>> generateMap(List<ActuacionPojo> actuaciones) {
		return actuaciones.stream()
				.sorted(Comparator.comparing(ActuacionPojo::getFechaActuacion))
				.map(item -> {
			Map<String, String> newMap = new HashMap<>();
			newMap.put("fecha", item.getFechaActuacion().toString());
			newMap.put("tipoActuacion", item.getTipoActuacion().getNombreTipoActuacion());
			return newMap;
		}).collect(Collectors.toList());
	}
}
