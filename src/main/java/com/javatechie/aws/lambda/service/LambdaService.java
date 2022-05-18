package com.javatechie.aws.lambda.service;

import com.google.gson.JsonObject;
import com.javatechie.aws.lambda.domain.lambda.LambdaFileBase64Request;
import com.javatechie.aws.lambda.domain.lambda.LambdaMailRequestSendgrid;

public interface LambdaService {
	
	String obtenerBase64(LambdaFileBase64Request request);
	
	JsonObject enviarCorreo(LambdaMailRequestSendgrid request);

}
