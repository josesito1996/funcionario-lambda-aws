package com.javatechie.aws.lambda.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.InfraccionItem;
import com.javatechie.aws.lambda.domain.ReactSelect;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;
import com.javatechie.aws.lambda.domain.request.InfraccionItemRequest;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoAnalisisRiesgo;
import com.javatechie.aws.lambda.service.AnalisisRiesgoService;

@Service
public class AnalisisRiesgoServiceImpl extends CrudImpl<AnalisisRiesgo, String>
        implements AnalisisRiesgoService {

    @Autowired
    private RepoAnalisisRiesgo repo;

    @Override
    protected GenericRepo<AnalisisRiesgo, String> getRepo() {
        return repo;
    }

    @Transactional
    @Override
    public Map<String, Object> registrarAnalisisRiesgo(InfraccionAnalisisRequest request) {
        AnalisisRiesgo analisisRiesgo = transformAnalisisRiesgo(request);
        AnalisisRiesgo newRow = registrar(analisisRiesgo);
        if (newRow.getIdAnalisis() != null) {
            Map<String, Object> newMap = new HashMap<String, Object>();
            newMap.put("ID", newRow.getIdAnalisis());
            return newMap;
        }
        return new HashMap<String, Object>();
    }

    /**
     * Pasar a un clase Aparte
     */
    private AnalisisRiesgo transformAnalisisRiesgo(InfraccionAnalisisRequest request) {
        return AnalisisRiesgo.builder()
                .origenCaso(ReactSelect.builder().label(request.getOrigenCaso().getLabel())
                        .value(request.getOrigenCaso().getValue()).build())
                .nombreAsesor(request.getNameAsesor())
                .infracciones(transformInfraccionItems(request.getInfractions()))
                .nivelRiesgo(ReactSelect.builder().label(request.getNivelRiesgo().getLabel())
                        .value(request.getNivelRiesgo().getValue()).build())
                .cantidadInvolucrados(request.getCantInvolucrados()).build();
    }

    private List<InfraccionItem> transformInfraccionItems(List<InfraccionItemRequest> requests) {
        return requests.stream().map(this::transformInfraccionItem).collect(Collectors.toList());
    }

    private InfraccionItem transformInfraccionItem(InfraccionItemRequest request) {
        return InfraccionItem.builder()
                .materia(ReactSelect.builder().label(request.getMateria().getLabel())
                        .value(request.getMateria().getValue()).build())
                .subMaterias(ReactSelect.builder().value(request.getSelectSubmateria().getValue())
                        .label(request.getSelectSubmateria().getLabel()).build())
                .baseLegal(ReactSelect.builder().value(request.getSelectBaseLegal().getValue())
                        .label(request.getSelectBaseLegal().getLabel()).build())
                .gravedad(request.getGravedad()).provision(request.getProvision())
                .descripcion(request.getDescripcion()).trabajadoresAfectados(request.getAfectados())
                .build();
    }
}
