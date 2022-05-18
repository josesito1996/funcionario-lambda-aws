package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Funcionario;


@EnableScan
@Repository
public interface RepoFuncionario extends GenericRepo<Funcionario, String> {

	List<Funcionario> findByEstado (Boolean estado);
	
}
