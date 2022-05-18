package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.EstadoCaso;


@EnableScan
@Repository
public interface RepoEstadoCaso extends GenericRepo<EstadoCaso, String> {

	List<EstadoCaso> findByEstado(Boolean estado);
	
}
