package com.javatechie.aws.lambda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Insight;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoInsight;
import com.javatechie.aws.lambda.service.InsightService;

@Service
public class InsightServiceImpl extends CrudImpl<Insight, String> implements InsightService {

	@Autowired
	private RepoInsight repo;

    @Override
    protected GenericRepo<Insight, String> getRepo() {
        return repo;
    }

    @Override
    public List<Map<String, Object>> listarIsnights() {
        List<Insight> listarActivos = repo.findByEstado(true);
        return listarActivos.stream().map(this::transformToMap).collect(Collectors.toList());
    }
    
    private Map<String, Object> transformToMap(Insight insight){
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("id", insight.getIdInsight());
        map.put("name", insight.getNombreCaracteristica());
        return map;
    }

    @Override
    public Insight verUnoPorId(String id) {
        Optional<Insight> optional = verPorId(id);
        if (!optional.isPresent()) {
            throw new NotFoundException("No es encuentra Insight con el ID : " + id);
        }
        return optional.get();
    }
}
