package com.javatechie.aws.lambda.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.ControlTotalesQuery;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponseV2;
import com.javatechie.aws.lambda.domain.response.chart.DonnutChartCustomResponse;
import com.javatechie.aws.lambda.service.DashboardService;

@RequestMapping("/api-dash")
@RestController
public class DashBoardControlller {

	@Autowired
	private DashboardService service;

	@GetMapping(path = "/total")
	public ControlTotalesQuery totales(@RequestParam(required = false) String dpto, @RequestParam String desde,
			@RequestParam String hasta) {
		return service.totales(dpto, desde, hasta);
	}

	@GetMapping(path = "/inspectionsPerMonth")
	public BarChartResponseV2 inspeccionesPorMes(@RequestParam(required = false) String dpto,
			@RequestParam String desde, @RequestParam String hasta) {
		return service.inspeccionesPorMes(dpto, desde, hasta);
	}

	@GetMapping(path = "/inspectionsPerYear/{anio}")
	public BarChartResponse ins(@PathVariable Integer anio, @RequestParam(required = false) String dpto,
			@RequestParam String desde, @RequestParam String hasta) {
		return service.inspeccionesPorMesesByAnio(anio, dpto, desde, hasta);
	}

	@GetMapping(path = "/finesForMayor/{intendencia}")
	public DonnutChartCustomResponse chartDonnuts(@PathVariable String intendencia) {
		return service.graficosDeDonnas(intendencia);
	}

}
