package com.javatechie.aws.lambda.domain.response;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@NoArgsConstructor
@Setter
@ToString
public class ArticuloResponseBody {
    private String nombreArticulo;
    private List<Map<String, String>> subArticulos;
}
