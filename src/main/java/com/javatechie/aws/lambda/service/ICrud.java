package com.javatechie.aws.lambda.service;

import java.util.List;

public interface ICrud <T,ID>{

  public T registrar(T t);
  
  public T modificar(T t);
  
  public List<T> listar();
  
  public T verPorId(ID id);
  
}
