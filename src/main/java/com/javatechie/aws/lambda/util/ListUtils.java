package com.javatechie.aws.lambda.util;

import java.util.Comparator;
import java.util.List;

import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.response.InfraccionResponse;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public class ListUtils {

    public static List<ReactSelectResponse> selectResponseOrderByNroOrdenDesc(
            List<ReactSelectResponse> select) {
        select.sort(Comparator.comparing(ReactSelectResponse::getNroOrden));
        return select;
    }
    
    public static InfraccionResponse infraccionResponseProccesor(Infraccion infraccion) {
        return InfraccionResponse.builder().idInfraccion(infraccion.getIdInfraccion())
                .baseLegal(infraccion.getBaseLegal()).subMateria(infraccion.getSubMateria())
                .build();
    }

}
