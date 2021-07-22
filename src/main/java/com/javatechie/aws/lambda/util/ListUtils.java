package com.javatechie.aws.lambda.util;

import java.util.Comparator;
import java.util.List;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

public class ListUtils {

    public static List<ReactSelectResponse> orderByDesc(List<ReactSelectResponse> select) {
        select.sort(Comparator.comparing(ReactSelectResponse::getNroOrden));
        return select;
    }
    
    
}
