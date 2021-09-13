package com.javatechie.aws.lambda.controller;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.jdbc.PromedioPuntajeInspectorQuery;
import com.javatechie.aws.lambda.domain.jdbc.PuntuacionMaestro;
import com.javatechie.aws.lambda.domain.request.PuntuacionRequest;
import com.javatechie.aws.lambda.service.PuntuacionService;

@RestController
@RequestMapping("/api-puntuacion")
@Validated
public class PuntuacionController {

    @Autowired
    PuntuacionService service;

    @GetMapping(path = "/listPuntuacionItems")
    public List<PuntuacionMaestro> calificar() {
        return service.listarPuntuacionMaestro();
    }

    @GetMapping(path = "/averageInspector/{idInspector}")
    public List<PromedioPuntajeInspectorQuery> promedioInspector(
            @PathVariable(name = "idInspector") @Pattern(regexp = REGEX_UUID) String idInspector) {
        return service.listarPromedioPuntajeInspector(idInspector);
    }

    @PostMapping(path = "/qualify")
    public int[][] calificar(@RequestBody @Valid PuntuacionRequest request) {
        return service.registrarMasivoPuntuacionInspector(request);
    }

}
