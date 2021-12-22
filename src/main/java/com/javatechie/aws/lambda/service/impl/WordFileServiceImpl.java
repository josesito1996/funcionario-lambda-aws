package com.javatechie.aws.lambda.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.request.WordFileCasoRequest;
import com.javatechie.aws.lambda.service.WordFileService;
import com.javatechie.aws.lambda.util.WordUtil;

@Service
public class WordFileServiceImpl implements WordFileService {

	@Autowired
	private WordUtil wordUtil;

	@Override
	public ResponseEntity<ByteArrayResource> getWordFileCaso(WordFileCasoRequest request, HttpHeaders headers) {
		return new ResponseEntity<>(wordUtil.getWordFile(request), headers, HttpStatus.OK);
	}
}
