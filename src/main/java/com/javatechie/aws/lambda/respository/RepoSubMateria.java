package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.SubMateria;

@EnableScan
@Repository
public interface RepoSubMateria extends GenericRepo<SubMateria, String> {

    List<SubMateria> findByIdMateriaAndPrioridad(String idMateria, Boolean prioridad);

}
