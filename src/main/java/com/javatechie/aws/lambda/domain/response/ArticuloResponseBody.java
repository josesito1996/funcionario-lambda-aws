package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import io.swagger.v3.oas.annotations.media.Schema;
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
public class ArticuloResponseBody implements Serializable {

    private static final long serialVersionUID = 5475869034196446714L;

    @Schema(title = "Nombre articulo", name = "nombreArticulo", example = "15d171e2-b75b-4e57-b9de-6392139dbf42")
    private String nombreArticulo;

    @Schema(title = "Sub articulos", name = "subArticulos", example = "[{\"descripcion\":\"La presentación de documentación falsa ante la autoridad competente para acogerse al incremento porcentual de los límites de contratación bajo modalidades formativas.\",\"nroSub\":\"40.5\"}]")
    private List<Map<String, String>> subArticulos;
}
