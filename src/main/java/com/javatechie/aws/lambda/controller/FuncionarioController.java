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

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.service.FuncionarioService;


@RestController
@RequestMapping("/api-funcionario")
public class FuncionarioController {

  @Autowired
  private FuncionarioService service;

  @GetMapping(path = "/listAll")
  public List<Funcionario> listarTodos() {
      return service.listar();
  }

  @GetMapping(path = "/listById/{id}")
  public Funcionario buscarPorId(@PathVariable String id) {
      return service.verPorId(id);
  }

  @PostMapping(path = "/save")
  public Funcionario registrar(@RequestBody Funcionario request) {
      return service.registrar(request);
  }

  @PutMapping(path = "/update")
  public Funcionario modificar(@RequestBody Funcionario request) {
      return service.modificar(request);
  }

}
