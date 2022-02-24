package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Comentario;


@EnableScan
@Repository
public interface RepoComentario extends GenericRepo<Comentario, String> {
	
	List<Comentario> findByIdentificador(String identificador);
}
