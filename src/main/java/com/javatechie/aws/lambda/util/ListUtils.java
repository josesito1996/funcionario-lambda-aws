package com.javatechie.aws.lambda.util;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.response.ArticuloResponseBody;
import com.javatechie.aws.lambda.domain.response.EtapaResponse;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.domain.response.TipoActuacionResponse;

public class ListUtils {

    public static List<ReactSelectResponse> selectResponseOrderByNroOrdenDesc(
            List<ReactSelectResponse> select) {
        select.sort(Comparator.comparing(ReactSelectResponse::getNroOrden));
        return select;
    }
    
    public static List<ReactSelectResponse> responseChecksFilterTipoActuacion(
            List<TipoActuacionResponse> list) {
        return list.stream().map(item -> transformReactSelectResponse(item)).collect(Collectors.toList());
    }
    
    private static ReactSelectResponse transformReactSelectResponse(TipoActuacionResponse tipo) {
        return new ReactSelectResponse(tipo.getId(), tipo.getNombreTipoActuacion(), null);
    }
    
    public static List<ReactSelectResponse> responseChecksFilterEtapaActuacion(
            List<EtapaResponse> list) {
        return list.stream().map(item -> transformReactSelectResponse(item)).collect(Collectors.toList());
    }
    
    private static ReactSelectResponse transformReactSelectResponse(EtapaResponse etapa) {
        return new ReactSelectResponse(etapa.getIdEtapa(),etapa.getNombreEtapa(),null);
    }
    
    public static List<ArticuloResponseBody> articuloResponseBodySorted(
            List<ArticuloResponseBody> responseBody) {
        responseBody.sort(Comparator.comparing(ArticuloResponseBody::getNombreArticulo));
        return responseBody;
    }

    public static InfraccionResponse infraccionResponseProccesor(Infraccion infraccion) {
        return InfraccionResponse.builder().idInfraccion(infraccion.getIdInfraccion())
                .baseLegal(infraccion.getBaseLegal()).subMateria(infraccion.getSubMateria())
                .build();
    }

    public static SubMateriaResponse subMateriaResponseProccesor(SubMateria subMateria) {
        return SubMateriaResponse.builder().idSubMateria(subMateria.getIdSubMateria())
                .subMateria(subMateria.getNombreSubMateria()).build();
    }

}
