package com.javatechie.aws.lambda.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.FuncionarioBody;
import com.javatechie.aws.lambda.domain.response.FuncionarioResponse;
import com.javatechie.aws.lambda.service.FuncionarioService;


@RestController
@RequestMapping("/api-funcionario")
public class FuncionarioController {

  @Autowired
  private FuncionarioService service;

  @GetMapping(path = "/listAll")
  public List<FuncionarioResponse> listarTodos() {
      return service.listarFuncionarios();
  }

	@GetMapping(path = "/findById/{id}")
  public FuncionarioResponse buscarPorId(@PathVariable String id) {
      return service.verPorIdFuncionario(id);
  }

  @PostMapping(path = "/save")
  public FuncionarioResponse registrar(@RequestBody FuncionarioBody request) {
      return service.registrar(request);
  }

  @PutMapping(path = "/update")
  public FuncionarioResponse modificar(@RequestBody FuncionarioBody request) {
      return service.actualizar(request);
  }

}
