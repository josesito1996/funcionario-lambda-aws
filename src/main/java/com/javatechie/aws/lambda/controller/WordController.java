package com.javatechie.aws.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.service.WordFileService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api-word")
@Slf4j
public class WordController {

	@Autowired
	private WordFileService service;

	@GetMapping(path = "/download/{idCaso}")
	public HttpEntity<ByteArrayResource> getFile(@PathVariable String idCaso, @RequestHeader HttpHeaders headers) {
		log.info("Headers {} ", headers);
		return service.getWordFileCaso(idCaso, headers);
	}

}
