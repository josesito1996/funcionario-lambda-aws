package com.javatechie.aws.lambda.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.MultaUitQuery;
import com.javatechie.aws.lambda.domain.request.MultaUitParams;
import com.javatechie.aws.lambda.respository.jdbc.MultaUitJdbc;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping(path = "/api-multa-uit")
@Slf4j
public class MultaUitController {

  @Autowired
  private MultaUitJdbc multaUitJdbc;

  @GetMapping(path = "/verMultaUit")
  private MultaUitQuery verMultaUit(@Valid MultaUitParams params) {
    log.info("MultaUitController.verMultaUit");
    return multaUitJdbc.viewMultaUitQuery(params.getTipoEmpresa(), params.getTipoInfraccion(),
        params.getCantidadTrabajadores());
  }

}
