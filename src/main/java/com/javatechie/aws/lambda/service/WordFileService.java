package com.javatechie.aws.lambda.service;

import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;

public interface WordFileService {

	public ResponseEntity<ByteArrayResource> getWordFileCaso(String idCaso, HttpHeaders headers);

}
