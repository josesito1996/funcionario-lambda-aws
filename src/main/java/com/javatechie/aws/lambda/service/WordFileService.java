package com.javatechie.aws.lambda.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

import com.javatechie.aws.lambda.domain.request.WordFileCasoRequest;

public interface WordFileService {

	public ResponseEntity<ByteArrayResource> getWordFileCaso(WordFileCasoRequest request, HttpHeaders headers);

}
