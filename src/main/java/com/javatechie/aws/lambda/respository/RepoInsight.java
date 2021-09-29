package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Insight;


@EnableScan
@Repository
public interface RepoInsight extends GenericRepo<Insight, String> {

	List<Insight> findByEstado(Boolean estado);
	
}
