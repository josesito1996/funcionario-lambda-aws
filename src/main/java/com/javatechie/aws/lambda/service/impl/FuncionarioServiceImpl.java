package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.respository.RepoFuncionario;
import com.javatechie.aws.lambda.service.FuncionarioService;


@Service
public class FuncionarioServiceImpl implements FuncionarioService {

  @Autowired
  private RepoFuncionario repo;

  @Override
  public Funcionario registrar(Funcionario t) {

    return repo.save(t);
  }

  @Override
  public Funcionario modificar(Funcionario t) {

    return repo.save(t);
  }

  @Override
  public List<Funcionario> listar() {
    return StreamSupport.stream(repo.findAll().spliterator(), false)
        .collect(Collectors.toList());
  }

  @Override
  public Funcionario verPorId(String id) {
    Optional<Funcionario> funcionario = repo.findById(id);
    return funcionario.isPresent() ? funcionario.get() : new Funcionario();
  }
}
