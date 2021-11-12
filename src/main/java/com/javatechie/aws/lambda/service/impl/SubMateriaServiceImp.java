package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.articuloResponseBodySorted;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.javatechie.aws.lambda.domain.Articulo;
import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.request.SubMateriaRequest;
import com.javatechie.aws.lambda.domain.response.ArticuloResponseBody;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseBody;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoSubMateria;
import com.javatechie.aws.lambda.service.ArticuloService;
import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.MateriaService;
import com.javatechie.aws.lambda.service.SubMateriaService;

@Service
public class SubMateriaServiceImp extends CrudImpl<SubMateria, String>
        implements SubMateriaService {

    @Autowired
    private RepoSubMateria repo;

    @Autowired
    private MateriaService materiaService;

    @Autowired
    private InfraccionService infraccionService;

    @Autowired
    private ArticuloService articuloService;

    @Override
    public SubMateria buscarPorIdSubMateria(String idSubMateria) {
        Optional<SubMateria> optional = verPorId(idSubMateria);
        if (!optional.isPresent()) {
            throw new NotFoundException("SubMateria no existe : " + idSubMateria);
        }
        return optional.get();
    }

    @Override
    protected GenericRepo<SubMateria, String> getRepo() {
        return repo;
    }

    @Override
    public List<SubMateria> listarPorIdMateriaYPrioridad(String idMateria, Boolean prioridad) {
        return repo.findByIdMateriaAndPrioridad(idMateria, prioridad);
    }

    @Override
    public List<SubMateriaResponse> registrarInfraccion(List<SubMateriaRequest> request) {
        return registrarMasivo(toSubMateriaList(request)).stream().map(this::toSubMateriaResponse)
                .collect(Collectors.toList());
    }

    private SubMateriaResponse toSubMateriaResponse(SubMateria response) {
        return SubMateriaResponse.builder().idSubMateria(response.getIdSubMateria())
                .subMateria(response.getNombreSubMateria()).build();
    }

    private List<SubMateria> toSubMateriaList(List<SubMateriaRequest> request) {
        return request.stream().map(this::toSubMateria).collect(Collectors.toList());
    }

    private SubMateria toSubMateria(SubMateriaRequest request) {
        return SubMateria.builder().idSubMateria(request.getIdSubMateria())
                .idMateria(request.getIdMateria()).nombreSubMateria(request.getNombreSubMateria())
                .prioridad(request.getPrioridad()).build();
    }

    @Override
    public List<SubMateria> listarPorIdMateria(String idMateria) {
        return repo.findByIdMateria(idMateria);
    }

    @Override
    public InfraccionResponseBody infraccionResponseBodyByIdSubMateria(String idSubMateria) {
        SubMateria subMateria = buscarPorIdSubMateria(idSubMateria);
        Materia materia = materiaService.buscarPorIdMateria(subMateria.getIdMateria());
        List<Infraccion> infracciones = infraccionService.verPorIdSubMateria(idSubMateria);
        List<String> idArticulos = infracciones.stream()
                .map(infraccion -> infraccion.getIdArticulo()).distinct()
                .collect(Collectors.toList());
        List<ArticuloResponseBody> articulos = new ArrayList<ArticuloResponseBody>();
        for (String idArticulo : idArticulos) {
            Articulo articulo = articuloService.verArticuloPorId(idArticulo);
            articulos
                    .add(ArticuloResponseBody.builder().nombreArticulo(articulo.getNombreArticulo())
                            .subArticulos(subArticulosResponse(infracciones, idArticulo)).build());
        }
        return InfraccionResponseBody.builder().nombreMateria(materia.getNombreMateria())
                .nombreSubMateria(subMateria.getNombreSubMateria())
                .infracciones("DECRETO SUPREMPO....... N° XX-XXXX")
                .articulos(articuloResponseBodySorted(articulos)).build();
    }

    private List<Map<String, String>> subArticulosResponse(List<Infraccion> infracciones,
            String idArticulo) {
        return infracciones.stream()
                .filter(infraccion -> infraccion.getIdArticulo().equals(idArticulo))
                .map(this::transformToMap).collect(Collectors.toList());
    }

    private Map<String, String> transformToMap(Infraccion infraccion) {
        Map<String, String> newMap = new HashMap<String, String>();
        newMap.put("nroSub", infraccion.getBaseLegal());
        newMap.put("descripcion", infraccion.getDescripcion());
        return newMap;
    }

    @Override
    public List<ReactSelectResponse> listarSelectPorIdMateria(String idMateria) {
        List<SubMateria> materiasPorId = listarPorIdMateria(idMateria);
        List<ReactSelectResponse> newList = new ArrayList<ReactSelectResponse>();
        for (SubMateria sub : materiasPorId) {
            newList.add(new ReactSelectResponse(sub.getIdSubMateria(), sub.getNombreSubMateria(),
                    null, null));
        }
        return newList;
    }
}
