package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Origen;


@EnableScan
@Repository
public interface RepoOrigen extends GenericRepo<Origen, String> {

	List<Origen> findByEstado(Boolean estado);
	
}
