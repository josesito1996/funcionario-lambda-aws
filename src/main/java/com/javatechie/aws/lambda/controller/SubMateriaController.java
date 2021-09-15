package com.javatechie.aws.lambda.controller;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javatechie.aws.lambda.domain.request.SubMateriaRequest;
import com.javatechie.aws.lambda.domain.response.InfraccionResponseBody;
import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;
import com.javatechie.aws.lambda.domain.response.SubMateriaResponse;
import com.javatechie.aws.lambda.service.SubMateriaService;

@RestController
@RequestMapping("/api-SubMateria")
@Validated
public class SubMateriaController {

    @Autowired
    private SubMateriaService service;

    @GetMapping(path = "/listReactSelect/{idMateria}")
    public List<ReactSelectResponse> listarReactSelect(
            @PathVariable @NotEmpty @NotNull @Pattern(regexp = REGEX_UUID, message = "id no valido") String idMateria) {
        return service.listarSelectPorIdMateria(idMateria);
    }

    @PostMapping(path = "/saveAll")
    public List<SubMateriaResponse> saveAll(@Valid @RequestBody List<SubMateriaRequest> request) {
        return service.registrarInfraccion(request);
    }

    @GetMapping(path = "/viewDetailSubMateriaByIdSubMateria/{idSubMateria}")
    public InfraccionResponseBody infraccionResponseBody(@PathVariable String idSubMateria) {
        return service.infraccionResponseBodyByIdSubMateria(idSubMateria);
    }
}
