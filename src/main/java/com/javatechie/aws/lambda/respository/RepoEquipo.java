package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Equipo;


@EnableScan
@Repository
public interface RepoEquipo extends GenericRepo<Equipo, String> {

	List<Equipo> findByEstado(Boolean estado);
	
}
