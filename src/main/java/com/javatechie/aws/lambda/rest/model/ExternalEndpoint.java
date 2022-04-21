package com.javatechie.aws.lambda.rest.model;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ExternalEndpoint {
	
	@Value("${endpoints.api-usuarios}")
	private String apiUsuarios;

	private RestTemplate restTemplate;

	public ExternalEndpoint(RestTemplateBuilder builder) {
		restTemplate = builder.errorHandler(new RestTemplateErrorHandler()).build();
	}
	
	public UsuarioPojo viewByUserName(String userName) {
		log.info("ExternalEndpoint.viewByUserName  : {} ", userName);
		log.info("URL {}", apiUsuarios.concat("viewByUserName/").concat(userName));
		UsuarioPojo usuarioResponse = restTemplate.getForObject(apiUsuarios.concat("viewByUserName/{userName}"),
				UsuarioPojo.class, userName);
		log.info("Response {} ", usuarioResponse);
		return usuarioResponse;
	}
	
	public ColaboradorPojo viewColaboratorByUserName(String userName) {
		log.info("ExternalEndpoint.viewColaboratorByUserName  : {} ", userName);
		log.info("URL {}", apiUsuarios.concat("viewColaboratorByUserName/").concat(userName));
		ColaboradorPojo colaboradorResponse = restTemplate.getForObject(apiUsuarios.concat("viewColaboratorByUserName/{userName}"),
				ColaboradorPojo.class, userName);
		log.info("Response {} ", colaboradorResponse);
		return colaboradorResponse;
	}
	public List<String> findColaboratorsByUserName(String userName) {
		log.info("ExternalEndpoint.findColaboratorsByUserName  : {} ", userName);
		log.info("URL {}", apiUsuarios.concat("findColaboratorsByUserName").concat("/" + userName));
		String [] response = restTemplate.getForObject(
				apiUsuarios.concat("findColaboratorsByUserName/{userName}"), String[].class, userName);
		List<String> colaborators = Arrays.asList(response);
		log.info("Colaborators {}", colaborators);
		return colaborators;
	}
}
