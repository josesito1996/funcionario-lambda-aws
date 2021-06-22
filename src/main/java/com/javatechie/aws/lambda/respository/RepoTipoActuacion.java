package com.javatechie.aws.lambda.respository;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.TipoActuacion;


@EnableScan
@Repository
public interface RepoTipoActuacion extends GenericRepo<TipoActuacion, String> {

}
