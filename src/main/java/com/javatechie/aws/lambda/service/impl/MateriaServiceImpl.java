package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.subMateriaResponseProccesor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.request.MateriaBody;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequestBody;
import com.javatechie.aws.lambda.domain.response.MateriaResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoMateria;
import com.javatechie.aws.lambda.service.MateriaService;
import com.javatechie.aws.lambda.service.SubMateriaService;

@Service
public class MateriaServiceImpl extends CrudImpl<Materia, String> implements MateriaService {

    @Autowired
    private RepoMateria repo;

    @Autowired
    private SubMateriaService subMateriaService;

    @Override
    public MateriaResponse registrar(MateriaBody request) {

        return transformToResponse(registrar(bodyToEntity(request)));
    }

    @Override
    protected GenericRepo<Materia, String> getRepo() {

        return repo;
    }

    @Override
    public Materia buscarPorIdMateria(String idMateria) {
        Optional<Materia> materia = verPorId(idMateria);
        if (!materia.isPresent()) {
            throw new NotFoundException("Materia no encontrada : " + idMateria);
        }
        return materia.get();
    }

    @Override
    public MateriaResponse verPorIdMateria(String id) {
        return transformToResponse(buscarPorIdMateria(id));
    }

    @Override
    public MateriaResponse actualizar(MateriaBody request) {

        return transformToResponse(modificar(bodyToEntity(request)));
    }

    @Override
    public List<MateriaResponse> ListarMateriaResponse() {
        return listar().stream().map(this::transformToResponse).collect(Collectors.toList());
    };

    @Override
    public List<MateriaResponse> listarMateriasPorEstado(Boolean estado) {
        return repo.findByEstado(true).stream().map(this::transformToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public List<MateriaResponse> ListarMateriasYSubmaterias() {

        return listar().stream().filter(materia -> materia.getEstado()).map(this::listarTodas)
                .collect(Collectors.toList());
    }


    @Override
    public List<ReactSelectResponse> listarInfraccionesParaReactSelect(
            List<SubMateria> subMaterias) {
        return subMaterias.stream().map(this::transformToReactSelect).collect(Collectors.toList());
    }
    
    @Override
    public List<Map<String, Object>> verSubMaterias(SubMateriaRequestBody request) {
        List<Map<String, Object>> listMap = new ArrayList<Map<String, Object>>();        
        request.getIds().forEach(id -> {
            Map<String, Object> map = new HashMap<String, Object>();
            Materia materia = buscarPorIdMateria(id);
            map.put("id_materia", materia.getIdMateria());
            map.put("nombre_materia", materia.getNombreMateria());
            map.put("sub_materia_check", transformToInfraccionResponse(
                    subMateriaService.listarPorIdMateriaYPrioridad(materia.getIdMateria(), true)));
            map.put("sub_materia_select", listarInfraccionesParaReactSelect(
                    subMateriaService.listarPorIdMateriaYPrioridad(materia.getIdMateria(), false)));
            listMap.add(map);
        });
        return listMap;
    }

    private List<SubMateriaResponse> transformToInfraccionResponse(List<SubMateria> subMaterias) {
        return subMaterias.stream().map(infraccion -> subMateriaResponseProccesor(infraccion))
                .collect(Collectors.toList());
    }

    private MateriaResponse transformToResponse(Materia materia) {
        return MateriaResponse.builder().idMateria(materia.getIdMateria())
                .nombreMateria(materia.getNombreMateria()).color(materia.getColor())
                .icono(materia.getIcono()).estado(materia.getEstado()).build();
    }

    private Materia bodyToEntity(MateriaBody request) {
        return new Materia(request.getIdMateria(), request.getNombreMateria(), request.getColor(),
                request.getIcono(), request.getEstado());
    }

    private MateriaResponse listarTodas(Materia materia) {
        return MateriaResponse.builder().idMateria(materia.getIdMateria())
                .nombreMateria(materia.getNombreMateria()).subMaterias(subMateriaService
                        .listarPorIdMateriaYPrioridad(materia.getIdMateria(), true))
                .estado(materia.getEstado()).build();
    }

    private ReactSelectResponse transformToReactSelect(SubMateria subMateria) {
        return new ReactSelectResponse(subMateria.getIdSubMateria(),
                subMateria.getNombreSubMateria(), 0);
    }

    @Override
    public List<ReactSelectResponse> listarReactSelect() {
        List<Materia> materias = listar();
        List<ReactSelectResponse> newList = new ArrayList<ReactSelectResponse>();
        for (Materia materia : materias) {
            newList.add(new ReactSelectResponse(materia.getIdMateria(), materia.getNombreMateria(), null));
        }
        return newList;
    }
}
