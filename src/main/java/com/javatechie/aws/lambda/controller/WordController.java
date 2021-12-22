package com.javatechie.aws.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.WordFileCasoRequest;
import com.javatechie.aws.lambda.service.WordFileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api-word")
@Slf4j
public class WordController {

	@Autowired
	private WordFileService service;

	@GetMapping(path = "/download")
	public HttpEntity<ByteArrayResource> getFile(@RequestHeader HttpHeaders headers) {
		log.info("Headers {} ", headers);
		headers.setContentType(new MediaType("application", "force-download"));
        headers.set(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=ProductTemplate.docx");
		return service.getWordFileCaso(WordFileCasoRequest.builder().build(),headers);
	}

}
