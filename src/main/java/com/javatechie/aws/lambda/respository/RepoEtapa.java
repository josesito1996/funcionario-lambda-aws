package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Etapa;


@EnableScan
@Repository
public interface RepoEtapa extends GenericRepo<Etapa, String> {

	List<Etapa> findByEstado(Boolean estado);
	
}
