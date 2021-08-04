package com.javatechie.aws.lambda.service.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.service.ICrud;

public abstract class CrudImpl<T, ID> implements ICrud<T, ID> {

    protected abstract GenericRepo<T, ID> getRepo();

    @Override
    public T registrar(T t) {
        return getRepo().save(t);
    };

    @Override
    public List<T> registrarMasivo(List<T> t) {
        return StreamSupport.stream(getRepo().saveAll(t).spliterator(), false)
                .collect(Collectors.toList());
    };

    @Override
    public T modificar(T t) {
        return getRepo().save(t);
    };

    @Override
    public List<T> listar() {
        return StreamSupport.stream(getRepo().findAll().spliterator(), false)
                .collect(Collectors.toList());
    };

    @Override
    public Optional<T> verPorId(ID id) {
        return getRepo().findById(id);
    };

}
