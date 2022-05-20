package com.javatechie.aws.lambda.service.impl;

import java.nio.charset.StandardCharsets;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import com.amazonaws.services.lambda.model.InvokeResult;
import com.amazonaws.services.lambda.model.ServiceException;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.javatechie.aws.lambda.domain.lambda.LambdaFileBase64Request;
import com.javatechie.aws.lambda.domain.lambda.LambdaMailRequestSendgrid;
import com.javatechie.aws.lambda.service.LambdaService;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class LambdaServiceImpl implements LambdaService {

	@Autowired
	AWSLambda awsLambda;

	@Value("${spring.profiles.active}")
	private String enviroment;

	private String prefixEnviromentBucket() {
		return enviroment.equals("dev") ? "" : "-".concat(enviroment);
	}

	@Override
	public JsonObject enviarCorreo(LambdaMailRequestSendgrid request) {
		try {
			log.info("LambdaServiceImpl.enviarCorreo {}", request);
			Gson gson = new Gson();
			String payLoad = gson.toJson(request);
			InvokeRequest invokeRequest = new InvokeRequest().withFunctionName("lambda-mailSender-service")
					.withPayload(payLoad);
			InvokeResult result = awsLambda.invoke(invokeRequest);
			String ans = new String(result.getPayload().array(), StandardCharsets.UTF_8);
			JsonElement element = JsonParser.parseString(ans);
			log.info("Respuesta de la Lambda : " + ans);
			return element.getAsJsonObject();
		} catch (ServiceException e) {
			log.error("Error al invocar lambda -> " + e.toString());
			return new JsonObject();
		}
	}

	@Override
	public String obtenerBase64(LambdaFileBase64Request request) {
		log.info("LambdaServiceImpl.obtenerBase64 {}", request);
		try {
			String bucketName = "lambda-test".concat(prefixEnviromentBucket());
			log.info("BucketName : {}", bucketName);
			Gson gson = new Gson();
			String payLoad = gson.toJson(request);
			InvokeRequest invokeRequest = new InvokeRequest()
					.withFunctionName(bucketName).withPayload(payLoad);
			InvokeResult result = awsLambda.invoke(invokeRequest);
			String ans = new String(result.getPayload().array(), StandardCharsets.UTF_8);
			JsonElement element = JsonParser.parseString(ans);
			return element.getAsString();
		} catch (Exception e) {
			log.error("Error al obtener base64 {}", e);
			return "";
		}
	}

}
