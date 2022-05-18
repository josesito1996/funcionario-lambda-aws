package com.javatechie.aws.lambda;

import static com.javatechie.aws.lambda.util.Utils.primeraLetraMayuscula;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.aws.lambda.domain.Articulo;
import com.javatechie.aws.lambda.domain.Comentario;
import com.javatechie.aws.lambda.domain.EstadoCaso;
import com.javatechie.aws.lambda.domain.Etapa;
import com.javatechie.aws.lambda.domain.Infraccion;
import com.javatechie.aws.lambda.domain.Insight;
import com.javatechie.aws.lambda.domain.Inspector;
import com.javatechie.aws.lambda.domain.Materia;
import com.javatechie.aws.lambda.domain.Origen;
import com.javatechie.aws.lambda.domain.SubMateria;
import com.javatechie.aws.lambda.domain.TipoActuacion;
import com.javatechie.aws.lambda.domain.TipoTarea;
import com.javatechie.aws.lambda.domain.documents.Costo;
import com.javatechie.aws.lambda.domain.documents.PlanPrecio;
import com.javatechie.aws.lambda.respository.jdbc.ControlTotalJdbc;
import com.javatechie.aws.lambda.respository.jdbc.InspectorJdbc;
import com.javatechie.aws.lambda.service.ArticuloService;
import com.javatechie.aws.lambda.service.ComentarioService;
import com.javatechie.aws.lambda.service.EstadoCasoService;
import com.javatechie.aws.lambda.service.EtapaService;
import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.InsightService;
import com.javatechie.aws.lambda.service.InspectorService;
import com.javatechie.aws.lambda.service.IntendenciaService;
import com.javatechie.aws.lambda.service.JurisprudenciaService;
//import com.javatechie.aws.lambda.service.InfraccionService;
import com.javatechie.aws.lambda.service.MateriaService;
import com.javatechie.aws.lambda.service.OrigenService;
import com.javatechie.aws.lambda.service.PuntuacionService;
import com.javatechie.aws.lambda.service.SubMateriaService;
import com.javatechie.aws.lambda.service.TipoActuacionService;
import com.javatechie.aws.lambda.service.TipoTareaService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@SpringBootApplication
public class SpringbootAwsLambdaApplication implements CommandLineRunner {

	@Autowired
	JurisprudenciaService jdbc;

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

	@Autowired
	InsightService insightService;

	@Autowired
	SubMateriaService subMateriaService;

	@Autowired
	IntendenciaService intendenciaService;

	@Autowired
	ComentarioService comentarioService;

	@Autowired
	ControlTotalJdbc jdbcControl;

	public static void main(String[] args) {
		SpringApplication.run(SpringbootAwsLambdaApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// buildComentario();
		// log.info(jdbcControl.controlTotalesQuery() + "");
		// cargarMaterias();
		// cargarEtapas();
		// cargatTipoActuacion();
		// registrarArticulos();
		// origenTest();
		// cargarEstadoCaso();
		// llenarTipoTarea();
		// llenarInsight();
		// updateSubMaterias();
		// updateInfraccion();
		// testStoredProcedure();
		// updateInspector();
		// testJDBC();
		// updateInfraccion();
		// puntuacionTest();
		// log.info(jdbc.resolucionesRecientesAgregadasQuery(7).toString());
		// intendenciaRegister();
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
					Etapa.builder().nombreEtapa("Instruccion").estado(true).build()).forEach(etapa -> {
						etapaService.registrar(etapa);
					});
		}
	}

	public void cargatTipoActuacion() {
		if (tipoActuacionService.listar().isEmpty()) {
			Arrays.asList(TipoActuacion.builder().nombreTipoActuacion("Acta de Infracción").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Escrito").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Comparecencia").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Requerimiento de comparecencia").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Apelacion").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Descargos").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Vista inspectiva").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Requerimiento").estado(true).build(),
					TipoActuacion.builder().nombreTipoActuacion("Resolucion").estado(true).build()).forEach(tipo -> {
						tipoActuacionService.registrar(tipo);
					});
		}
	}

	public void updateInfraccion() {
		Arrays.asList(new Infraccion("ac1ef67a-550e-4a4e-96aa-6087f9839b08", null, "46.60", null, null, null, null,
				null, null, null)).forEach(infraccion -> {
					Infraccion infra = infraccionService.verPorIdInfraccion(infraccion.getIdInfraccion());
					infra.setBaseLegal(infraccion.getBaseLegal());
					log.info("Infra {}", infraccionService.modificar(infra));
				});
		;
	}

	public void registrarArticulos() {
		List<Articulo> articulos = articuloService.listar();
		if (articulos.isEmpty()) {
			/*
			 * for (int i = 23; i <= 46; i++) { articuloService.registrar(
			 * Articulo.builder().nroArticulo(String.valueOf(i)).
			 * nombreArticulo("Articulo nro " + i).build()); }
			 */
		} else {
			articulos.forEach(articulo -> {
				articulo.setNombreArticulo("Articulo " + articulo.getNroArticulo());
				articuloService.modificar(articulo);
			});
		}
	}

	public void testJDBC() {
		inspectorJdbc.inspectores().forEach(item -> {
			Inspector inspector = inspectorService.buscarPorNombre(item.getNombreInspector());
			if (inspector != null) {
				/** 
				Inspector nuevoInspector = inspectorService.registrar(Inspector.builder().tipo("TRABAJO")
						.telefono(String.valueOf(numberRandomGenerator(900000000, 999999999)))
						.correo(generateCorreo(item.getNombreInspector())).nombreInspector(item.getNombreInspector())
						.identity(item.getIndex()).build());
			    **/
				inspector.setCorreo("");
				inspector.setTelefono("");
				Inspector updateInspector = inspectorService.modificar(inspector);
				log.info("Nuevo Inspector {}", updateInspector);
			}
		});
	}

	@Transactional
	public void updateInspector() {
		Arrays.asList(
				new Inspector(null, null, "Carlos Gil Vela Gonzáles", "TRABAJO", "Resolutor", "correo@gmail,com",
						"978469955", "Sancionador", true),
				new Inspector(null, null, "Carlos Lizandro Zamata Torres", "TRABAJO", "Resolutor", "correo@gmail,com",
						"935300024", "Sancionador", true),
				new Inspector(null, null, "Carolina Lucy Valer Ramos", "TRABAJO", "Resolutor", "correo@gmail,com",
						"939549055", "Sancionador", true),
				new Inspector(null, null, "David Josué Condori Catunta", "TRABAJO", "Resolutor", "correo@gmail,com",
						"939199936", "Sancionador", true),
				new Inspector(null, null, "Eduardo Fernando Espinoza Acosta", "TRABAJO", "Resolutor",
						"correo@gmail,com", "953427501", "Sancionador", true),
				new Inspector(null, null, "Edward Venero Ramos", "TRABAJO", "Resolutor", "correo@gmail,com",
						"912394160", "Sancionador", true),
				new Inspector(null, null, "Ena Armida Espinoza Cañoli", "TRABAJO", "Resolutor", "correo@gmail,com",
						"937207678", "Sancionador", true),
				new Inspector(null, null, "Fernando Llantoy Baños", "TRABAJO", "Resolutor", "correo@gmail,com",
						"917253525", "Sancionador", true),
				new Inspector(null, null, "Flor Marina Cruz Rodríguez", "TRABAJO", "Resolutor", "correo@gmail,com",
						"974924710", "Sancionador", true),
				new Inspector(null, null, "Flor Milagritos Reategui Velez", "TRABAJO", "Resolutor", "correo@gmail,com",
						"915636592", "Sancionador", true),
				new Inspector(null, null, "Freddy Jose Maria Solano Gonzales", "TRABAJO", "Resolutor",
						"correo@gmail,com", "950885497", "Sancionador", true),
				new Inspector(null, null, "Fredy Augusto Morales Flores", "TRABAJO", "Resolutor", "correo@gmail,com",
						"993475867", "Sancionador", true),
				new Inspector(null, null, "Gina Isabel Hidalgo Casanova", "TRABAJO", "Resolutor", "correo@gmail,com",
						"971110589", "Sancionador", true),
				new Inspector(null, null, "Hipólito Carlos Javier Brañez", "TRABAJO", "Resolutor", "correo@gmail,com",
						"907770134", "Sancionador", true),
				new Inspector(null, null, "Jorge Eduardo Maguiña Aliaga", "TRABAJO", "Resolutor", "correo@gmail,com",
						"939806052", "Sancionador", true),
				new Inspector(null, null, "Jorge Eduardo Olaya Ramos", "TRABAJO", "Resolutor", "correo@gmail,com",
						"971567340", "Sancionador", true),
				new Inspector(null, null, "José Luis Zolezzi Ibárcena", "TRABAJO", "Resolutor", "correo@gmail,com",
						"971674840", "Sancionador", true),
				new Inspector(null, null, "Juan Carlos Vásquez Baneo", "TRABAJO", "Resolutor", "correo@gmail,com",
						"974709581", "Sancionador", true),
				new Inspector(null, null, "Julio Alfonso Hoyos Estela", "TRABAJO", "Resolutor", "correo@gmail,com",
						"932625793", "Sancionador", true),
				new Inspector(null, null, "Julio César Matheus López", "TRABAJO", "Resolutor", "correo@gmail,com",
						"902056167", "Sancionador", true),
				new Inspector(null, null, "Luis Alberto Morán Canales", "TRABAJO", "Resolutor", "correo@gmail,com",
						"981055125", "Sancionador", true),
				new Inspector(null, null, "Luis Jorge Pitta Pereyra", "TRABAJO", "Resolutor", "correo@gmail,com",
						"996829981", "Sancionador", true),
				new Inspector(null, null, "Maria del Carmen Solorzano Mercado", "TRABAJO", "Resolutor",
						"correo@gmail,com", "993507413", "Sancionador", true),
				new Inspector(null, null, "Maria Eliana Villa Zambrano", "TRABAJO", "Resolutor", "correo@gmail,com",
						"981769242", "Sancionador", true),
				new Inspector(null, null, "Maylin Jassira Wong Uribe", "TRABAJO", "Resolutor", "correo@gmail,com",
						"950026258", "Sancionador", true),
				new Inspector(null, null, "Miguel Angel Castro Zavala", "TRABAJO", "Resolutor", "correo@gmail,com",
						"957587997", "Sancionador", true),
				new Inspector(null, null, "Omara Susana Ramírez Niño", "TRABAJO", "Resolutor", "correo@gmail,com",
						"974716736", "Sancionador", true),
				new Inspector(null, null, "Orlando Francisco Añazco Núnjar", "TRABAJO", "Resolutor", "correo@gmail,com",
						"955712094", "Sancionador", true),
				new Inspector(null, null, "Oscar Humberto Moreno Rubiños", "TRABAJO", "Resolutor", "correo@gmail,com",
						"927690318", "Sancionador", true),
				new Inspector(null, null, "Pedro Enrique Prado Prado", "TRABAJO", "Resolutor", "correo@gmail,com",
						"939265781", "Sancionador", true),
				new Inspector(null, null, "Sally Veronica Tamayo Olivas", "TRABAJO", "Resolutor", "correo@gmail,com",
						"946782906", "Sancionador", true),
				new Inspector(null, null, "Tatiana Julissa Guerrero Cuevas", "TRABAJO", "Resolutor", "correo@gmail,com",
						"989567877", "Sancionador", true),
				new Inspector(null, null, "Vanessa Victoria Vargas Chafloque", "TRABAJO", "Resolutor",
						"correo@gmail,com", "992918254", "Sancionador", true))
				.forEach(item -> {
					log.info("Nuevo Inspector {}", inspectorService.registrar(item));
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
					Origen.builder().nombreOrigen("Operativo SUNAFIL").estado(true).build()).forEach(item -> {
						log.info("Origen registrado : " + origenService.registrar(item));
					});
		}
	}

	public void cargarEstadoCaso() {
		List<EstadoCaso> lista = estadoCasoService.listar();
		if (lista.isEmpty()) {
			List<EstadoCaso> estados = Arrays.asList(
					EstadoCaso.builder().orden(1)
							.nombreEstado(
									"Pendiente decisión de inspector sobre emisión o no de Medida de Requerimiento")
							.estado(true).build(),
					EstadoCaso.builder().orden(2).nombreEstado(
							"Pendiente decisión de inspector sobre emisión de Informe de Actuaciones Inspectivas o Acta de Infracción")
							.estado(true).build(),
					EstadoCaso.builder().orden(3).nombreEstado("Caso concluido con Informe de Actuaciones Inspectivas")
							.estado(true).build(),
					EstadoCaso.builder().orden(4).nombreEstado("Pendiente decisión de instructor").estado(true).build(),
					EstadoCaso.builder().orden(5)
							.nombreEstado("Caso concluido con Informe de Instrucción de Archivamiento").estado(true)
							.build(),
					EstadoCaso.builder().orden(6).nombreEstado("Pendiente decisión de primera instancia").estado(true)
							.build(),
					EstadoCaso.builder().orden(7).nombreEstado("Pendiente decisión de segunda instancia").estado(true)
							.build(),
					EstadoCaso.builder().orden(8)
							.nombreEstado("Pendiente decisión de Tribunal de Fiscalización Laboral").estado(true)
							.build(),
					EstadoCaso.builder().orden(9).nombreEstado("Caso con resolución consentida y en etapa de cobranza")
							.estado(true).build(),
					EstadoCaso.builder().orden(10).nombreEstado("Caso concluido").estado(true).build());
			estados.forEach(item -> {
				estadoCasoService.registrar(item);
			});
		}
	}

	public void llenarTipoTarea() {
		List<TipoTarea> lista = tipoTareaService.listar();
		if (lista.isEmpty()) {
			List<TipoTarea> newList = Arrays.asList(TipoTarea.builder().nombreTipo("Solicitud").estado(true).build(),
					TipoTarea.builder().nombreTipo("Actividad").estado(true).build());
			newList.forEach(item -> {
				tipoTareaService.registrar(item);
			});
		}
	}

	public void llenarInsight() {
		List<Insight> lista = insightService.listar();
		if (lista.isEmpty()) {
			List<Insight> newLista = Arrays.asList(Insight.builder().estado(true)
					.nombreCaracteristica("Alerta nueva inspeccion").labelModal("Alerta nueva inspeccion")
					.mensaje("Que la proxima inspeccion no te gane con SAMY")
					.caracteristicas(Arrays.asList("Conoce la <strong>fecha</strong> y detalle de la nueva inspeccion",
							"Anticipate y estate listo para la llegada de la inspeccion",
							"Creo tu caso y prepara toda la documentacion necesaria"))
					.costo(Costo.builder().tiempo("mensual").precio(9.90).moneda("DOLAR").build())
					.planesPrecio(new ArrayList<PlanPrecio>()).build(),
					Insight.builder().estado(true).nombreCaracteristica("Sincroniza tu casilla")
							.labelModal(
									"Vincula SUNAFIL & SAMI y sincroniza tu casilla electronica con total seguridad")
							.mensaje(
									"Recibe las notificaciones de tu casilla electrónica SUNAFIL sin tener que ingresar constantemente a tu buzón, solo enlaza a SUNAFIL con Sami y ¡Listo!. \r\n"
											+ "Notificaciones más rápidas y seguras.")
							.caracteristicas(Arrays.asList("Tus datos privados estaran completamente seguros en SAMY",
									"Contamos con un protocolo de confidencialidad de datos"))
							.costo(Costo.builder().tiempo("mensual").precio(9.90).moneda("DOLAR").build())
							.planesPrecio(new ArrayList<PlanPrecio>()).build(),
					Insight.builder().estado(true).nombreCaracteristica("Servicio Paralegal")
							.labelModal("Sami Paralegal : Tu asistente legal en linea")
							.mensaje(
									"Nos encargamos del trabajo operativo con Sami Paralegal para que tú te enfoques en la gestión y estrategia de tu cartera de casos.")
							.caracteristicas(new ArrayList<String>()).costo(Costo.builder().build())
							.planesPrecio(Arrays.asList(
									PlanPrecio.builder().tipoPlan("Basico").costo(15152.361).moneda("Dolar")
											.detalles(Arrays.asList("Detalle 1", "Detalle2", "Detalle3")).build(),
									PlanPrecio.builder().tipoPlan("Regular").costo(199.361).moneda("Dolar")
											.detalles(Arrays.asList("Detalle 1", "Detalle2", "Detalle3")).build(),
									PlanPrecio.builder().tipoPlan("Premium").costo(9999.361).moneda("Dolar")
											.detalles(Arrays.asList("Detalle 1", "Detalle2", "Detalle3")).build()))
							.build());
			newLista.forEach(item -> {
				insightService.registrar(item);
			});
		}
	}

	public void updateSubMaterias() {
		List<SubMateria> subMaterias = subMateriaService.listar();
		if (subMaterias.isEmpty()) {
			// Registrar
		} else {
			// actualizar
			subMaterias.forEach(item -> {
				item.setNombreSubMateria(primeraLetraMayuscula(item.getNombreSubMateria()));
				log.info("SubMateria : {}", subMateriaService.modificar(item));
			});
		}
	}

	public void intendenciaRegister() {
		intendenciaService.listar().forEach(item -> {
			item.setNoMostrar(false);
			intendenciaService.modificar(item);
		});
		/*
		 * Arrays.asList(new Intendencia(null, "Amazonas", "Segunda",
		 * "Intendencia Regional de Amazonas", true), new Intendencia(null, "Ancash",
		 * "Segunda", "Intendencia Regional de Ancash", true), new Intendencia(null,
		 * "Ancash", "", "Zona de Trabajo de Ancash (Chimbote)", true), new
		 * Intendencia(null, "Apurímac", "Segunda", "Intendencia Regional de Apurímac",
		 * true), new Intendencia(null, "Arequipa", "Segunda",
		 * "Intendencia Regional de Arequipa", true), new Intendencia(null, "Ayacucho",
		 * "Segunda", "Intendencia Regional de Ayacucho", true), new Intendencia(null,
		 * "Cajamarca", "Segunda", "Intendencia Regional de Cajamarca", true), new
		 * Intendencia(null, "Cajamarca", "Primera", "Sub Intendencia de Resolución",
		 * true), new Intendencia(null, "Callao", "Segunda",
		 * "Intendencia Regional de Callao", true), new Intendencia(null, "Cusco",
		 * "Segunda", "Intendencia Regional de Cusco", true), new Intendencia(null,
		 * "Huancavelica", "Segunda", "Intendencia Regional de Huancavelica", true), new
		 * Intendencia(null, "Huanuco", "Segunda", "Intendencia Regional de Huanuco",
		 * true), new Intendencia(null, "Ica", "Segunda", "Intendencia Regional de Ica",
		 * true), new Intendencia(null, "Junín", "Primera",
		 * "Sub Intendencia de Resolución", true), new Intendencia(null, "Junín",
		 * "Segunda", "Intendencia Regional de Junín", true), new Intendencia(null,
		 * "La Libertad", "Segunda", "Intendencia Regional de La Libertad", true), new
		 * Intendencia(null, "Lambayeque", "Segunda",
		 * "Intendencia Regional de Lambayeque", true), new Intendencia(null, "Lima",
		 * "Primera", "Sub Intendencia de Resolución 5", true), new Intendencia(null,
		 * "Lima", "Segunda", "Intendencia Regional de Lima", true), new
		 * Intendencia(null, "Lima", "Primera", "Sub Intendencia de Resolución 4",
		 * true), new Intendencia(null, "Lima", "Primera",
		 * "Sub Intendencia de Resolución 3", true), new Intendencia(null, "Lima",
		 * "Primera", "Sub Intendencia de Resolución 2", true), new Intendencia(null,
		 * "Lima", "Primera", "Sub Intendencia de Resolución 1", true), new
		 * Intendencia(null, "Lima Metropolitana", "Segunda",
		 * "Intendencia Regional de Lima Metropolitana", true), new Intendencia(null,
		 * "Loreto", "Segunda", "Intendencia Regional de Loreto", true), new
		 * Intendencia(null, "Madre de Dios", "Segunda",
		 * "Intendencia Regional de Madre de Dios", true), new Intendencia(null,
		 * "Moquegua", "Segunda", "Intendencia Regional de Moquegua", true), new
		 * Intendencia(null, "Pasco", "Segunda", "Intendencia Regional de Pasco", true),
		 * new Intendencia(null, "Piura", "Segunda", "Intendencia Regional de Piura",
		 * true), new Intendencia(null, "Puno", "Segunda",
		 * "Intendencia Regional de Puno", true), new Intendencia(null, "San Martín",
		 * "Segunda", "Intendencia Regional de San Martín", true), new Intendencia(null,
		 * "Tacna", "Segunda", "Intendencia Regional de Tacna", true), new
		 * Intendencia(null, "Tumbes", "Segunda", "Intendencia Regional de Tumbes",
		 * true), new Intendencia(null, "Ucayali", "Segunda",
		 * "Intendencia Regional de Ucayali", true)).forEach(item ->{
		 * log.info("Intendencia {}", intendenciaService.registrar(item)); });
		 */
	}

	public void buildComentario() {
		List<Comentario> comentarios = comentarioService.listar();
		if (comentarios.isEmpty()) {
			Arrays.asList(Comentario.builder().usuario("campos@gmail.com").fechaRegistro(LocalDateTime.now())
					.identificador("5de7eef3-1def-4459-b4dd-2551c90febf8")
					.comentario("Este es un comentario para este inspector u.u").puntuacion(3).activo(true).build(),
					Comentario.builder().usuario("shfiestas@gmail.com").fechaRegistro(LocalDateTime.now())
							.identificador("5de7eef3-1def-4459-b4dd-2551c90febf8")
							.comentario("Este es un comentario para este inspector x2").puntuacion(4).activo(true)
							.build(),
					Comentario.builder().usuario("shfiestas@gmail.com").fechaRegistro(LocalDateTime.now())
							.identificador("5de7eef3-1def-4459-b4dd-2551c90febf8")
							.comentario("Este es un comentario para este inspector x3").puntuacion(5).activo(true)
							.build(),
					Comentario.builder().usuario("campos@gmail.com").fechaRegistro(LocalDateTime.now())
							.identificador("5de7eef3-1def-4459-b4dd-2551c90febf8")
							.comentario("Este es un comentario para este inspector x4").puntuacion(3).activo(true)
							.build(),
					Comentario.builder().usuario("shfiestas@gmail.com").fechaRegistro(LocalDateTime.now())
							.identificador("5de7eef3-1def-4459-b4dd-2551c90febf8")
							.comentario("Este es un comentario para este inspector u.u").puntuacion(3).activo(true)
							.build())
					.forEach(item -> {
						log.info("Nuevo Comentario {}", comentarioService.registrar(item));
					});
		}
	}
}
