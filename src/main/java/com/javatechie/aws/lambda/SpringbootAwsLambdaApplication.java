package com.javatechie.aws.lambda;

import static com.javatechie.aws.lambda.util.Utils.generateCorreo;
import static com.javatechie.aws.lambda.util.Utils.numberRandomGenerator;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.aws.lambda.domain.Articulo;
import com.javatechie.aws.lambda.domain.EstadoCaso;
import com.javatechie.aws.lambda.domain.Etapa;
import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.Origen;
import com.javatechie.aws.lambda.domain.TipoActuacion;
import com.javatechie.aws.lambda.domain.TipoTarea;
import com.javatechie.aws.lambda.respository.jdbc.InspectorJdbc;
import com.javatechie.aws.lambda.service.ArticuloService;
import com.javatechie.aws.lambda.service.EstadoCasoService;
import com.javatechie.aws.lambda.service.EtapaService;
import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.InspectorService;
//import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.MateriaService;
import com.javatechie.aws.lambda.service.OrigenService;
import com.javatechie.aws.lambda.service.PuntuacionService;
import com.javatechie.aws.lambda.service.TipoActuacionService;
import com.javatechie.aws.lambda.service.TipoTareaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
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

    @Autowired
    PuntuacionService puntuacionService;

    @Autowired
    OrigenService origenService;

    @Autowired
    InfraccionService infraccionService;

    @Autowired
    EstadoCasoService estadoCasoService;

    @Autowired
    TipoTareaService tipoTareaService;

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        cargarMaterias();
        cargarEtapas();
        cargatTipoActuacion();
        registrarArticulos();
        origenTest();
        cargarEstadoCaso();
        llenarTipoTarea();
        // updateInfraccion();
        // testStoredProcedure();
        // updateInspector();
        // testJDBC();
        // updateInfraccion();
        // puntuacionTest();
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

    public void updateInfraccion() {
        infraccionService.listar().forEach(item -> {
            Infraccion infraccion = item;
            if (infraccion.getGravedad() != null) {
                switch (infraccion.getGravedad()) {
                case "LEVE":
                    infraccion.setPuntajeGravedad(1);
                    break;
                case "GRAVE":
                    infraccion.setPuntajeGravedad(2);
                    break;
                case "MUY GRAVE":
                    infraccion.setPuntajeGravedad(3);
                    break;
                default:
                    infraccion.setPuntajeGravedad(0);
                    break;
                }
                infraccionService.modificar(infraccion);
            }
        });
    }

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

    @Transactional
    public void updateInspector() {
        inspectorService.listar().forEach(item -> {
            item.setCargo("Cargo Prueba");
            item.setCorreo(generateCorreo(item.getNombreInspector()));
            item.setTelefono(String.valueOf(numberRandomGenerator(900000000, 999999999)));
            Inspector inspector = inspectorService.modificar(item);
            System.out.println(inspector);
        });
    }

    public void testStoredProcedure() {
        inspectorService.storedProcedure("Poma Canazas Daniel Andres").forEach(item -> {
            log.info("item : " + item);
        });
    }

    public void origenTest() {
        if (origenService.listar().isEmpty()) {
            Arrays.asList(Origen.builder().nombreOrigen("Denuncia").estado(true).build(),
                    Origen.builder().nombreOrigen("Desconocido").estado(true).build(),
                    Origen.builder().nombreOrigen("Operativo SUNAFIL").estado(true).build())
                    .forEach(item -> {
                        log.info("Origen registrado : " + origenService.registrar(item));
                    });
        }
    }

    public void cargarEstadoCaso() {
        List<EstadoCaso> lista = estadoCasoService.listar();
        if (lista.isEmpty()) {
            List<EstadoCaso> estados = Arrays.asList(EstadoCaso.builder().orden(1).nombreEstado(
                    "Pendiente decisión de inspector sobre emisión o no de Medida de Requerimiento")
                    .estado(true).build(),
                    EstadoCaso.builder().orden(2).nombreEstado(
                            "Pendiente decisión de inspector sobre emisión de Informe de Actuaciones Inspectivas o Acta de Infracción")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(3)
                            .nombreEstado("Caso concluido con Informe de Actuaciones Inspectivas")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(4).nombreEstado("Pendiente decisión de instructor")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(5)
                            .nombreEstado(
                                    "Caso concluido con Informe de Instrucción de Archivamiento")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(6)
                            .nombreEstado("Pendiente decisión de primera instancia").estado(true)
                            .build(),
                    EstadoCaso.builder().orden(7)
                            .nombreEstado("Pendiente decisión de segunda instancia").estado(true)
                            .build(),
                    EstadoCaso.builder().orden(8)
                            .nombreEstado("Pendiente decisión de Tribunal de Fiscalización Laboral")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(9)
                            .nombreEstado("Caso con resolución consentida y en etapa de cobranza")
                            .estado(true).build(),
                    EstadoCaso.builder().orden(10).nombreEstado("Caso concluido").estado(true)
                            .build());
            estados.forEach(item -> {
                estadoCasoService.registrar(item);
            });
        }
    }

    public void llenarTipoTarea() {
        List<TipoTarea> lista = tipoTareaService.listar();
        if (lista.isEmpty()) {
            List<TipoTarea> newList = Arrays.asList(
                    TipoTarea.builder().nombreTipo("Solicitud").estado(true).build(),
                    TipoTarea.builder().nombreTipo("Actividad").estado(true).build());
            newList.forEach(item -> {
                tipoTareaService.registrar(item);
            });
        }
    }
}
