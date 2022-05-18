package com.javatechie.aws.lambda.respository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepo<T,ID> extends CrudRepository<T, ID> {

}
