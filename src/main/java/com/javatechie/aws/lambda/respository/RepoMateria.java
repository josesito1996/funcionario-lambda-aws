package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Materia;


@EnableScan
@Repository
public interface RepoMateria extends GenericRepo<Materia, String> {

	List<Materia> findByEstado(Boolean estado);
	
}
