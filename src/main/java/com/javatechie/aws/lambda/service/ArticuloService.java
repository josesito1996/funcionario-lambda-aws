package com.javatechie.aws.lambda.service;

import com.javatechie.aws.lambda.domain.Articulo;

public interface ArticuloService extends ICrud<Articulo, String> {

   public Articulo verArticuloPorId(String idArticulo);
    
}
