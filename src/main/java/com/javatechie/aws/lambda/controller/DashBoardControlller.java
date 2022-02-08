package com.javatechie.aws.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.service.DashboardService;

@RequestMapping("/api-dash")
@RestController
public class DashBoardControlller {

	@Autowired
	private DashboardService service;

	@GetMapping(path = "/total")
	public ControlTotalesQuery totales() {
		return service.totales();
	}

	@GetMapping(path = "/inspectionsPerMonth")
	public BarChartResponse inspeccionesPorMes() {
		return service.inspeccionesPorMes();
	}

	@GetMapping(path = "/inspectionsPerYear/{anio}")
	public BarChartResponse ins(@PathVariable Integer anio) {
		return service.inspeccionesPorMesesByAnio(anio);
	}

}
