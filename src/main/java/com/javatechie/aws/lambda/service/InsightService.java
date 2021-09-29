package com.javatechie.aws.lambda.service;

import java.util.List;
import java.util.Map;

import com.javatechie.aws.lambda.domain.Insight;

public interface InsightService extends ICrud<Insight, String> {
    
    List<Map<String, Object>> listarIsnights();
    
    Insight verUnoPorId(String id);
}
