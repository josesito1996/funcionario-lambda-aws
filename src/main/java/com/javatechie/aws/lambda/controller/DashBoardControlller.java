package com.javatechie.aws.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.respository.jdbc.ControlTotalJdbc;

@RequestMapping("/api-dash")
@RestController
public class DashBoardControlller {

	@Autowired
	private ControlTotalJdbc controlJdbc;
	
	
	@GetMapping(path = "/total")
	public ControlTotalesQuery totales() {
		return controlJdbc.controlTotalesQuery();
	}
	
}
