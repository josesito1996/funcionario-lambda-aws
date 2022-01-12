package com.javatechie.aws.lambda.respository;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.stereotype.Repository;

import com.javatechie.aws.lambda.domain.Inspector;

@EnableScan
@Repository
public interface RepoInspector extends GenericRepo<Inspector, String> {

	Inspector findOneByNombreInspector(String nombreInspector);
	
	List<Inspector> findByNombreInspectorContaining(String nombreInspector);

	List<Inspector> findByTipoAndEstado(String tipo, Boolean estado);
	
	List<Inspector> findByTipoAndEtapaAndEstado(String tipo, String etapa, Boolean estado);
}
