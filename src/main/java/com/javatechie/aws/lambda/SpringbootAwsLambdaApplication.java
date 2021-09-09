package com.javatechie.aws.lambda;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.javatechie.aws.lambda.domain.Articulo;
import com.javatechie.aws.lambda.domain.Etapa;
import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.TipoActuacion;
import com.javatechie.aws.lambda.respository.jdbc.InspectorJdbc;
import com.javatechie.aws.lambda.service.ArticuloService;
import com.javatechie.aws.lambda.service.EtapaService;
import com.javatechie.aws.lambda.service.InspectorService;
//import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.MateriaService;
import com.javatechie.aws.lambda.service.TipoActuacionService;

@SpringBootApplication
public class SpringbootAwsLambdaApplication implements CommandLineRunner {

    @Autowired
    MateriaService materiaService;

    @Autowired
    InspectorService inspectorService;

    @Autowired
    EtapaService etapaService;

    @Autowired
    TipoActuacionService tipoActuacionService;

    @Autowired
    ArticuloService articuloService;

    @Autowired
    InspectorJdbc inspectorJdbc;

    /**
     * @Autowired InfraccionService infraccionService;
     */

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cargarMaterias();
        cargarEtapas();
        cargatTipoActuacion();
        registrarArticulos();
        //testJDBC();
        // updateInfraccion();
    }

    public void cargarMaterias() {
        if (materiaService.listar().isEmpty()) {
            Arrays.asList(
                    Materia.builder().estado(true).color("blue").icono("iconoPromocion")
                            .nombreMateria("Promocion y formacion").build(),
                    Materia.builder().estado(true).color("black").icono("iconoIntermediacion")
                            .nombreMateria("Intermediacion laboral").build(),
                    Materia.builder().estado(true).color("brown").icono("iconoLaborInspectiva")
                            .nombreMateria("Labor inspectiva").build(),
                    Materia.builder().estado(true).color("purple").icono("iconoExtranjeros")
                            .nombreMateria("Extranjeros").build(),
                    Materia.builder().estado(true).color("skyblue").icono("iconoSeguridadSocial")
                            .nombreMateria("Seguridad social").build(),
                    Materia.builder().estado(true).color("grey").icono("iconoEmpleo")
                            .nombreMateria("Empleo y colocacion").build(),
                    Materia.builder().estado(true).color("orange").icono("iconoSeguridad")
                            .nombreMateria("Seguridad y salud en el trabajo").build(),
                    Materia.builder().estado(true).color("green").icono("iconoEmpleo")
                            .nombreMateria("Relaciones laborales").build())
                    .forEach(materia -> {
                        materiaService.registrar(materia);
                    });
        }
    }

    public void cargarEtapas() {
        if (etapaService.listar().isEmpty()) {
            Arrays.asList(Etapa.builder().nombreEtapa("Investigacion").estado(true).build(),
                    Etapa.builder().nombreEtapa("Sancionadora").estado(true).build(),
                    Etapa.builder().nombreEtapa("Instruccion").estado(true).build())
                    .forEach(etapa -> {
                        etapaService.registrar(etapa);
                    });
        }
    }

    public void cargatTipoActuacion() {
        if (tipoActuacionService.listar().isEmpty()) {
            Arrays.asList(
                    TipoActuacion.builder().nombreTipoActuacion("Acta de Infracción").estado(true)
                            .build(),
                    TipoActuacion.builder().nombreTipoActuacion("Escrito").estado(true).build(),
                    TipoActuacion.builder().nombreTipoActuacion("Comparecencia").estado(true)
                            .build(),
                    TipoActuacion.builder().nombreTipoActuacion("Requerimiento de comparecencia")
                            .estado(true).build(),
                    TipoActuacion.builder().nombreTipoActuacion("Apelacion").estado(true).build(),
                    TipoActuacion.builder().nombreTipoActuacion("Descargos").estado(true).build(),
                    TipoActuacion.builder().nombreTipoActuacion("Vista inspectiva").estado(true)
                            .build(),
                    TipoActuacion.builder().nombreTipoActuacion("Requerimiento").estado(true)
                            .build(),
                    TipoActuacion.builder().nombreTipoActuacion("Resolucion").estado(true).build())
                    .forEach(tipo -> {
                        tipoActuacionService.registrar(tipo);
                    });
        }
    }

    /**
     * public void updateInfraccion() { infraccionService.listar().forEach(item -> {
     * item.setPrioridad(false); infraccionService.modificar(item); }); }
     */

    public void registrarArticulos() {
        List<Articulo> articulos = articuloService.listar();
        if (articulos.isEmpty()) {
            for (int i = 23; i <= 46; i++) {
                articuloService.registrar(Articulo.builder().nroArticulo(String.valueOf(i))
                        .nombreArticulo("Articulo nro " + i).build());
            }
        }
    }

    public void testJDBC() {
        inspectorJdbc.inspectores().forEach(item -> {
            Inspector inspector = inspectorService
                    .registrar(Inspector.builder().identity(item.getIndex()).tipo("TRABAJO")
                            .nombreInspector(item.getNombreInspector()).estado(true).build());
            System.out.println(inspector);
        });
    }
}
