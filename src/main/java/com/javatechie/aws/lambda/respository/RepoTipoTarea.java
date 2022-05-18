package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.TipoTarea;


@EnableScan
@Repository
public interface RepoTipoTarea extends GenericRepo<TipoTarea, String> {

	List<TipoTarea> findByEstado(Boolean estado);
	
}
