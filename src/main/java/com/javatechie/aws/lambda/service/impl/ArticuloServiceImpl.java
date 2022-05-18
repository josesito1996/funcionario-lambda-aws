package com.javatechie.aws.lambda.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Articulo;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.ArticuloRepo;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.service.ArticuloService;

@Service
public class ArticuloServiceImpl extends CrudImpl<Articulo, String> implements ArticuloService {

    @Autowired
    private ArticuloRepo repo;

    @Override
    protected GenericRepo<Articulo, String> getRepo() {
        // TODO Auto-generated method stub
        return repo;
    }

    @Override
    public Articulo verArticuloPorId(String idArticulo) {
        Optional<Articulo> articuloOption = verPorId(idArticulo);
        if (!articuloOption.isPresent()) {
            throw new NotFoundException("Articulo no existe : " + idArticulo);
        }
        return articuloOption.get();
    }

   
}
