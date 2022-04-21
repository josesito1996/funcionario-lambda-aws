package com.javatechie.aws.lambda.rest.model;

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
	
}
