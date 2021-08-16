package com.javatechie.aws.lambda.domain.response;

import java.util.List;

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
public class InfraccionResponseBody {
    private String nombreMateria;
    private String nombreSubMateria;
    private String infracciones;
    private List<ArticuloResponseBody> articulos;
}
