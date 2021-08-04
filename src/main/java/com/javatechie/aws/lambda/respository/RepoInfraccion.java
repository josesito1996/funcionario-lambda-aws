package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Infraccion;


@EnableScan
@Repository
public interface RepoInfraccion extends GenericRepo<Infraccion, String> {
    
    List<Infraccion> findByIdMateria(String idMateria);
}
