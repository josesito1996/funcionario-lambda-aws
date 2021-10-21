package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.infraccionResponseProccesor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.request.InfraccionRequestBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseSelect;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.domain.response.custom.CustomSelectResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoInfraccion;
import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.impl.builder.InfraccionRequestBuilder;
import com.javatechie.aws.lambda.util.ListUtils;

@Service
public class InfraccionServiceImpl extends CrudImpl<Infraccion, String>
        implements InfraccionService {

    @Autowired
    private RepoInfraccion repo;

    @Autowired
    private InfraccionRequestBuilder builder;

    @Override
    protected GenericRepo<Infraccion, String> getRepo() {
        return repo;
    }

    @Override
    public List<Infraccion> verPorIdMateria(String idMateria) {
        return repo.findByIdMateria(idMateria);
    }

    @Override
    public List<InfraccionResponse> registrarInfraccion(List<InfraccionRequestBody> request) {
        return registrarMasivo(builder.infraccionListBuilder(request)).stream()
                .map(infraccion -> infraccionResponseProccesor(infraccion))
                .collect(Collectors.toList());
    }

    @Override
    public List<InfraccionResponse> listarInfracciones() {
        return listar().stream().map(infraccion -> infraccionResponseProccesor(infraccion))
                .collect(Collectors.toList());
    }

    @Override
    public List<SubMateriaResponse> listarSubMateriasPorIdMateria(String idMateria) {
        return verPorIdMateria(idMateria).stream().map(this::getSubmateriaResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<Infraccion> verPorIdMateriaYPrioridad(String idMateria, Boolean prioridad) {
        return repo.findByIdMateriaAndPrioridad(idMateria, prioridad);
    }

    @Override
    public List<Infraccion> verPorIdSubMateria(String idSubMateria) {
        return repo.findByIdSubMateria(idSubMateria);
    }

    private SubMateriaResponse getSubmateriaResponse(Infraccion infraccion) {
        return SubMateriaResponse.builder().idSubMateria(infraccion.getIdInfraccion())
                .subMateria(infraccion.getSubMateria()).build();
    }

    @Override
    public List<InfraccionResponseSelect> listarSelectPorIdSubMateria(String idSubMateria) {
        List<Infraccion> infracciones = verPorIdSubMateria(idSubMateria);
        List<InfraccionResponseSelect> newList = new ArrayList<InfraccionResponseSelect>();
        for (Infraccion infraccion : infracciones) {
            newList.add(InfraccionResponseSelect.builder()
                    .idInfraccion(infraccion.getIdInfraccion()).baseLegal(infraccion.getBaseLegal())
                    .descripcion(infraccion.getDescripcion()).build());
        }
        return newList;
    }

    @Deprecated
    @Override
    public Map<String, Object> listarSelectPorIdSubMateriaAux(String idSubMateria) {
        List<Infraccion> infracciones = verPorIdSubMateria(idSubMateria);
        if (infracciones.isEmpty()) {
            return new HashMap<String, Object>();
        }
        Map<String, Object> map = new HashMap<String, Object>();
        List<ReactSelectResponse> listReact = new ArrayList<ReactSelectResponse>();
        for (Infraccion inf : infracciones) {
            listReact.add(new ReactSelectResponse(inf.getIdInfraccion(),
                    inf.getBaseLegal() + " - " + inf.getDescripcion(), null, null));
        }
        map.put("select", listReact);
        return map;
    }

    @Override
    public Map<String, Object> verGravedadPorIdInfraccion(String idInfraccion) {
        Infraccion infraccion = verPorIdInfraccion(idInfraccion);
        Map<String, Object> newMap = new HashMap<String, Object>();
        newMap.put("nombre", infraccion.getGravedad());
        newMap.put("puntaje", infraccion.getPuntajeGravedad());
        return newMap;
    }

    @Override
    public Infraccion verPorIdInfraccion(String idInfraccion) {
        Optional<Infraccion> infraccionOptional = verPorId(idInfraccion);
        if (!infraccionOptional.isPresent()) {
            throw new NotFoundException("No hay infraccion con el Id : " + idInfraccion);
        }
        return infraccionOptional.get();
    }

    @Override
    public CustomSelectResponse listarSelectPorIdSubMateriaAuxV2(String idSubMateria) {
        List<Infraccion> infraccionesList = verPorIdSubMateria(idSubMateria);
        if (infraccionesList.isEmpty()) {
            List<ReactSelectResponse> listEmpty = new ArrayList<ReactSelectResponse>();
            return CustomSelectResponse.builder().baseLegal(listEmpty).restoBaseLegal(listEmpty)
                    .build();
        }
        List<ReactSelectResponse> infracciones = infraccionesList.stream()
                .map(ListUtils::transformFromInfraccion)
                .sorted(Comparator.comparing(ReactSelectResponse::getCampoAux))
                .collect(Collectors.toList());
        List<ReactSelectResponse> restoInfracciones = listar().stream()
                .filter(item -> !item.getIdSubMateria().equals(idSubMateria))
                .map(ListUtils::transformFromInfraccion)
                .sorted(Comparator.comparing(ReactSelectResponse::getCampoAux))
                .collect(Collectors.toList());
        return CustomSelectResponse.builder()
                .baseLegal(infracciones)
                .restoBaseLegal(restoInfracciones)
                .build();
    }
}
