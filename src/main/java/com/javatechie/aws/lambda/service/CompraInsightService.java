package com.javatechie.aws.lambda.service;

import java.util.Map;

import com.javatechie.aws.lambda.domain.CompraInsight;
import com.javatechie.aws.lambda.domain.request.CompraInsightRequest;

public interface CompraInsightService extends ICrud<CompraInsight, String> {
    Map<String, Object> registrarConsulta(CompraInsightRequest request);
}
