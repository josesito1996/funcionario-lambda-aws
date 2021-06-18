package com.javatechie.aws.lambda;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.javatechie.aws.lambda.domain.Funcionario;
import com.javatechie.aws.lambda.service.FuncionarioService;

@SpringBootApplication
public class SpringbootAwsLambdaApplication {

  @Autowired
  private FuncionarioService service;

  @Bean
  public Supplier<List<Funcionario>> listAll() {
    return () -> service.listar();
  }

  @Bean
  public Function<String, Funcionario> findById() {
    return (id) -> service.verPorId(id);
  }

  @Bean
  public Consumer<Funcionario> save() {
    return (funcionario) -> service.registrar(funcionario);
  }

  @Bean
  public Consumer<Funcionario> update() {
    return (funcionario) -> service.modificar(funcionario);
  }
  
  public static void main(String[] args) {
    SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
  }

}
