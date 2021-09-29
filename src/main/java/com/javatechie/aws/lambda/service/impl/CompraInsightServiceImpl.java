package com.javatechie.aws.lambda.service.impl;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.CompraInsight;
import com.javatechie.aws.lambda.domain.request.CompraInsightRequest;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoCompraInsight;
import com.javatechie.aws.lambda.service.CompraInsightService;
import com.javatechie.aws.lambda.service.InsightService;

@Service
public class CompraInsightServiceImpl extends CrudImpl<CompraInsight, String>
        implements CompraInsightService {

    @Autowired
    private RepoCompraInsight repo;

    @Autowired
    private InsightService insightService;

    @Override
    protected GenericRepo<CompraInsight, String> getRepo() {
        return repo;
    }

    @Override
    public Map<String, Object> registrarConsulta(CompraInsightRequest request) {
        insightService.verUnoPorId(request.getIdInsight());
        CompraInsight compra = registrar(transformToCompraInsight(request));
        Map<String, Object> newMap = new HashMap<String, Object>();
        newMap.put("id", compra.getIdCompra());
        return newMap;
    }

    private CompraInsight transformToCompraInsight(CompraInsightRequest request) {
        return CompraInsight.builder().idInsight(request.getIdInsight())
                .telefono(request.getCelular()).consulta(request.getConsulta()).estado(true)
                .build();
    }

}
