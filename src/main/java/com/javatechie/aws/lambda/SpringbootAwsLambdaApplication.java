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
		// log.info("JSON {}", new Gson().toJson(infraccionService.listar()));
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
		// updateSubMaterias();
		// registrarInfracciones();
	}

	public void registrarInfracciones() {
		Arrays.asList(Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.2")
				.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").idSubMateria("09a6a1b4-8fe6-46b2-99ca-fed13a6c8497")
				.subMateria("HORARIO DE TRABAJO")
				.descripcion(
						"El incumplimiento de las disposiciones referidas al horario, jornada y tiempo de trabajo aplicable a las modalidades formativas.")
				.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.3")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("7c57cdde-38fa-4d02-9aae-746b09beb8d4")
						.subMateria("LIMITES DE CONTRATACION MODALIDAD FORMATIVA")
						.descripcion("Exceder los límites de contratación bajo modalidades formativas.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.3")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("7c57cdde-38fa-4d02-9aae-746b09beb8d4")
						.subMateria("LIMITES DE CONTRATACION MODALIDAD FORMATIVA")
						.descripcion("Exceder los límites de contratación bajo modalidades formativas.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.2")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("4a68b4f5-44f7-4404-ad18-e574070b5a7d").subMateria("JORNADA DE TRABAJO")
						.descripcion(
								"El incumplimiento de las disposiciones referidas al horario, jornada y tiempo de trabajo aplicable a las modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.7")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("7a16fd12-8a03-4dff-afb1-237beb97c447").subMateria("FRAUDE")
						.descripcion("El uso fraudulento de las modalidades formativas.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.1")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("566abb1b-2920-4566-a0d4-3accaf5fbdf3").subMateria("SUBVENCION")
						.descripcion(
								"La falta de pago y disfrute, el pago o disfrute parcial o inoportuno, o el pago o disfrute inferior a los mínimos previstos, de la subvención y los beneficios a los que tienen derecho los beneficiarios de las modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.4")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("cc9e987e-30c2-4aac-aca6-6c258ec759a4").subMateria("SEGURO DE SALUD")
						.descripcion(
								"No asumir directamente el costo de las contingencias originadas por un accidente o enfermedad cuando la empresa que no haya cubierto los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.3")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("cc9e987e-30c2-4aac-aca6-6c258ec759a4").subMateria("SEGURO DE SALUD")
						.descripcion(
								"No cubrir los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.5")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("bbb7299b-5f16-44a8-bd0c-c79107346bec").subMateria("LIMITES DE CONTRATACION")
						.descripcion(
								"La presentación de documentación falsa ante la autoridad competente para acogerse al incremento porcentual de los límites de contratación bajo modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("12d42b08-62b9-4282-b6da-077d1d0f0fb0").baseLegal("38")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("c15e1e7e-64d4-4a74-9f2b-926cd1112026").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"Los incumplimientos que afecten a obligaciones meramente formales o documentales, siempre que no estén tipificados como infracciones graves.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.1")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("9e971235-5340-45fd-b0c8-deef3a10094a").subMateria("REGISTRO")
						.descripcion(
								"Carecer de los registros especiales de modalidades formativas debidamente autorizados por la autoridad competente de ser exigido, o no registrar a los beneficiarios de las modalidades formativas en los mismos o en el registro de trabajadores y prestadores de servicios, en los plazos y con los requisitos previstos, incurriéndose en una infracción por cada beneficiario afectado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.2")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("aedb8f33-eb87-4e3e-8f36-f065d71bf1f8").subMateria("TIEMPO DE TRABAJO")
						.descripcion(
								"El incumplimiento de las disposiciones referidas al horario, jornada y tiempo de trabajo aplicable a las modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.3")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("db287b38-f4a1-46d1-ba33-6370fcbf3a07").subMateria("ACCIDENTE DE TRABAJO")
						.descripcion(
								"No cubrir los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.4")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("db287b38-f4a1-46d1-ba33-6370fcbf3a07").subMateria("ACCIDENTE DE TRABAJO")
						.descripcion(
								"No asumir directamente el costo de las contingencias originadas por un accidente o enfermedad cuando la empresa que no haya cubierto los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.3")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("7f7bb1c4-38e0-462d-a63b-c139920f18da").subMateria("ENFERMEDAD PROFESIONAL")
						.descripcion(
								"No cubrir los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.4")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("7f7bb1c4-38e0-462d-a63b-c139920f18da").subMateria("ENFERMEDAD PROFESIONAL")
						.descripcion(
								"No asumir directamente el costo de las contingencias originadas por un accidente o enfermedad cuando la empresa que no haya cubierto los riesgos de enfermedad y accidentes de trabajo a través de EsSalud o de un seguro privado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.7")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion("El uso fraudulento de las modalidades formativas.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.8")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No celebrar los convenios de modalidades formativas por escrito y con los requisitos previstos")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.2")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No celebrar los convenios de modalidades formativas por escrito o no presentarlos ante la Autoridad competente, en los plazos y con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.6")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No emitir, cuando corresponda, los informes que requiera el Centro de Formación Profesional.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.7")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No otorgar el respectivo certificado de manera oportuna y con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.1")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"Carecer de los registros especiales de modalidades formativas debidamente autorizados por la autoridad competente de ser exigido, o no registrar a los beneficiarios de las modalidades formativas en los mismos o en el registro de trabajadores y prestadores de servicios, en los plazos y con los requisitos previstos, incurriéndose en una infracción por cada beneficiario afectado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.1")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"La falta de pago y disfrute, el pago o disfrute parcial o inoportuno, o el pago o disfrute inferior a los mínimos previstos, de la subvención y los beneficios a los que tienen derecho los beneficiarios de las modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.5")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No brindar facilidades para que el beneficiario de las modalidades formativas se afilie a un sistema pensionario.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.6")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No contar con el plan o programa correspondiente a la modalidad formativa bajo la cual se contrata a los beneficiarios.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.4")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion("No cumplir con las obligaciones en materia de formación.").gravedad("GRAVE")
						.puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.2")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"El incumplimiento de las disposiciones referidas al horario, jornada y tiempo de trabajo aplicable a las modalidades formativas.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f4d39942-1bed-403a-98a6-f7b2207a4a0b").baseLegal("40.9")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"El uso de castigo físico y humillante contra las personas que se encuentran sujetas a alguna modalidad formativa laboral, de conformidad con la Ley Nº 30403, Ley que prohíbe el uso del castigo físico y humillante contra los niños, niñas y adolescentes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.8")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("325e71e4-da16-4070-bbdf-b20f6ebe86c2").subMateria("MODALIDAD FORMATIVA")
						.descripcion(
								"No presentar a la Autoridad competente el plan o programa correspondiente a la modalidad formativa bajo la cual se contrata a los beneficiarios, en los plazos y con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("57061fbe-d077-4c8e-ac17-be5d0c9cb65c").baseLegal("39.2")
						.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
						.idSubMateria("f94a2225-03f0-445f-915b-822d55155e39").subMateria("CONVENIO")
						.descripcion(
								"No celebrar los convenios de modalidades formativas por escrito o no presentarlos ante la Autoridad competente, en los plazos y con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("fb1be1f5-4bfa-420c-98ae-f59a6ba1814f").subMateria("EVALUACION MEDICA")
						.descripcion(
								"No realizar los reconocimientos médicos y pruebas de vigilancia periódica del estado de salud de los trabajadores o no comunicar a los trabajadores afectados el resultado de las mismas.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("61038753-7c25-4662-8c42-880b3b4955f7").subMateria("VIGILANCIA DE LA SALUD")
						.descripcion(
								"No cumplir con realizar los exámenes médicos ocupacionales y/o no cumplir con realizar la vigilancia de la salud de sus trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.16")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("d639ad56-9797-4b46-9107-9742b2c4f02b").subMateria("INTERMEDIACIÓN LABORAL")
						.descripcion(
								"No verificar el cumplimiento de la normativa legal vigente en materia de seguridad y salud en el trabajo por parte de sus contratistas, subcontratistas, empresas especiales de servicios o cooperativas de trabajadores que desarrollen obras o servicios en el centro de trabajo o con ocasión del trabajo realizado por encargo de la principal.")
						.gravedad("").puntajeGravedad(null).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.8")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"No cumplir con las obligaciones en materia de formación e información suficiente y adecuada a los trabajadores y las trabajadoras acerca de los riesgos del puesto de trabajo y sobre las medidas preventivas aplicables.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"La vulneración de los derechos de información, consulta y participación de los trabajadores reconocidos en la normativa sobre prevención de riesgos laborales.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"El incumplimiento de la obligación de planificar la acción preventiva de riesgos para la seguridad y salud en el trabajo, así como el incumplimiento de la obligación de elaborar un plan o programa de seguridad y salud en el trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"No adoptar las medidas preventivas aplicables a las condiciones de trabajo de las que se derive un riesgo grave e inminente para la seguridad y salud de los trabajadores y personas que prestan servicios dentro del ámbito del centro de labores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.2")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"No dar cuenta a la autoridad competente, conforme a lo establecido en las normas de seguridad y salud en el trabajo, de los accidentes de trabajo mortales o de los incidentes peligrosos ocurridos, no comunicar los demás accidentes de trabajo al Centro Médico Asistencial donde el trabajador accidentado es atendido, o no llevar a cabo la investigación en caso de producirse daños a la salud de los trabajadores o de tenerse indicios que las medidas preventivas son insuficientes.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("383e5ea8-18aa-49c9-8e57-d1b56da6d408").subMateria("MEDIDAS PREVENTIVAS")
						.descripcion(
								"No llevar a cabo las evaluaciones de riesgos y los controles periódicos de las condiciones de trabajo y de las actividades de los trabajadores o no realizar aquellas actividades de prevención que sean necesarias según los resultados de las evaluaciones.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("bd36482b-4107-43e0-be1e-36258bbf3bc7")
						.subMateria("AGENTES FISICOS, QUIMICOS Y BIOLOGICOS")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la seguridad y salud en el trabajo, en particular en materia de lugares de trabajo, herramientas, máquinas y equipos, agentes físicos, químicos y biológicos, riesgos ergonómicos y psicosociales, medidas de protección colectiva, equipos de protección personal, señalización de seguridad, etiquetado y envasado de sustancias peligrosas, almacenamiento, servicios o medidas de higiene personal, de los que se derive un riesgo grave para la seguridad o salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("0c39f5a1-d6bd-4517-be41-d0990e4376a5").subMateria("INCENDIOS")
						.descripcion(
								"No adoptar las medidas necesarias en materia de primeros auxilios, lucha contra incendios y evacuación de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.16")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("7cded408-5dc4-40bb-89cb-fc17bf8bc3b0").subMateria("SST CONTRATISTAS")
						.descripcion(
								"No verificar el cumplimiento de la normativa legal vigente en materia de seguridad y salud en el trabajo por parte de sus contratistas, subcontratistas, empresas especiales de servicios o cooperativas de trabajadores que desarrollen obras o servicios en el centro de trabajo o con ocasión del trabajo realizado por encargo de la principal.")
						.gravedad("").puntajeGravedad(null).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("de73eb4a-5d56-4f6a-9e0b-ab5b6b1127a2").subMateria("LACTANCIA")
						.descripcion(
								"No observar las normas específicas en materia de protección de la seguridad y salud de las trabajadoras durante los periodos de embarazo y lactancia y de los trabajadores con discapacidad.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("b3fab43d-6fe8-497a-8169-29454a0dcfb1").baseLegal("26.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("23f84808-37c5-4903-b482-375dd292b169").subMateria("DEBER DE COMUNICACIÓN")
						.descripcion(
								"No comunicar a la autoridad competente la apertura del centro de trabajo o la reanudación o continuación de los trabajos después de efectuar alteraciones o ampliaciones de importancia, o consignar con inexactitud los datos que debe declarar o complementar, siempre que no se trate de una industria calificada de alto riesgo por ser insalubre o nociva, y por los elementos, procesos o materiales peligrosos que manipula.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.6")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("b88ffdb7-680c-40f7-ba0e-630a736a444a").subMateria("REGISTRO SST")
						.descripcion(
								"El incumplimiento de las obligaciones de implementar y mantener actualizados los registros o disponer de la documentación que exigen las disposiciones relacionadas con la seguridad y salud en el trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.16")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("39b62f44-e50b-4135-8056-21a57536b43a").subMateria("TERCERIZACIÓN")
						.descripcion(
								"No verificar el cumplimiento de la normativa legal vigente en materia de seguridad y salud en el trabajo por parte de sus contratistas, subcontratistas, empresas especiales de servicios o cooperativas de trabajadores que desarrollen obras o servicios en el centro de trabajo o con ocasión del trabajo realizado por encargo de la principal.")
						.gravedad("").puntajeGravedad(null).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("663a09bc-a2af-4fcd-97bc-6aca466abab9").subMateria("EMBARAZO")
						.descripcion(
								"No observar las normas específicas en materia de protección de la seguridad y salud de las trabajadoras durante los periodos de embarazo y lactancia y de los trabajadores con discapacidad.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.5")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("d0d07782-b368-40fc-a3aa-e89b0e47a92c").subMateria("INDUSTRIA DE ALTO RIESGO")
						.descripcion(
								"No comunicar a la autoridad competente la apertura del centro de trabajo o la reanudación o continuación de los trabajos después de efectuar alteraciones o ampliaciones de importancia o consignar con inexactitud los datos que debe declarar o complementar, siempre que se trate de industria calificada de alto riesgo, por ser insalubre o nociva, y por los elementos, procesos o sustancias que manipulan.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("6e862d56-c55d-4e18-8ae8-d7f84b8f5a03").subMateria("HIGIENE")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la seguridad y salud en el trabajo, en particular en materia de lugares de trabajo, herramientas, máquinas y equipos, agentes físicos, químicos y biológicos, riesgos ergonómicos y psicosociales, medidas de protección colectiva, equipos de protección personal, señalización de seguridad, etiquetado y envasado de sustancias peligrosas, almacenamiento, servicios o medidas de higiene personal, de los que se derive un riesgo grave para la seguridad o salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.2")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("955eaa19-f105-466e-a153-c61ad8911c56").subMateria("DEBER DE PROTECCION")
						.descripcion(
								"No observar las normas específicas en materia de protección de la seguridad y salud de los menores trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("8904abb3-dc30-40e0-be27-1f972bc98d39").subMateria("PLAN DE SST")
						.descripcion(
								"El incumplimiento de la obligación de planificar la acción preventiva de riesgos para la seguridad y salud en el trabajo, así como el incumplimiento de la obligación de elaborar un plan o programa de seguridad y salud en el trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.2")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("5009bba5-7dec-4a5f-a227-e441a97b73c2").subMateria("INCIDENTE")
						.descripcion(
								"No dar cuenta a la autoridad competente, conforme a lo establecido en las normas de seguridad y salud en el trabajo, de los accidentes de trabajo mortales o de los incidentes peligrosos ocurridos, no comunicar los demás accidentes de trabajo al Centro Médico Asistencial donde el trabajador accidentado es atendido, o no llevar a cabo la investigación en caso de producirse daños a la salud de los trabajadores o de tenerse indicios que las medidas preventivas son insuficientes.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.14")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("c2ae7dae-50d6-4914-aa84-c2e3c29cc9fa").subMateria("AUDITORIA")
						.descripcion(
								"El incumplimiento de las obligaciones relativas a la realización de auditorías del Sistema de Gestión de Seguridad y Salud en el Trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("a867bc1b-8d08-487d-8203-5f3bcee8c68d").subMateria("PROGRAMA DE SST")
						.descripcion(
								"El incumplimiento de la obligación de planificar la acción preventiva de riesgos para la seguridad y salud en el trabajo, así como el incumplimiento de la obligación de elaborar un plan o programa de seguridad y salud en el trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("764b0642-919a-4e53-b65c-c106285a2236")
						.subMateria("PARTICIPACION DE TRABAJADORES")
						.descripcion(
								"La vulneración de los derechos de información, consulta y participación de los trabajadores reconocidos en la normativa sobre prevención de riesgos laborales.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("b3fab43d-6fe8-497a-8169-29454a0dcfb1").baseLegal("26.5")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("dbb62937-4f9c-4575-9498-a1407cac19a6").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"Cualquier otro incumplimiento que afecte a obligaciones de carácter formal o documental, exigidas en la normativa de prevención de riesgos y no estén tipificados como graves.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("793f0fad-187f-43e5-9622-56311d8d0d81")
						.subMateria("EQUIPOS DE PROTECCION PERSONAL")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la seguridad y salud en el trabajo, en particular en materia de lugares de trabajo, herramientas, máquinas y equipos, agentes físicos, químicos y biológicos, riesgos ergonómicos y psicosociales, medidas de protección colectiva, equipos de protección personal, señalización de seguridad, etiquetado y envasado de sustancias peligrosas, almacenamiento, servicios o medidas de higiene personal, de los que se derive un riesgo grave para la seguridad o salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.5")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("a2906a9b-1028-411f-b43d-8be8308fc7e4").subMateria("AGENTES CONTAMINANTES")
						.descripcion(
								"Superar los límites de exposición a los agentes contaminantes que originen riesgos graves e inminentes para la seguridad y salud de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.16")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("374929a7-44c0-4e71-9362-bab5f64f3d82").subMateria("MEDIDAS DE PREVENCIÓN")
						.descripcion(
								"No verificar el cumplimiento de la normativa legal vigente en materia de seguridad y salud en el trabajo por parte de sus contratistas, subcontratistas, empresas especiales de servicios o cooperativas de trabajadores que desarrollen obras o servicios en el centro de trabajo o con ocasión del trabajo realizado por encargo de la principal.")
						.gravedad("").puntajeGravedad(null).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("0d2259e3-51d7-4d9e-a5ce-b2c6bb3d402f").subMateria("CONDICIONES DE TRABAJO")
						.descripcion(
								"No llevar a cabo las evaluaciones de riesgos y los controles periódicos de las condiciones de trabajo y de las actividades de los trabajadores o no realizar aquellas actividades de prevención que sean necesarias según los resultados de las evaluaciones.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("0d2259e3-51d7-4d9e-a5ce-b2c6bb3d402f").subMateria("CONDICIONES DE TRABAJO")
						.descripcion(
								"No adoptar las medidas preventivas aplicables a las condiciones de trabajo de las que se derive un riesgo grave e inminente para la seguridad y salud de los trabajadores y personas que prestan servicios dentro del ámbito del centro de labores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.11")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("36e59810-9ead-44de-9d79-6677027434c3").subMateria("ACCIDENTE MORTAL")
						.descripcion(
								"El incumplimiento de la normativa sobre seguridad y salud en el trabajo que ocasione un accidente de trabajo mortal.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("049735fd-23ef-4cac-a6a9-114d97256445").subMateria("SISTEMA DE GESTION DE SST")
						.descripcion(
								"No implementar un sistema de gestión de seguridad y salud en el trabajo o no tener un reglamento de seguridad y salud en el trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.14")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("049735fd-23ef-4cac-a6a9-114d97256445").subMateria("SISTEMA DE GESTION DE SST")
						.descripcion(
								"El incumplimiento de las obligaciones relativas a la realización de auditorías del Sistema de Gestión de Seguridad y Salud en el Trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.12")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("98d395b4-c217-42ce-8747-6a8d54178d31").subMateria("ENFERMEDAD PROFESIONAL")
						.descripcion(
								"El incumplimiento de la normativa sobre la seguridad y salud en el trabajo que ocasione al trabajador una enfermedad ocupacional, debidamente diagnosticada y acreditada por el o los médicos especialistas según sus competencias")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.12")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("878a0c18-9949-4290-ba0a-1c199aa4a206").subMateria("COMITE DE SST")
						.descripcion(
								"No constituir o no designar a uno o varios trabajadores para participar como supervisor o miembro del Comité de Seguridad y Salud, así como no proporcionarles formación y capacitación adecuada.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("b3fab43d-6fe8-497a-8169-29454a0dcfb1").baseLegal("26.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("564fca06-3086-4e6d-9a76-f2407e47f7ef").subMateria("PREVENCION DE RIESGOS")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la prevención de riesgos, siempre que carezcan de trascendencia grave para la integridad física o salud de los trabajadores.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("1436f69a-e210-4a6c-9114-319438105f0d").subMateria("DERECHO DE INFORMACION")
						.descripcion(
								"La vulneración de los derechos de información, consulta y participación de los trabajadores reconocidos en la normativa sobre prevención de riesgos laborales.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.8")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("1436f69a-e210-4a6c-9114-319438105f0d").subMateria("DERECHO DE INFORMACION")
						.descripcion(
								"No cumplir con las obligaciones en materia de formación e información suficiente y adecuada a los trabajadores y las trabajadoras acerca de los riesgos del puesto de trabajo y sobre las medidas preventivas aplicables.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.8")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("1ba1523e-2726-4444-8fd3-a1ed3e1b3e4c").subMateria("FORMACION")
						.descripcion(
								"No cumplir con las obligaciones en materia de formación e información suficiente y adecuada a los trabajadores y las trabajadoras acerca de los riesgos del puesto de trabajo y sobre las medidas preventivas aplicables.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("bc043bb5-e60f-4b50-8417-814336314c36").subMateria("PRIMEROS AUXILIOS")
						.descripcion(
								"No adoptar las medidas necesarias en materia de primeros auxilios, lucha contra incendios y evacuación de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("8519af92-4133-4b59-934f-f4123c671db0").subMateria("DEBER DE CONFIDENCIALIDAD")
						.descripcion(
								"Incumplir el deber de confidencialidad en el uso de los datos relativos a la vigilancia de la salud de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("01f8b28d-16c5-48fd-9772-8bb559b308bc").subMateria("EVALUACION DE RIEGOS")
						.descripcion(
								"No llevar a cabo las evaluaciones de riesgos y los controles periódicos de las condiciones de trabajo y de las actividades de los trabajadores o no realizar aquellas actividades de prevención que sean necesarias según los resultados de las evaluaciones.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.12")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("31bd7afc-2383-471c-83a9-bae1d8b1b528").subMateria("CAPACITACION")
						.descripcion(
								"No constituir o no designar a uno o varios trabajadores para participar como supervisor o miembro del Comité de Seguridad y Salud, así como no proporcionarles formación y capacitación adecuada.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("8f3c7743-27aa-4bcc-918a-eea59ec5ad9c").subMateria("RIESGOS ERGONOMICOS")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la seguridad y salud en el trabajo, en particular en materia de lugares de trabajo, herramientas, máquinas y equipos, agentes físicos, químicos y biológicos, riesgos ergonómicos y psicosociales, medidas de protección colectiva, equipos de protección personal, señalización de seguridad, etiquetado y envasado de sustancias peligrosas, almacenamiento, servicios o medidas de higiene personal, de los que se derive un riesgo grave para la seguridad o salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.2")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("d03a9b8b-0df4-4aa6-888a-1c8047660e17").subMateria("TRABAJO DE MENORES DE EDAD")
						.descripcion(
								"No observar las normas específicas en materia de protección de la seguridad y salud de los menores trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("8519af92-4133-4b59-934f-f4123c671db0").subMateria("DEBER DE INFORMACION")
						.descripcion(
								"No realizar los reconocimientos médicos y pruebas de vigilancia periódica del estado de salud de los trabajadores o no comunicar a los trabajadores afectados el resultado de las mismas.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.9")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4c528df1-05af-423f-9eff-8afea8723a4e").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"Los incumplimientos de las disposiciones relacionadas con la seguridad y salud en el trabajo, en particular en materia de lugares de trabajo, herramientas, máquinas y equipos, agentes físicos, químicos y biológicos, riesgos ergonómicos y psicosociales, medidas de protección colectiva, equipos de protección personal, señalización de seguridad, etiquetado y envasado de sustancias peligrosas, almacenamiento, servicios o medidas de higiene personal, de los que se derive un riesgo grave para la seguridad o salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.11")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4c528df1-05af-423f-9eff-8afea8723a4e").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"El incumplimiento de las obligaciones establecidas en las disposiciones relacionadas con la seguridad y salud en el trabajo, en materia de coordinación entre empresas que desarrollen actividades en un mismo centro de trabajo.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("b3fab43d-6fe8-497a-8169-29454a0dcfb1").baseLegal("26.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4c528df1-05af-423f-9eff-8afea8723a4e").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"No comunicar a la autoridad competente la apertura del centro de trabajo o la reanudación o continuación de los trabajos después de efectuar alteraciones o ampliaciones de importancia, o consignar con inexactitud los datos que debe declarar o complementar, siempre que no se trate de una industria calificada de alto riesgo por ser insalubre o nociva, y por los elementos, procesos o materiales peligrosos que manipula.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.8")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4c528df1-05af-423f-9eff-8afea8723a4e").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"El incumplimiento de las obligaciones establecidas en las disposiciones relacionadas con la seguridad y salud en el trabajo, en materia de coordinación entre empresas que desarrollen actividades en un mismo centro de trabajo, cuando se trate de actividades calificadas de alto riesgo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.5")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4c528df1-05af-423f-9eff-8afea8723a4e").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"No comunicar a la autoridad competente la apertura del centro de trabajo o la reanudación o continuación de los trabajos después de efectuar alteraciones o ampliaciones de importancia o consignar con inexactitud los datos que debe declarar o complementar, siempre que se trate de industria calificada de alto riesgo, por ser insalubre o nociva, y por los elementos, procesos o sustancias que manipulan.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.15")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4ed159c8-f17c-49ec-9ecf-ec42e8687309").subMateria("SCTR")
						.descripcion(
								"No cumplir las obligaciones relativas al seguro complementario de trabajo de riesgo a favor de sus trabajadores, incurriéndose en una infracción por cada trabajador afectado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("0770c0d4-4574-468d-9928-ba75eec782b8").subMateria("EVACUACION")
						.descripcion(
								"No adoptar las medidas necesarias en materia de primeros auxilios, lucha contra incendios y evacuación de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("427e1c53-2998-4ee6-8492-249de147edbf").subMateria("DEBER DE VIGILANCIA")
						.descripcion(
								"No realizar los reconocimientos médicos y pruebas de vigilancia periódica del estado de salud de los trabajadores o no comunicar a los trabajadores afectados el resultado de las mismas.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.4")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("427e1c53-2998-4ee6-8492-249de147edbf").subMateria("DEBER DE VIGILANCIA")
						.descripcion(
								"Incumplir el deber de confidencialidad en el uso de los datos relativos a la vigilancia de la salud de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.1")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("bcc7a720-c94a-49b3-adbd-5afac4104d07").subMateria("ACCIDENTE DE TRABAJO")
						.descripcion(
								"El incumplimiento de la normativa sobre seguridad y salud en el trabajo que ocasione un accidente de trabajo que cause daño al cuerpo o a la salud del trabajador, que requiera asistencia o descanso médico, conforme al certificado o informe médico legal.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.2")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("bcc7a720-c94a-49b3-adbd-5afac4104d07").subMateria("ACCIDENTE DE TRABAJO")
						.descripcion(
								"No dar cuenta a la autoridad competente, conforme a lo establecido en las normas de seguridad y salud en el trabajo, de los accidentes de trabajo mortales o de los incidentes peligrosos ocurridos, no comunicar los demás accidentes de trabajo al Centro Médico Asistencial donde el trabajador accidentado es atendido, o no llevar a cabo la investigación en caso de producirse daños a la salud de los trabajadores o de tenerse indicios que las medidas preventivas son insuficientes.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("1ba1523e-2726-4444-8fd3-a1ed3e1b3e4c").subMateria("EXÁMENES MÉDICOS")
						.descripcion(
								"No cumplir con realizar los exámenes médicos ocupacionales y/o no cumplir con realizar la vigilancia de la salud de sus trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.10")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("049db7d9-4fc1-45ab-a407-5ac484ba6c30").subMateria("PERSONAS CON DICAPACIDAD")
						.descripcion(
								"No observar las normas específicas en materia de protección de la seguridad y salud de las trabajadoras durante los periodos de embarazo y lactancia y de los trabajadores con discapacidad.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.7")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("4591eabe-b1bd-4e53-a73a-0d217a4bb385").subMateria("CONTRATISTAS")
						.descripcion(
								"No adoptar las medidas preventivas aplicables a las condiciones de trabajo de las que se derive un riesgo grave e inminente para la seguridad y salud de los trabajadores y personas que prestan servicios dentro del ámbito del centro de labores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.5")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("3703cb85-e5b5-492b-8c5e-a23278c1bd55").subMateria("RIESGOS LABORALES")
						.descripcion(
								"Superar los límites de exposición a los agentes contaminantes que originen riesgos graves e inminentes para la seguridad y salud de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.13")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("3703cb85-e5b5-492b-8c5e-a23278c1bd55").subMateria("RIESGOS LABORALES")
						.descripcion(
								"La vulneración de los derechos de información, consulta y participación de los trabajadores reconocidos en la normativa sobre prevención de riesgos laborales.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.3")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("3703cb85-e5b5-492b-8c5e-a23278c1bd55").subMateria("RIESGOS LABORALES")
						.descripcion(
								"Designar a trabajadores en puestos cuyas condiciones sean incompatibles con sus características personales conocidas o sin tomar en consideración sus capacidades profesionales en materia de seguridad y salud en el trabajo, cuando de ellas se derive un riesgo grave e inminente para la seguridad y salud de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("b3fab43d-6fe8-497a-8169-29454a0dcfb1").baseLegal("26.1")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("34e5c162-a0cc-44f6-9b3f-f98a9076aeba").subMateria("ORDEN Y LIMPIEZA")
						.descripcion(
								"La falta de orden y limpieza del centro de trabajo que no implique riesgo para la integridad física y salud de los trabajadores.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("7c954cf7-c5c5-44b9-b6bc-3282582012cd").baseLegal("27.1")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("34e5c162-a0cc-44f6-9b3f-f98a9076aeba").subMateria("ORDEN Y LIMPIEZA")
						.descripcion(
								"La falta de orden y limpieza del centro de trabajo que implique riesgos para la integridad física y salud de los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("f8650e6b-1598-4546-93fb-a783387f5c07").baseLegal("28.6")
						.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
						.idSubMateria("d3a63399-3a15-447f-9f01-2b9d2a219e09").subMateria("PARALIZACION DE LABORES")
						.descripcion(
								"Las acciones y omisiones que impidan el ejercicio del derecho de los trabajadores para paralizar sus actividades en los casos de riesgo grave e inminente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("dd3697ee-4145-4091-a5dc-77e39b469f6d").subMateria("HUELGA")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.9")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("dd3697ee-4145-4091-a5dc-77e39b469f6d").subMateria("HUELGA")
						.descripcion(
								"La realización de actos que impidan el libre ejercicio del derecho de huelga, como la sustitución de trabajadores en huelga, bajo contratación directa a través de contratos indeterminados o sujetos a modalidad, o bajo contratación indirecta, a través de intermediación laboral o contratación y sub-contratación de obras o servicios, y el retiro de bienes de la empresa sin autorización de la Autoridad Administrativa de Trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.1")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("953a781f-52a3-401d-b99d-ce0ee7138471").subMateria("REGISTRO")
						.descripcion(
								"No comunicar y registrar ante la autoridad competente, en los plazos y con los requisitos previstos, documentación o información siempre que no esté tipificado como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.20")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("953a781f-52a3-401d-b99d-ce0ee7138471").subMateria("REGISTRO")
						.descripcion(
								"No registrar trabajadores, pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, personal de terceros o derechohabientes en las planillas de pago o planillas electrónicas a que se refiere el Decreto Supremo Nº 018-2007-TR y sus modificatorias, o no registrar trabajadores y prestadores de servicios en el registro de trabajadores y prestadores de servicios, en el plazo y con los requisitos previstos, incurriéndose en una infracción por cada trabajador, pensionista, prestador de servicios, personal en formación - Modalidad Formativa Laboral y otros, personal de terceros o derechohabiente.Para el cálculo de la multa a imponerse, se entiende como trabajadores afectados a los pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, así como los derechohabientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("953a781f-52a3-401d-b99d-ce0ee7138471").subMateria("REGISTRO")
						.descripcion(
								"El despacho en el sistema de prestaciones alimentarias, por parte de la empresa proveedora o cliente, de víveres o raciones alimentarias en malas condiciones de higiene o salubridad, sin las certificaciones o registros que correspondan o sin respetar las exigencias nutricionales previstas en las normas correspondientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.16")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("1dc617e8-7833-47f0-ac75-b4431e1aaf1a").subMateria("LACTANCIA")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la protección de las mujeres trabajadoras durante los períodos de embarazo y lactancia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9630f2f7-25fb-42a9-8eef-eded89362838").subMateria("LAUDO ARBITRAL")
						.descripcion(
								"No pagar u otorgar íntegra y oportunamente las remuneraciones y los beneficios laborales a los que tienen derecho los trabajadores por todo concepto, incluidos los establecidos por convenios colectivos, laudos arbitrales, así como la reducción de los mismos en fraude a la ley.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("efca2d07-e7a2-4314-8880-67c141dc1b96").subMateria("INFORMACION PLANILLA DE PAGO")
						.descripcion(
								"El incumplimiento de las siguientes obligaciones sobre planillas de pago, planillas electrónicas, o registro de trabajadores y prestadores de servicios: no encontrarse actualizado; no encontrarse debidamente autorizado de ser exigido; no consignar los datos completos; no presentarlo ante la Autoridad Administrativa de Trabajo; no presentarlo dentro del plazo o presentarlo incluyendo datos falsos o que no correspondan a la realidad; no efectuar el alta en el Registro, la modificación o actualización de datos, o la baja en el Registro, dentro del plazo correspondiente.Únicamente para el cálculo de la multa a imponer, se entiende por trabajadores afectados a los pensionistas, prestadores de servicios, personal en formación - Modalidad Formativa Laboral y otros, así como derechohabientes.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.27")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3fa5798d-c1a3-4783-b190-8f9b04516e89").subMateria("FRAUDE")
						.descripcion(
								"El comportamiento fraudulento del empleador para no configurar los supuestos del artículo 4 de la Ley Nº 31110, Ley del Régimen Laboral Agrario y de Incentivos para el Sector Agrario y Riego, Agroexportador y Agroindustrial, a fin de afectar el derecho preferencial de contratación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3fa5798d-c1a3-4783-b190-8f9b04516e89").subMateria("FRAUDE")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3fa5798d-c1a3-4783-b190-8f9b04516e89").subMateria("FRAUDE")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la contratación a plazo determinado, cualquiera que sea la denominación de los contratos, su desnaturalización, su uso fraudulento, y su uso para violar el principio de no discriminación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.9")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("cfdf204f-6eca-440e-a29f-7dc94b5b72d9").subMateria("RETIRO DE BIENES")
						.descripcion(
								"La realización de actos que impidan el libre ejercicio del derecho de huelga, como la sustitución de trabajadores en huelga, bajo contratación directa a través de contratos indeterminados o sujetos a modalidad, o bajo contratación indirecta, a través de intermediación laboral o contratación y sub-contratación de obras o servicios, y el retiro de bienes de la empresa sin autorización de la Autoridad Administrativa de Trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.14")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("fb8d8a8d-c658-4e83-b3f5-97c36539c461")
						.subMateria("REGLAMENTO INTERNO DE TRABAJO")
						.descripcion(
								"No contar con una dependencia adecuada de relaciones industriales, asistente social diplomado o reglamento interno de trabajo, cuando corresponda.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f95b8eef-25b2-45d7-adc6-61ea16f87944").subMateria("CTS")
						.descripcion(
								"No depositar íntegra y oportunamente la compensación por tiempo de servicios según la norma de la materia, o no efectuar el pago de dicha compensación al/la trabajador/a, de conformidad con lo previsto en la normativa del régimen correspondiente.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.16")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a73c9cfb-2f89-4ac0-99af-1ba7eac5e366").subMateria("TRABAJADORA GESTANTE")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la protección de las mujeres trabajadoras durante los períodos de embarazo y lactancia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("c242380f-d658-4bbf-8ead-fe0747bb08b7").subMateria("LICENCIAS")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("8ad17f69-3eb7-42f4-a178-fd131e3dc8d5").subMateria("SOBRETIEMPO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.21")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("b653b673-ee87-4c16-a7bf-64250563fd40")
						.subMateria("ENTREGA DE CONTRATO DE TRABAJO")
						.descripcion(
								"No celebrar por escrito y en plazos previstos contratos de trabajo, cuando este requisito sea exigible, así como no entregar al trabajador un ejemplar del referido contrato dentro del plazo establecido en la norma correspondiente")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("0c3c23dc-43f8-46ef-9ee6-334dfcad2cfc").subMateria("ALIMENTACIÓN")
						.descripcion(
								"No proporcionar a los/as trabajadores/as bajo el régimen laboral agrario las condiciones de trabajo para su trasladoal centro de trabajo, la habilitación de comedores, alimentación e hidratación adecuada y áreas de descanso, de conformidadcon el Reglamento de Negociación Colectiva y Condiciones Mínimas de Trabajo de la Ley Nº 31110, Ley de régimen laboralagrario y de incentivos para el sector agrario y riego, agroexportador y agroindustrial")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.17")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("43677095-c063-46e2-97ba-adbf715149b5").subMateria("PERSONAS CON DISCAPACIDAD")
						.descripcion(
								"La discriminación del trabajador, directa o indirecta, en materia de empleo u ocupación, como las referidas a la contratación, retribución, jornada, formación, promoción y demás condiciones, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.18")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6b12c803-35f6-4b24-a13f-4c0179b4b39e").subMateria("CAPACITACION")
						.descripcion(
								"No cumplir con las obligaciones referidas a la capacitación del/la trabajador/a o teletrabajador/a previstas en las normas de la materia.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.17")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("1df1a4f6-f2e4-4537-9a42-f10b6dd6f12a").subMateria("VIH")
						.descripcion(
								"La discriminación del trabajador, directa o indirecta, en materia de empleo u ocupación, como las referidas a la contratación, retribución, jornada, formación, promoción y demás condiciones, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9533c928-3e35-4e94-af14-5e905cf30938").subMateria("POLITICA SALARIAL")
						.descripcion(
								"No haber cumplido con informar a los trabajadores acerca de la política salarial de la empresa, conforme a lo previsto por la Ley Nº 26772, que dispone que las ofertas de empleo y acceso a medios de formación educativa no podrán contener requisitos que constituyan discriminación, anulación o alteración de igualdad de oportunidades o de trato, y su Reglamento.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.22")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9533c928-3e35-4e94-af14-5e905cf30938").subMateria("POLITICA SALARIAL")
						.descripcion(
								"No contar con un cuadro de categorias y funciones o con una politica salarial de conformidad con los terminos establecidos en la Ley N° 30709, Ley que prohÍbe la discriminacion remunerativa entre varones y mujeres, y su Reglamento")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9add00cd-193a-490d-8d27-4bbdeb923f8f").subMateria("DESNATURALIZACION")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la contratación a plazo determinado, cualquiera que sea la denominación de los contratos, su desnaturalización, su uso fraudulento, y su uso para violar el principio de no discriminación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.3")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("16cc9aa9-23cf-40cd-ba8d-b68edc0a9dc1").subMateria("PRESTACIONES ALIMENTARIAS")
						.descripcion(
								"Desempeñar actividades propias del sistema de prestaciones alimentarias sin cumplir con los requisitos previstos en las normas correspondientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("16cc9aa9-23cf-40cd-ba8d-b68edc0a9dc1").subMateria("PRESTACIONES ALIMENTARIAS")
						.descripcion(
								"El despacho en el sistema de prestaciones alimentarias, por parte de la empresa proveedora o cliente, de víveres o raciones alimentarias en malas condiciones de higiene o salubridad, sin las certificaciones o registros que correspondan o sin respetar las exigencias nutricionales previstas en las normas correspondientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("16cc9aa9-23cf-40cd-ba8d-b68edc0a9dc1").subMateria("PRESTACIONES ALIMENTARIAS")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el sistema de prestaciones alimentarias, siempre que no esté tipificado como muy grave.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.11")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a71ca2ec-3330-4a20-8f70-1ff0bb36c8c7").subMateria("FUERO SINDICAL")
						.descripcion(
								"La trasgresión a las garantías reconocidas a los trabajadores de sindicatos en formación, a los candidatos a dirigentes sindicales y a los miembros de comisiones negociadoras.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.11")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("10e3254f-7da1-4a54-b8b2-dd123e7e2ee5").subMateria("LIBERTAD SINDICAL")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el otorgamiento de facilidades para el ejercicio de la actividad sindical.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("10e3254f-7da1-4a54-b8b2-dd123e7e2ee5").subMateria("LIBERTAD SINDICAL")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.17")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("10e3254f-7da1-4a54-b8b2-dd123e7e2ee5").subMateria("LIBERTAD SINDICAL")
						.descripcion(
								"La discriminación del trabajador, directa o indirecta, en materia de empleo u ocupación, como las referidas a la contratación, retribución, jornada, formación, promoción y demás condiciones, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("af5fa754-e7d6-42d1-a714-d968e31ea4ce").subMateria("CONVENIO COLECTIVO")
						.descripcion(
								"No pagar u otorgar íntegra y oportunamente las remuneraciones y los beneficios laborales a los que tienen derecho los trabajadores por todo concepto, incluidos los establecidos por convenios colectivos, laudos arbitrales, así como la reducción de los mismos en fraude a la ley.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.24")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No iniciar el procedimiento de investigación y sanción del hostigamiento sexual, en los términos previstos en el numeral 29.1 del artículo 29 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción el Hostigamiento Sexual.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No cumplir con la obligación de comunicar al Ministerio de Trabajo y Promoción del Empleo la recepción de una queja o la toma de conocimiento de hechos vinculados a un caso de hostigamiento sexual o la decisión o resultado del procedimiento de investigación y sanción del hostigamiento sexual, de acuerdo a lo previsto en los numerales 29.3 y 29.6 del artículo 29 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción del Hostigamiento Sexual.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.22")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No adoptar las medidas previstas en el artículo 11 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sancióndel Hostigamiento Sexual.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.25")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No otorgar u otorgar de forma inoportuna las medidas de protección previstas en el numeral 29.2 del artículo 29 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción el Hostigamiento Sexual, así como el incumplimiento de la obligación prevista en el numeral 17.1 del artículo 17 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción el Hostigamiento Sexual.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.14")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"Los actos de hostilidad y el hostigamiento sexual, así como cualquier otro acto que afecte la dignidad del trabajador o el ejercicio de sus derechos constitucionales.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.15")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No adoptar las medidas necesarias para prevenir o cesar los actos de hostilidad y hostigamiento sexual, así como cualquier otro acto que afecte la dignidad del trabajador o el ejercicio de sus derechos constitucionales.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.26")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a59a18ad-5a73-4bdf-8eba-794ff01e10f7").subMateria("HOSTIGAMIENTO SEXUAL")
						.descripcion(
								"No cumplir con la obligación de emitir una decisión que ponga fin al procedimiento de investigación y sanción del hostigamiento sexual, en los términos previstos en el numeral 29.6 del artículo 29 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción del Hostigamiento Sexual")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.21")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3d856c03-7549-42ff-8979-37afc912d7bd")
						.subMateria("TRABAJADORES DEL REGIMEN PESQUERO")
						.descripcion(
								"No contar en el respectivo centro de trabajo con, o no comunicar, las tablas de unidades de trabajo a destajo o a comisión para determinar la remuneración diaria que corresponde a los trabajadores de la industria pesquera del consumo humano directo, conforme a lo previsto en la Ley Nº 27979 y su Reglamento.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("496ff1f7-6443-4cdd-bd76-2d8b2826d461").subMateria("LIQUIDACION DE CTS")
						.descripcion(
								"El incumplimiento de las obligaciones sobre boletas de pago de remuneraciones, hojas de pago de liquidación de la CTS; así como, aquellas entregadas al cese, de acuerdo con las formalidades y contenidos exigidos por las normas sobre la materia, siempre que no esté tipificado como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("496ff1f7-6443-4cdd-bd76-2d8b2826d461").subMateria("LIQUIDACION DE CTS")
						.descripcion(
								"No entregar al trabajador, en los plazos y con los requisitos previstos, boletas de pago de remuneraciones, hojas de liquidación de compensación por tiempo de servicios, participación en las utilidades u otros beneficios sociales, o cualquier otro documento que deba ser puesto a su disposición.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.7")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("a9b7af10-be03-49cc-8483-c9f650f4d585")
						.subMateria("REGISTRO DEL CONTRATO DE TRABAJO")
						.descripcion(
								"No celebrar por escrito y en los plazos previstos contratos de trabajo, cuando este requisito sea exigible, así como no presentar una copia de los mismos ante la Autoridad Administrativa de Trabajo para su conocimiento y registro.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("2e288914-cfc1-4ca3-adf6-d05a34834b96").subMateria("ENTREGA DEL RIT")
						.descripcion(
								"No exponer en lugar visible del centro de trabajo el horario de trabajo, no contar con un ejemplar de la síntesis de la legislación laboral, no entregar el reglamento interno de trabajo, cuando corresponda, o no exponer o entregar cualquier otra información o documento que deba ser puesto en conocimiento del trabajador.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6e8625b2-4fc9-4ce1-984d-f85b76f4feed").subMateria("LIQUIDACION DE UTILIDADES")
						.descripcion(
								"No entregar al trabajador, en los plazos y con los requisitos previstos, boletas de pago de remuneraciones, hojas de liquidación de compensación por tiempo de servicios, participación en las utilidades u otros beneficios sociales, o cualquier otro documento que deba ser puesto a su disposición.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.19")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("20082c35-e6e4-4c25-9750-09003404616f").subMateria("REGISTRO DE ASISTENCIA")
						.descripcion(
								"No contar con el registro de control de asistencia, o impedir o sustituir al trabajador en el registro de su tiempo de trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.22")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("51eb8072-bbbe-45b6-9c15-1428ac63468c").subMateria("DISCRIMINACIÓN REMUNERATIVA")
						.descripcion(
								"No contar con un cuadro de categorias y funciones o con una politica salarial de conformidad con los terminos establecidos en la Ley N° 30709, Ley que prohÍbe la discriminacion remunerativa entre varones y mujeres, y su Reglamento")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.8")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("c002e8b5-b2c7-45e4-bee4-cfba5cfa6cc4").subMateria("DEBER DE INFORMACION CTS")
						.descripcion(
								"No cumplir oportunamente con los deberes de información, hacia las entidades depositarias, relativos a la disponibilidad e intangibilidad de los depósitos por compensación por tiempo de servicios.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.16")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("4886d53a-6d22-436e-9482-cae4260acd67").subMateria("MADRE TRABAJADORA")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la protección de las mujeres trabajadoras durante los períodos de embarazo y lactancia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f9865837-b1d6-4b54-9ddd-232c3d4e4254").subMateria("CONTRATO SUJETO A MODALIDAD")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la contratación a plazo determinado, cualquiera que sea la denominación de los contratos, su desnaturalización, su uso fraudulento, y su uso para violar el principio de no discriminación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f9865837-b1d6-4b54-9ddd-232c3d4e4254").subMateria("CONTRATO SUJETO A MODALIDAD")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.1")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f4eff4e5-ee3b-4dda-b156-def99bcfcde3").subMateria("DEBER DE COMUNICACIÓN")
						.descripcion(
								"No comunicar y registrar ante la autoridad competente, en los plazos y con los requisitos previstos, documentación o información siempre que no esté tipificado como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.17")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("41dfb927-d4f6-45c4-878f-057d5a8f63e9").subMateria("REVERSION")
						.descripcion("Aplicar la reversión sin cumplir con los requisitos establecidos por ley.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.7")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("18d5b07d-1120-4255-80f4-d552f7d79aa0").subMateria("TRABAJO DE MENORES DE EDAD")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el trabajo de los niños, niñas y adolescentes menores de 18 años de edad en relación de dependencia, incluyendo aquellas actividades que se realicen por debajo de las edades mínimas permitidas para la admisión en el empleo, que afecten su salud o desarrollo físico, mental, emocional, moral, social y su proceso educativo. En especial, aquellos que no cuentan con autorización de la Autoridad Administrativa de Trabajo, los trabajos o actividades considerados como peligrosos y aquellos que deriven en el trabajo forzoso y la trata de personas con fines de explotación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("31e7456d-be50-4847-8d86-52ce8d75c13c").subMateria("LACTARIO")
						.descripcion(
								"El incumplimiento de las obligaciones relativas a la implementación de lactarios contenidas en la Ley Nº 29896, así como en sus respectivas normas reglamentarias y complementarias")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("b8c00d1e-0388-4e91-8a81-b8fe7604876e").subMateria("NEGOCIACION COLECTIVA")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.15")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("0a8b4042-48c2-4695-9dce-7b33467fe64c").subMateria("ACTO DE HOSTILIDAD")
						.descripcion(
								"No adoptar las medidas necesarias para prevenir o cesar los actos de hostilidad y hostigamiento sexual, así como cualquier otro acto que afecte la dignidad del trabajador o el ejercicio de sus derechos constitucionales.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.14")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("0a8b4042-48c2-4695-9dce-7b33467fe64c").subMateria("ACTO DE HOSTILIDAD")
						.descripcion(
								"Los actos de hostilidad y el hostigamiento sexual, así como cualquier otro acto que afecte la dignidad del trabajador o el ejercicio de sus derechos constitucionales.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.25")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("969aa455-50fe-484d-9417-db586b88e9d4").subMateria("MEDIDAS DE PROTECCIÓN")
						.descripcion(
								"No otorgar u otorgar de forma inoportuna las medidas de protección previstas en el numeral 29.2 del artículo 29 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción el Hostigamiento Sexual, así como el incumplimiento de la obligación prevista en el numeral 17.1 del artículo 17 del Reglamento de la Ley Nº 27942, Ley de Prevención y Sanción el Hostigamiento Sexual.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("064bf300-081c-4ae2-a915-f564e6bcfcdc")
						.subMateria("SINTESIS DE LA LEGISLACION LABORAL")
						.descripcion(
								"No exponer en lugar visible del centro de trabajo el horario de trabajo, no contar con un ejemplar de la síntesis de la legislación laboral, no entregar el reglamento interno de trabajo, cuando corresponda, o no exponer o entregar cualquier otra información o documento que deba ser puesto en conocimiento del trabajador.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.10")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("cf92e33d-9a9e-4dc4-b8aa-efa42e074a53").subMateria("AFILIACION SINDICAL")
						.descripcion(
								"La realización de actos que afecten la libertad sindical del trabajador o de la organización de trabajadores, tales como aquellos que impiden la libre afiliación a una organización sindical, promuevan la desafiliación de la misma, impidan la constitución de sindicatos, obstaculicen a la representación sindical, utilicen contratos de trabajo sujetos a modalidad para afectar la libertad sindical, la negociación colectiva y el ejercicio del derecho de huelga, o supuestos de intermediación laboral fraudulenta, o cualquier otro acto de interferencia en la organización de sindicatos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.7")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6aa8ffbe-5eae-4056-a9d0-2268bf34c8bf").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"Cualquier otro incumplimiento que afecte obligaciones meramente formales o documentales, siempre que no este tipificado como infraccion grave")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f1a3b1c8-8d85-4083-ada9-463a2eff7ca1").subMateria("REMUNERACION")
						.descripcion(
								"No pagar u otorgar íntegra y oportunamente las remuneraciones y los beneficios laborales a los que tienen derecho los trabajadores por todo concepto, incluidos los establecidos por convenios colectivos, laudos arbitrales, así como la reducción de los mismos en fraude a la ley.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.14")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("b0b673a7-6342-45ce-8141-05d5a55d8bd1").subMateria("ASISTENTE SOCIAL")
						.descripcion(
								"No contar con una dependencia adecuada de relaciones industriales, asistente social diplomado o reglamento interno de trabajo, cuando corresponda.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3ad08aa6-a25a-4013-b02a-b07c8ade9668").subMateria("ÁREAS DE DESCANSO")
						.descripcion(
								"No proporcionar a los/as trabajadores/as bajo el régimen laboral agrario las condiciones de trabajo para su trasladoal centro de trabajo, la habilitación de comedores, alimentación e hidratación adecuada y áreas de descanso, de conformidadcon el Reglamento de Negociación Colectiva y Condiciones Mínimas de Trabajo de la Ley Nº 31110, Ley de régimen laboralagrario y de incentivos para el sector agrario y riego, agroexportador y agroindustrial")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.13")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("03833dc1-821f-4ff7-a05f-b5dfbfb0ba06").subMateria("TRABAJADOR DEL HOGAR")
						.descripcion(
								"No proporcionar y garantizar las condiciones de alojamiento y alimentación en los casos que corresponda, así como, facilidades para la asistencia regular a su centro de estudios de acuerdo con lo establecido en Ley Nº 31047, Ley de Trabajadoras y Trabajadores del Hogar y su Reglamento.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.11")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("03833dc1-821f-4ff7-a05f-b5dfbfb0ba06").subMateria("TRABAJADOR DEL HOGAR")
						.descripcion(
								"No entregar la constancia de registro de alta, modificación o actualización, o baja en el registro del trabajo del hogar dentro del plazo correspondiente y según las exigencias previstas en la normatividad de la materia.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.16")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("aea7da8e-c6cd-4d05-9c6c-c566bc3b19ad").subMateria("TELETRABAJO")
						.descripcion(
								"Aplicar el cambio de modalidad de un trabajador convencional a la modalidad de teletrabajo o viceversa sin su consentimiento.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.18")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("aea7da8e-c6cd-4d05-9c6c-c566bc3b19ad").subMateria("TELETRABAJO")
						.descripcion(
								"No cumplir con las obligaciones referidas a la capacitación del teletrabajador previstas en las normas de la materia.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.19")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("aea7da8e-c6cd-4d05-9c6c-c566bc3b19ad").subMateria("TELETRABAJO")
						.descripcion(
								"No cumplir con el pago de la compensación por las condiciones de trabajo asumidas por el teletrabajador.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.8")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("578c1bff-de34-4353-b8ae-2ae87de14ca5").subMateria("PLIEGO DE RECLAMOS")
						.descripcion(
								"La negativa a recibir el pliego de reclamos, salvo causa legal o convencional objetivamente demostrable que justifique dicha negativa.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.9")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("300ab028-e63e-440a-8308-563f7575409c")
						.subMateria("INSCRIPCION Y REGISTRO RENOCC")
						.descripcion(
								"El incumplimiento de inscribir la obra, de declarar participación en la ejecución de la obra, de actualizar información y/o de reportar la finalización en el Registro Nacional de Obras de Construcción Civil - RENOCC, dentro de los plazos establecidos, conforme a lo previsto en el Reglamento del Registro Nacional de Obras de Construcción Civil - RENOCC.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("cff20c39-4d10-415b-b5ea-db0eb592ea3a")
						.subMateria("REGISTRO NACIONAL DE EMPRESAS ADMINISTRADORAS Y EMPRESAS PROVEEDORAS DE ALIMENTOS")
						.descripcion(
								"La inscripción fraudulenta en el Registro Nacional de Empresas Administradoras y Empresas Proveedoras de Alimentos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.15")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("30520bf4-bc0a-48f0-9334-aa56f3a1e110")
						.subMateria("REGISTRO NACIONAL DE TRABAJADORES DE CONSTRUCCION CIVIL")
						.descripcion(
								"Valerse de los servicios de trabajadores que realizan actividades de construcción civil, que no estén inscritos en el Registro Nacional de Trabajadores de Construcción Civil - RETCC.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("e5cd1ef9-3aa4-46d5-9cb0-65d091ab69e5")
						.subMateria("PUBLICACION DEL HORARIO DE TRABAJO")
						.descripcion(
								"No exponer en lugar visible del centro de trabajo el horario de trabajo, no contar con un ejemplar de la síntesis de la legislación laboral, no entregar el reglamento interno de trabajo, cuando corresponda, o no exponer o entregar cualquier otra información o documento que deba ser puesto en conocimiento del trabajador.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.9")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("e426be05-67ef-4ed6-9f7c-e29740269653").subMateria("ESQUIROLAJE")
						.descripcion(
								"La realización de actos que impidan el libre ejercicio del derecho de huelga, como la sustitución de trabajadores en huelga, bajo contratación directa a través de contratos indeterminados o sujetos a modalidad, o bajo contratación indirecta, a través de intermediación laboral o contratación y sub-contratación de obras o servicios, y el retiro de bienes de la empresa sin autorización de la Autoridad Administrativa de Trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("7d36e923-cf05-42a3-990c-14e7ed8e483c").subMateria("TRABAJO NOCTURNO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("d7c8915c-a29d-4867-8aa8-c7c1e46c5b8d").subMateria("CONDICIONES DE TRABAJO")
						.descripcion(
								"No proporcionar a los/as trabajadores/as bajo el régimen laboral agrario las condiciones de trabajo para su trasladoal centro de trabajo, la habilitación de comedores, alimentación e hidratación adecuada y áreas de descanso, de conformidadcon el Reglamento de Negociación Colectiva y Condiciones Mínimas de Trabajo de la Ley Nº 31110, Ley de régimen laboralagrario y de incentivos para el sector agrario y riego, agroexportador y agroindustrial")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.19")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("d7c8915c-a29d-4867-8aa8-c7c1e46c5b8d").subMateria("CONDICIONES DE TRABAJO")
						.descripcion(
								"No cumplir con el pago de la compensación por las condiciones de trabajo asumidas por el teletrabajador.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("838c5457-506d-4e1f-b569-d186bbe2caa8").subMateria("DEBER DE INFORMAR")
						.descripcion(
								"No haber cumplido con informar a los trabajadores acerca de la política salarial de la empresa, conforme a lo previsto por la Ley Nº 26772, que dispone que las ofertas de empleo y acceso a medios de formación educativa no podrán contener requisitos que constituyan discriminación, anulación o alteración de igualdad de oportunidades o de trato, y su Reglamento.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("0d44eb72-0692-4116-95a7-96f01c479a1f").subMateria("BOLETA DE PAGO")
						.descripcion(
								"El incumplimiento de las obligaciones sobre boletas de pago de remuneraciones, hojas de pago de liquidación de la CTS; así como, aquellas entregadas al cese, de acuerdo con las formalidades y contenidos exigidos por las normas sobre la materia, siempre que no esté tipificado como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("0d44eb72-0692-4116-95a7-96f01c479a1f").subMateria("BOLETA DE PAGO")
						.descripcion(
								"No entregar al trabajador, en los plazos y con los requisitos previstos, boletas de pago de remuneraciones, hojas de liquidación de compensación por tiempo de servicios, participación en las utilidades u otros beneficios sociales, o cualquier otro documento que deba ser puesto a su disposición.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.27")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("454e95dd-2404-4c7d-bb2e-cf12a6c592c9")
						.subMateria("DERECHO PREFERENCIAL DE CONTRATACIÓN")
						.descripcion(
								"El comportamiento fraudulento del empleador para no configurar los supuestos del artículo 4 de la Ley Nº 31110, Ley del Régimen Laboral Agrario y de Incentivos para el Sector Agrario y Riego, Agroexportador y Agroindustrial, a fin de afectar el derecho preferencial de contratación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.28")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("454e95dd-2404-4c7d-bb2e-cf12a6c592c9")
						.subMateria("DERECHO PREFERENCIAL DE CONTRATACIÓN")
						.descripcion(
								"No haber realizado la convocatoria de trabajadores/as en atención al derecho preferencial de contratación en los términos exigidos por el artículo 19 del Reglamento de la Ley Nº 31110, Ley del Régimen Laboral Agrario y de Incentivos para el Sector Agrario y Riego, Agroexportador y Agroindustrial")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.1")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("5c7e4dec-80f2-446b-9af6-06bbfba3cfc8").subMateria("REMUNERACION MINIMA VITAL")
						.descripcion("No pagar la remuneración mínima correspondiente.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.12")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9add00cd-193a-490d-8d27-4bbdeb923f8f").subMateria("DISCRIMINACION")
						.descripcion(
								"La discriminación de un trabajador por el libre ejercicio de su actividad sindical, esté contratado a plazo indeterminado, sujetos a modalidad, a tiempo parcial, u otros.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.17")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9add00cd-193a-490d-8d27-4bbdeb923f8f").subMateria("DISCRIMINACION")
						.descripcion(
								"La discriminación del trabajador, directa o indirecta, en materia de empleo u ocupación, como las referidas a la contratación, retribución, jornada, formación, promoción y demás condiciones, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.5")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9add00cd-193a-490d-8d27-4bbdeb923f8f").subMateria("DISCRIMINACION")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la contratación a plazo determinado, cualquiera que sea la denominación de los contratos, su desnaturalización, su uso fraudulento, y su uso para violar el principio de no discriminación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f66d7cfa-ea32-4d74-aabf-d87893404645").subMateria("CONTRATO DE TRABAJO")
						.descripcion(
								"No entregar al trabajador, en los plazos y con los requisitos previstos, boletas de pago de remuneraciones, hojas de liquidación de compensación por tiempo de servicios, participación en las utilidades u otros beneficios sociales, o cualquier otro documento que deba ser puesto a su disposición.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.21")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f66d7cfa-ea32-4d74-aabf-d87893404645").subMateria("CONTRATO DE TRABAJO")
						.descripcion(
								"No celebrar por escrito y en plazos previstos contratos de trabajo, cuando este requisito sea exigible, así como no entregar al trabajador un ejemplar del referido contrato dentro del plazo establecido en la norma correspondiente")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.12")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("4330a88d-6fcd-4469-83aa-1afeb6b7e876").subMateria("SEGURO VIDA LEY")
						.descripcion(
								"No registrar el Contrato de Seguro de Vida Ley en el Registro Obligatorio de Contratos creado por la Ley Nº 29549, no contratar la póliza de seguro de vida, no mantenerla vigente o no pagar oportunamente la prima, a favor de los trabajadores con derecho a éste, incurriéndose en una infracción por cada trabajador afectado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.20")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("5e4dc4d5-e81f-422e-8fae-1db25f947fa3").subMateria("PLAME")
						.descripcion(
								"No registrar trabajadores, pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, personal de terceros o derechohabientes en las planillas de pago o planillas electrónicas a que se refiere el Decreto Supremo Nº 018-2007-TR y sus modificatorias, o no registrar trabajadores y prestadores de servicios en el registro de trabajadores y prestadores de servicios, en el plazo y con los requisitos previstos, incurriéndose en una infracción por cada trabajador, pensionista, prestador de servicios, personal en formación - Modalidad Formativa Laboral y otros, personal de terceros o derechohabiente.Para el cálculo de la multa a imponerse, se entiende como trabajadores afectados a los pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, así como los derechohabientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("b8da6b47-1c1c-4494-8fc3-c38cd836abd9").subMateria("JORNADA DE TRABAJO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.12")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("cb2d6e68-d5e7-448c-877c-4d3e8a175419").subMateria("ACTO ANTISINDICAL")
						.descripcion(
								"La discriminación de un trabajador por el libre ejercicio de su actividad sindical, esté contratado a plazo indeterminado, sujetos a modalidad, a tiempo parcial, u otros.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.8")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("cb2b882e-c07c-4a72-afc7-0ce9bced7c89").subMateria("IUS VARIANDI")
						.descripcion(
								"La modificación unilateral por el empleador del contrato y las condiciones de trabajo, en los casos en los que no se encuentra facultado para ello.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.3")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6a131630-a4c3-497f-92d8-de1aaf827191")
						.subMateria("INFORMACION BOLETA DE PAGO Y LIQUIDACIONES")
						.descripcion(
								"El incumplimiento de las siguientes obligaciones en materia de boletas de pago y hojas de liquidación: consignar datos distintos a los registrados en las planillas de pago o registros que las sustituyan, registros de trabajadores y prestadores de servicios, incluir datos falsos o que no correspondan a la realidad.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9abb84ea-4f04-41a1-82da-0bc3f0620ffb").subMateria("DESCANSO VACACIONAL")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.4")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("9ad1bdfb-025c-41aa-ba3d-a1cc4e219b87").subMateria("BENEFICIOS SOCIALES")
						.descripcion(
								"No pagar u otorgar íntegra y oportunamente las remuneraciones y los beneficios laborales a los que tienen derecho los trabajadores por todo concepto, incluidos los establecidos por convenios colectivos, laudos arbitrales, así como la reducción de los mismos en fraude a la ley.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.20")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("d7acdccc-7fd1-49f5-b882-401065b16743").subMateria("PLANILLA DE PAGO")
						.descripcion(
								"No registrar trabajadores, pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, personal de terceros o derechohabientes en las planillas de pago o planillas electrónicas a que se refiere el Decreto Supremo Nº 018-2007-TR y sus modificatorias, o no registrar trabajadores y prestadores de servicios en el registro de trabajadores y prestadores de servicios, en el plazo y con los requisitos previstos, incurriéndose en una infracción por cada trabajador, pensionista, prestador de servicios, personal en formación - Modalidad Formativa Laboral y otros, personal de terceros o derechohabiente.Para el cálculo de la multa a imponerse, se entiende como trabajadores afectados a los pensionistas, prestadores de servicios, personal contratado bajo modalidades formativas laborales, así como los derechohabientes.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.3")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("d7acdccc-7fd1-49f5-b882-401065b16743").subMateria("PLANILLA DE PAGO")
						.descripcion(
								"El incumplimiento de las obligaciones sobre planillas de pago o registro que las sustituya, o registro de trabajadores y prestadores de servicios, siempre que no esté tipificado como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.19")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f1b78a3a-8a2b-4f3f-84a9-c24d3de7d703").subMateria("TIEMPO DE TRABAJO")
						.descripcion(
								"No contar con el registro de control de asistencia, o impedir o sustituir al trabajador en el registro de su tiempo de trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f1b78a3a-8a2b-4f3f-84a9-c24d3de7d703").subMateria("TIEMPO DE TRABAJO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.13")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("2a69b505-0f16-4855-bc0f-ea380368e602").subMateria("ABANDONO")
						.descripcion("El cierre no autorizado o abandono del centro de trabajo.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.14")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("395c48cc-c9f1-40a0-99bd-c677a0eeeaea").subMateria("RELACIONES INDUSTRIALES")
						.descripcion(
								"No contar con una dependencia adecuada de relaciones industriales, asistente social diplomado o reglamento interno de trabajo, cuando corresponda.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.28")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("ab1748df-5c1a-4387-8a42-e81de31697a3").subMateria("TRABAJO AGRARIO")
						.descripcion(
								"No haber realizado la convocatoria de trabajadores/as en atención al derecho preferencial de contratación en los términos exigidos por el artículo 19 del Reglamento de la Ley Nº 31110, Ley del Régimen Laboral Agrario y de Incentivos para el Sector Agrario y Riego, Agroexportador y Agroindustrial")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.27")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("ab1748df-5c1a-4387-8a42-e81de31697a3").subMateria("TRABAJO AGRARIO")
						.descripcion(
								"El comportamiento fraudulento del empleador para no configurar los supuestos del artículo 4 de la Ley Nº 31110, Ley del Régimen Laboral Agrario y de Incentivos para el Sector Agrario y Riego, Agroexportador y Agroindustrial, a fin de afectar el derecho preferencial de contratación.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.23")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("ab1748df-5c1a-4387-8a42-e81de31697a3").subMateria("TRABAJO AGRARIO")
						.descripcion(
								"No proporcionar a los/as trabajadores/as bajo el régimen laboral agrario las condiciones de trabajo para su trasladoal centro de trabajo, la habilitación de comedores, alimentación e hidratación adecuada y áreas de descanso, de conformidadcon el Reglamento de Negociación Colectiva y Condiciones Mínimas de Trabajo de la Ley Nº 31110, Ley de régimen laboralagrario y de incentivos para el sector agrario y riego, agroexportador y agroindustrial")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.9")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("b1398dd9-6fd8-4c07-ae1d-59231e1d2757")
						.subMateria("INFORMACION ECONOMICA FINANCIERA")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la entrega a los representantes de los trabajadores de información sobre la situación económica, financiera, social y demás pertinente de la empresa, durante el procedimiento de negociación colectiva.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.22")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("88c6bcc3-fd5b-4f78-9063-6f25de6e9c7b")
						.subMateria("CUADRO DE CATEGORIAS Y FUNCIONES")
						.descripcion(
								"No contar con un cuadro de categorias y funciones o con una politica salarial de conformidad con los terminos establecidos en la Ley N° 30709, Ley que prohÍbe la discriminacion remunerativa entre varones y mujeres, y su Reglamento")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("2e762360-754f-458a-bbef-a622103a8bc6").baseLegal("24.1")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("c1475c55-fe43-4e4b-87e2-ed80eaf95544").subMateria("CUOTA SINDICAL")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el descuento y la entrega de cuotas sindicales y contribuciones destinadas a la constitución y fomento de las cooperativas formadas por los trabajadores sindicalizados.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.18")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3861bd55-c0b7-44ad-b7b8-b41f553695e2").subMateria("TRABAJO FORZOSO")
						.descripcion(
								"El trabajo forzoso, sea o no retribuido, y la trata o captación de personas con dicho fin.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.7")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("3861bd55-c0b7-44ad-b7b8-b41f553695e2").subMateria("TRABAJO FORZOSO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el trabajo de los niños, niñas y adolescentes menores de 18 años de edad en relación de dependencia, incluyendo aquellas actividades que se realicen por debajo de las edades mínimas permitidas para la admisión en el empleo, que afecten su salud o desarrollo físico, mental, emocional, moral, social y su proceso educativo. En especial, aquellos que no cuentan con autorización de la Autoridad Administrativa de Trabajo, los trabajos o actividades considerados como peligrosos y aquellos que deriven en el trabajo forzoso y la trata de personas con fines de explotación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("90b3d82b-3772-45a0-bc15-224822c99279").subMateria("REFRIGERIO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la jornada de trabajo, refrigerio, trabajo en sobretiempo, trabajo nocturno, descanso vacacional y otros descansos, licencias, permisos y el tiempo de trabajo en general.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.7")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6eb705fc-fe49-479e-a138-cfa51dc4dcf9").subMateria("TRATA DE PERSONAS")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con el trabajo de los niños, niñas y adolescentes menores de 18 años de edad en relación de dependencia, incluyendo aquellas actividades que se realicen por debajo de las edades mínimas permitidas para la admisión en el empleo, que afecten su salud o desarrollo físico, mental, emocional, moral, social y su proceso educativo. En especial, aquellos que no cuentan con autorización de la Autoridad Administrativa de Trabajo, los trabajos o actividades considerados como peligrosos y aquellos que deriven en el trabajo forzoso y la trata de personas con fines de explotación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.18")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("6eb705fc-fe49-479e-a138-cfa51dc4dcf9").subMateria("TRATA DE PERSONAS")
						.descripcion(
								"El trabajo forzoso, sea o no retribuido, y la trata o captación de personas con dicho fin.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("abf80a65-3832-4e05-8b6e-1416a4df1244").baseLegal("25.16")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("f03152c8-164c-4325-a95f-cd7acfb1358f").subMateria("EMBARAZO")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la protección de las mujeres trabajadoras durante los períodos de embarazo y lactancia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.6")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("d0b44507-eafd-4dba-a3dc-576cd77c1ad0")
						.subMateria("REGISTRO DE CONTROL DE ASISTENCIA")
						.descripcion("No contar con registro de control de asistencia de los trabajadores afectados")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("e6a486b3-1753-40e0-b633-ab7b806b899d").baseLegal("23.2")
						.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
						.idSubMateria("8ebb31a4-fd4c-4306-8720-19971fcc5ee3").subMateria("OTROS DOCUMENTOS LABORALES")
						.descripcion(
								"No entregar al trabajador, en los plazos y con los requisitos previstos, boletas de pago de remuneraciones, hojas de liquidación de compensación por tiempo de servicios, participación en las utilidades u otros beneficios sociales, o cualquier otro documento que deba ser puesto a su disposición.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("623baada-5d6e-4e31-ac63-04bbbd939fe7").baseLegal("45.3")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("694da0f0-22c3-4762-97f0-afc49957a00c").subMateria("PUBLICIDAD DE INFRACCION")
						.descripcion(
								"El retiro de carteles del centro de trabajo o la obstrucción de la publicidad de listas que permitan conocer al público sobre la condición de infractor del sujeto inspeccionado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.10")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("ffac6a6d-09c7-48f9-a437-415ebb40db2f").subMateria("COMPARECENCIA")
						.descripcion("La inasistencia del sujeto inspeccionado ante un requerimiento de comparecencia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.9")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("f1e34594-6761-460f-916a-9bb721ddb2f7").subMateria("RIESGOS LABORALES")
						.descripcion(
								"No cumplir inmediatamente con la orden de paralización o prohibición de trabajos o tareas por inobservancia de la normativa sobre prevención de riesgos laborales cuando concurra riesgo grave e inminente para la seguridad y salud de los trabajadores, o la reanudación de los trabajos o tareas sin haber subsanado previamente las causas que motivaron la paralización o prohibición.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.9")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("85dc086f-54e9-4fe4-bacd-b784b90966cb").subMateria("PARALIZACION DE LABORES")
						.descripcion(
								"No cumplir inmediatamente con la orden de paralización o prohibición de trabajos o tareas por inobservancia de la normativa sobre prevención de riesgos laborales cuando concurra riesgo grave e inminente para la seguridad y salud de los trabajadores, o la reanudación de los trabajos o tareas sin haber subsanado previamente las causas que motivaron la paralización o prohibición.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.6")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("5ebf797a-b457-401b-95e7-9993b65a7435").subMateria("INASISTENCIA")
						.descripcion("El abandono o inasistencia a las diligencias inspectivas").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.10")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("5ebf797a-b457-401b-95e7-9993b65a7435").subMateria("INASISTENCIA")
						.descripcion("La inasistencia del sujeto inspeccionado ante un requerimiento de comparecencia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.13")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("51a20ed6-b72c-4294-a770-5836ec2884da").subMateria("ACCIDENTE DE TRABAJO")
						.descripcion(
								"Obstaculizar, por acción u omisión, la investigación de un accidente de trabajo mortal a cargo del inspector del trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("623baada-5d6e-4e31-ac63-04bbbd939fe7").baseLegal("45.1")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("940292b1-c290-4cd4-b441-91f92480a635").subMateria("DEBER DE COLABORACION")
						.descripcion(
								"Los incumplimientos al deber de colaboración con los supervisores inspectores, los inspectores de trabajo y los auxiliares de inspección regulado por el artículo 9 de la Ley, siempre que no estén tipificados como infracciones muy graves.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.3")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("0b60948d-1434-48b4-b123-cb6917ab368f").subMateria("DOCUMENTOS LABORALES")
						.descripcion(
								"La negativa del sujeto inspeccionado o sus representantes de facilitar a los supervisores inspectores, los inspectores de trabajo o los inspectores auxiliares, la información y documentación necesarias para el desarrollo de sus funciones.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.11")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("249fca5a-bc20-4730-b09d-3b56c5f647db").subMateria("PLAN DE FORMALIZACION")
						.descripcion(
								"No cumplir con el plan de formalización dispuesto por la Autoridad Administrativa de Trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.5")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("e11a64c7-3231-451e-8f2f-496f6d48d763").subMateria("LIBERTAD SINDICAL")
						.descripcion(
								"Obstaculizar la participación del trabajador o su representante o de los trabajadores o la organización sindical.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("623baada-5d6e-4e31-ac63-04bbbd939fe7").baseLegal("45.1")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"Los incumplimientos al deber de colaboración con los supervisores inspectores, los inspectores de trabajo y los auxiliares de inspección regulado por el artículo 9 de la Ley, siempre que no estén tipificados como infracciones muy graves.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.2")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"La negativa del sujeto inspeccionado o sus representantes de acreditar su identidad o la identidad de las personas que se encuentran en los centros o lugares de trabajo ante los supervisores inspectores, los inspectores de trabajo o los inspectores auxiliares.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("623baada-5d6e-4e31-ac63-04bbbd939fe7").baseLegal("45.2")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"Las acciones u omisiones que perturben, retrasen o impidan el ejercicio de las funciones inspectivas de los supervisores inspectores, los inspectores de trabajo o los inspectores auxiliares, siempre que no estén tipificados como infracciones muy graves.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.3")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"La negativa del sujeto inspeccionado o sus representantes de facilitar a los supervisores inspectores, los inspectores de trabajo o los inspectores auxiliares, la información y documentación necesarias para el desarrollo de sus funciones.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.6")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion("El abandono o inasistencia a las diligencias inspectivas").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.4")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"El impedimento de la obtención de muestras y registros cuando se notifique al sujeto inspeccionado o a su representante.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.1")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("41c9a23b-0277-4ef4-8330-dd975f05645a")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA")
						.descripcion(
								"La negativa injustificada o el impedimento de entrada o permanencia en un centro de trabajo o en determinadas áreas del mismo a los supervisores inspectores, los inspectores de trabajo, los inspectores auxiliares, o peritos y técnicos designados oficialmente, para que se realice una inspección.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.1")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("95628eec-d9e0-4921-bdd4-3bd19b29615f").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"La negativa injustificada o el impedimento de entrada o permanencia en un centro de trabajo o en determinadas áreas del mismo a los supervisores inspectores, los inspectores de trabajo, los inspectores auxiliares, o peritos y técnicos designados oficialmente, para que se realice una inspección.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("623baada-5d6e-4e31-ac63-04bbbd939fe7").baseLegal("45.3")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("95628eec-d9e0-4921-bdd4-3bd19b29615f").subMateria("CENTRO DE TRABAJO")
						.descripcion(
								"El retiro de carteles del centro de trabajo o la obstrucción de la publicidad de listas que permitan conocer al público sobre la condición de infractor del sujeto inspeccionado.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.2")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("ce3e1a67-03e3-47d7-87b5-63297b5c5d47").subMateria("NEGATIVA DE IDENTIFICACION")
						.descripcion(
								"La negativa del sujeto inspeccionado o sus representantes de acreditar su identidad o la identidad de las personas que se encuentran en los centros o lugares de trabajo ante los supervisores inspectores, los inspectores de trabajo o los inspectores auxiliares.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.12")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("d4b92e05-85dc-4d66-8650-e0e6cc3a56f6")
						.subMateria("OBSTRUCCION A LA LABOR INSPECTIVA COACCION")
						.descripcion(
								"La coacción, amenaza o violencia ejercida sobre los supervisores inspectores, los inspectores de trabajo y los inspectores auxiliares.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.6")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("cfc57028-f2c6-431f-a54d-336555f222dc").subMateria("NO ESPECIFICA")
						.descripcion("El abandono o inasistencia a las diligencias inspectivas").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.60")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("332dc558-3373-4890-9213-c3bbb4176b39").subMateria("ABANDONO")
						.descripcion(
								"El abandono, la inasistencia u otro acto que impida el ejercicio de la función inspectiva.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.14")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("b014ba56-a9be-4171-96c8-32a04a6e9ab4").subMateria("ACCIDENTE MORTAL")
						.descripcion(
								"No cumplir, en caso de accidente de trabajo mortal, con la orden de cierre temporal del área de una unidad económica o una unidad económica dispuesta por el inspector del trabajo, alterar el lugar en el que se produjo el accidente de trabajo mortal o proporcionar información falsa o imprecisa")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.7")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("949030e2-8439-4082-9985-bfe318e9e0d8").subMateria("MEDIDA DE REQUERIMIENTO")
						.descripcion(
								"No cumplir oportunamente con el requerimiento de la adopción de medidas en orden al cumplimiento de la normativa de orden sociolaboral y de seguridad y salud en el trabajo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("fd49df21-ac12-494a-bfdb-cf1c69251171").baseLegal("46.8")
						.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
						.idSubMateria("949030e2-8439-4082-9985-bfe318e9e0d8").subMateria("MEDIDA DE REQUERIMIENTO")
						.descripcion(
								"No cumplir oportunamente con el requerimiento de las modificaciones que sean precisas en las instalaciones, en el montaje o en los métodos de trabajo que garanticen el cumplimiento de las disposiciones relativas a la salud o a la seguridad de los trabajadores.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("1d22566d-ccb5-4802-a24d-743d29f61c53").baseLegal("43.3")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("38c6d4dc-9947-49a4-988a-3dccba593a5a").subMateria("FRAUDE")
						.descripcion("La contratación fraudulenta de trabajadores extranjeros.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("1af1a4af-151f-4b7b-88c1-38be9c0c07cb").baseLegal("41.1")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("fd45e60e-00c7-486b-8d52-367071a922b4").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"Los incumplimientos que afecten a obligaciones meramente formales o documentales, en materia de contratación de trabajadores extranjeros, siempre que no estén tipificados como infracciones graves.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("1d22566d-ccb5-4802-a24d-743d29f61c53").baseLegal("43.2")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("7d30a5e9-e566-4b52-9d29-fddc1007ed5a").subMateria("LIMITES DE CONTRATACION")
						.descripcion(
								"La presentación a la Autoridad competente de información o documentación falsa para la exoneración de los límites a la contratación de trabajadores extranjeros.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7f82ef6d-5806-4a18-a049-649f8b7b4615").baseLegal("42.2")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("7d30a5e9-e566-4b52-9d29-fddc1007ed5a").subMateria("LIMITES DE CONTRATACION")
						.descripcion(
								"No cumplir con los límites a la contratación de trabajadores extranjeros, cuando corresponda.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("1d22566d-ccb5-4802-a24d-743d29f61c53").baseLegal("43.1")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion(
								"Ocupar o contratar trabajadores extranjeros sin haber obtenido previamente la autorización administrativa correspondiente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("1d22566d-ccb5-4802-a24d-743d29f61c53").baseLegal("43.3")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion("La contratación fraudulenta de trabajadores extranjeros.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("7f82ef6d-5806-4a18-a049-649f8b7b4615").baseLegal("42.2")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion(
								"No cumplir con los límites a la contratación de trabajadores extranjeros, cuando corresponda.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("1af1a4af-151f-4b7b-88c1-38be9c0c07cb").baseLegal("41.2")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion(
								"No entregar al trabajador extranjero, en los plazos y con los requisitos previstos, copia de su contrato de trabajo autorizado por la autoridad competente.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("7f82ef6d-5806-4a18-a049-649f8b7b4615").baseLegal("42.1")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion(
								"No formalizar por escrito los contratos de trabajo celebrados con trabajadores extranjeros, con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("1d22566d-ccb5-4802-a24d-743d29f61c53").baseLegal("43.2")
						.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
						.idSubMateria("d1279599-bbf9-4c9e-95ef-a01f9ab964c3")
						.subMateria("CONTRATO DE TRABAJADOR EXTRANJERO")
						.descripcion(
								"La presentación a la Autoridad competente de información o documentación falsa para la exoneración de los límites a la contratación de trabajadores extranjeros.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("b2b86e34-7bb6-41f9-a357-206f80dadb15").subMateria("LIMITES DE CONTRATACION")
						.descripcion(
								"Exceder los límites porcentuales y cualitativos aplicables a la intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.3")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("12f4f361-05b5-494a-b646-c1411bc0cc3c")
						.subMateria("CONTRATO DE PRESTACION DE SERVICIOS")
						.descripcion(
								"No formalizar por escrito los contratos de prestación de servicios celebrados con las empresas usuarias, con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("698fd25f-26ce-433e-9cd4-3e5d9e5f44de").baseLegal("36")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("12f4f361-05b5-494a-b646-c1411bc0cc3c")
						.subMateria("CONTRATO DE PRESTACION DE SERVICIOS")
						.descripcion(
								"No formalizar por escrito el contrato de prestación de servicios celebrado con la empresa o entidad de intermediación laboral con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.4")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("a6404881-3651-4119-8a80-0952360a06a9").subMateria("REGISTRO")
						.descripcion(
								"Contratar a una empresa o entidad de intermediación laboral sin registro vigente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("a6404881-3651-4119-8a80-0952360a06a9").subMateria("REGISTRO")
						.descripcion(
								"No comunicar o presentar a la Autoridad competente, en los plazos y con los requisitos previstos, la información y documentación relacionada con el ejercicio de sus actividades como empresa o entidad de intermediación laboral, los contratos suscritos con los trabajadores destacados a la empresa usuaria y no registrar los contratos suscritos con las empresas usuarias.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("a6404881-3651-4119-8a80-0952360a06a9").subMateria("REGISTRO")
						.descripcion(
								"Ejercer actividades de intermediación laboral sin encontrarse registrado en el registro correspondiente, sin encontrarse éste vigente, en ámbitos para los que no se solicitó el registro o en supuestos prohibidos.Se considera intermediación laboral prohibida, la contratación por parte de la empresa principal, de servicios prestados por empresas contratistas o sub contratistas que desplacen personal para cumplir con su contrato, cuando se verifique en la inspección entre otras características, que estas empresas carecen de autonomía empresarial, no asumen las tareas contratadas por su cuenta y riesgo, no cuenten con sus propios recursos financieros, técnicos o materiales, y cuando sus trabajadores no estén bajo su exclusiva subordinación.Ante la constatación de una intermediación laboral no registrada o prohibida, o una simple provisión de personal, el personal desplazado deberá ser incorporado a la planilla de la empresa principal.En este caso, los inspectores verificarán la existencia del contrato con la empresa principal, su contenido, y condiciones de ejecución, pudiendo solicitar copia del contrato escrito entre la empresa principal con la contratista o subcontratista.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("a6404881-3651-4119-8a80-0952360a06a9").subMateria("REGISTRO")
						.descripcion(
								"El incumplimiento de las obligaciones relacionadas con la inscripción en el registro correspondiente, en los plazos y con los requisitos previstos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.6")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("a6404881-3651-4119-8a80-0952360a06a9").subMateria("REGISTRO")
						.descripcion("El registro fraudulento como empresa o entidad de intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.7")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("865f3a2e-12d6-4bcc-ba5d-f4f4ff66cdcb").subMateria("TERCERIZACIÓN")
						.descripcion(
								"Usar fraudulentamente la figura de tercerización laboral como sola provisión de personal, incumpliendo los requisitosindicados por el artículo 2 y 3 de la Ley Nº 29245, Ley que regula los servicios de tercerización")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.5")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("3774b468-1a71-428a-adcc-cbf698373138").subMateria("FRAUDE")
						.descripcion(
								"Proporcionar a la Autoridad competente información o documentación falsa relacionada con el ejercicio de sus actividades como empresa o entidad de intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.6")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("3774b468-1a71-428a-adcc-cbf698373138").subMateria("FRAUDE")
						.descripcion("El registro fraudulento como empresa o entidad de intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("3774b468-1a71-428a-adcc-cbf698373138").subMateria("FRAUDE")
						.descripcion(
								"Ejercer actividades de intermediación laboral sin encontrarse registrado en el registro correspondiente, sin encontrarse éste vigente, en ámbitos para los que no se solicitó el registro o en supuestos prohibidos.Se considera intermediación laboral prohibida, la contratación por parte de la empresa principal, de servicios prestados por empresas contratistas o sub contratistas que desplacen personal para cumplir con su contrato, cuando se verifique en la inspección entre otras características, que estas empresas carecen de autonomía empresarial, no asumen las tareas contratadas por su cuenta y riesgo, no cuenten con sus propios recursos financieros, técnicos o materiales, y cuando sus trabajadores no estén bajo su exclusiva subordinación.Ante la constatación de una intermediación laboral no registrada o prohibida, o una simple provisión de personal, el personal desplazado deberá ser incorporado a la planilla de la empresa principal.En este caso, los inspectores verificarán la existencia del contrato con la empresa principal, su contenido, y condiciones de ejecución, pudiendo solicitar copia del contrato escrito entre la empresa principal con la contratista o subcontratista.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.4")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("ba41626e-f4ec-454b-bbae-3524648c7297").subMateria("CONTRATO DE TRABAJO")
						.descripcion("No formalizar por escrito los contratos de trabajo con los trabajadores.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.3")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("HUELGA")
						.descripcion(
								"Utilizar la intermediación así como la contratación o subcontratación de obras o servicios con la intención o efecto de limitar o anular el ejercicio de los derechos colectivos de los trabajadores o sustituirlos en caso de huelga.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.4")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion(
								"Contratar a una empresa o entidad de intermediación laboral sin registro vigente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion("No prestar de manera exclusiva servicios de intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.6")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion("El registro fraudulento como empresa o entidad de intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion("La ocupación de trabajadores destacados en supuestos prohibidos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion(
								"Exceder los límites porcentuales y cualitativos aplicables a la intermediación laboral.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion(
								"No comunicar o presentar a la Autoridad competente, en los plazos y con los requisitos previstos, la información y documentación relacionada con el ejercicio de sus actividades como empresa o entidad de intermediación laboral, los contratos suscritos con los trabajadores destacados a la empresa usuaria y no registrar los contratos suscritos con las empresas usuarias.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.1")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("7bbb73e4-5c24-4e84-a2c8-80f9afc2c67f").subMateria("INTERMEDIACION LABORAL")
						.descripcion(
								"Ejercer actividades de intermediación laboral sin encontrarse registrado en el registro correspondiente, sin encontrarse éste vigente, en ámbitos para los que no se solicitó el registro o en supuestos prohibidos.Se considera intermediación laboral prohibida, la contratación por parte de la empresa principal, de servicios prestados por empresas contratistas o sub contratistas que desplacen personal para cumplir con su contrato, cuando se verifique en la inspección entre otras características, que estas empresas carecen de autonomía empresarial, no asumen las tareas contratadas por su cuenta y riesgo, no cuenten con sus propios recursos financieros, técnicos o materiales, y cuando sus trabajadores no estén bajo su exclusiva subordinación.Ante la constatación de una intermediación laboral no registrada o prohibida, o una simple provisión de personal, el personal desplazado deberá ser incorporado a la planilla de la empresa principal.En este caso, los inspectores verificarán la existencia del contrato con la empresa principal, su contenido, y condiciones de ejecución, pudiendo solicitar copia del contrato escrito entre la empresa principal con la contratista o subcontratista.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.3")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("b5250fd4-f6e4-4954-b214-6d18aa0dcd3c").subMateria("ESQUIROLAJE")
						.descripcion(
								"Utilizar la intermediación así como la contratación o subcontratación de obras o servicios con la intención o efecto de limitar o anular el ejercicio de los derechos colectivos de los trabajadores o sustituirlos en caso de huelga.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("d8cbd6ea-8ccd-43a8-9b5d-9dae3b86557f").baseLegal("34.4")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("2c1fedb8-fb08-4b66-8ef5-94ab10f3b769").subMateria("GARANTIAS")
						.descripcion(
								"No conceder la garantía de cumplimiento de las obligaciones laborales y de seguridad social de los trabajadores destacados a la empresa usuaria, en los plazos y con los requisitos previstos.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("c773b8cd-abb1-471d-9a22-a36a35973c6b").subMateria("DOCUMENTOS LABORALES")
						.descripcion(
								"No comunicar o presentar a la Autoridad competente, en los plazos y con los requisitos previstos, la información y documentación relacionada con el ejercicio de sus actividades como empresa o entidad de intermediación laboral, los contratos suscritos con los trabajadores destacados a la empresa usuaria y no registrar los contratos suscritos con las empresas usuarias.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("83aef2ba-c54d-41d7-a406-b5d2f9d9a307").baseLegal("37.3")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("c678086e-d8cc-491e-a211-3831482aef81").subMateria("CESION DE TRABAJADORES")
						.descripcion("La cesión a otras empresas de trabajadores destacados.").gravedad("MUY GRAVE")
						.puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("275e9d0e-5c75-4993-9864-d4d8a34aad88").baseLegal("33.2")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("8eb4aa2a-8876-452b-b8df-c867fe36c46f").subMateria("DEBER DE COMUNICACIÓN")
						.descripcion(
								"No comunicar o presentar a la Autoridad competente, en los plazos y con los requisitos previstos, la información y documentación relacionada con el ejercicio de sus actividades como empresa o entidad de intermediación laboral, los contratos suscritos con los trabajadores destacados a la empresa usuaria y no registrar los contratos suscritos con las empresas usuarias.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("664eb37f-f9eb-4e83-9d9a-49513df57f35").baseLegal("35")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("45e045bf-f5f3-4c05-a0fd-0d595acb18eb").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"El incumplimiento de obligaciones meramente formales o documentales, relativas a las empresas usuarias.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("54755744-8503-4937-9ea1-52e9000bd223").baseLegal("32")
						.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
						.idSubMateria("39b2af6b-3e15-49e6-b5ad-49794ebbac4c").subMateria("FORMALIDAD")
						.descripcion(
								"El incumplimiento de obligaciones meramente formales o documentales relativas a las empresas y entidades que realizan actividades de intermediación laboral.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44.1")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("88ef627b-452f-4352-97ce-d85726dc37a2").subMateria("DEBER DE INFORMACIÓN")
						.descripcion(
								"No informar a la Administradora de Fondos de Pensiones los casos de suspensión perfecta y del cese o retiro del trabajador")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44.2")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No entregar la planilla de pago de los aportes retenidos a la Administradora de Fondos de Pensiones o entidad financiera designada por ella, o no declarar la planilla de pago de los aportes retenidos en el Portal de Recaudación AFP NET de las Administradoras de Fondos de Pensiones, conforme a lo establecido en el artículo 50 del Decreto Supremo N°004-98-EF, o entregarla con informacion incompleta.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.2")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No efectuar el pago de todo o parte de los aportes al Sistema Privado de Pensiones efectivamente retenidos de los trabajadores afiliados en la oportunidad que corresponda.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.4")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No regularizar los aportes de un trabajador contratado como independiente que, por la condición de los servicios prestados, tiene la calidad de trabajador dependiente, en el correspondiente período, incluyendo los intereses por mora.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.3")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No regularizar los aportes adeudados a las Administradoras de Fondos de Pensiones, que hayan sido cotizados al Sistema Nacional de Pensiones, luego de la incorporación de sus trabajadores al Sistema Privado de Pensiones.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.5")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No declarar o no retener los aportes de los trabajadores al Sistema Privado de Pensiones al que este afiliado")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.5")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("a505bf60-3f1a-451c-aac1-7e9e39331bbe").subMateria("APORTES PREVISIONALES")
						.descripcion(
								"No efectuar el pago de los aportes voluntarios en la oportunidad correspondiente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.6")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("44e1272e-d52c-44e7-a542-42e3f775c6b4")
						.subMateria("DECLARACIONES EN SEGURIDAD SOCIAL")
						.descripcion(
								"Efectuar declaraciones o consignar datos falsos o inexactos en los documentos de cotización que ocasionen deducciones fraudulentas en las aportaciones al Sistema Privado de Pensiones.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.7")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("44e1272e-d52c-44e7-a542-42e3f775c6b4")
						.subMateria("DECLARACIONES EN SEGURIDAD SOCIAL")
						.descripcion(
								"No declarar o no cumplir con el pago, oportuno e íntegro, del monto retenido a los trabajadores por concepto de aporte al Fondo Complementario de Jubilación Minera, Metalúrgica y Siderúrgica, según lo establecido en la ley y el reglamento de la materia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("35fac6d0-2357-4eae-b550-d864ac12ab6c").subMateria("BOLETIN INFORMATIVO")
						.descripcion(
								"Constituyen infracciones graves la falta de inscripción o la inscripción extemporánea de trabajadores u otras personas respecto de las que exista la obligación de inscripción, en el régimen de seguridad social en salud o en el régimen de seguridad social en pensiones, sean éstos públicos o privados, incurriéndose en una infracción por cada trabajador afectado.Asimismo, constituye infracción grave que el empleador afilie al trabajador a alguno de los sistemas de pensiones, sin previamente haberle entregado el Boletín Informativo, o que habiéndolo entregado no respete los plazos señalados en el segundo párrafo del artículo 16 de la Ley Nº 28991.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44.3")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("35fac6d0-2357-4eae-b550-d864ac12ab6c").subMateria("BOLETIN INFORMATIVO")
						.descripcion(
								"Entregar al trabajador el 'Boletín Informativo' a que se refiere el articulo 15 de la Ley N° 28991 fuera del plazo establecido en el artículo 1 del Decreto Supremo N° 009-2008-TR")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.3")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("35fac6d0-2357-4eae-b550-d864ac12ab6c").subMateria("BOLETIN INFORMATIVO")
						.descripcion(
								"Afiliar al trabajador sin previamente haberle entregado el “Boletín Informativo” a que se refiere el artículo 15 de la LeyNº 28991, Ley de libre desafiliación informada, pensiones mínima y complementarias, y régimen especial de jubilaciónanticipada; o, en caso de habérselo entregado, no respetar los plazos señalados en el segundo párrafo del artículo 16 de lareferida ley para la afiliación del trabajador a un sistema pensionario.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.2")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("3a3bf064-d74f-433f-8bf7-0f9247a9d916").subMateria("PENSIONES")
						.descripcion(
								"No afiliarse como conductor de una micro empresa al Sistema de Pensiones Sociales, administrado por una Administradora de Fondos de Pensiones o la Oficina de Normalizacion Previsional, conforme a lo dispuesto por el articulo 66 del Decreto Supremo N° 013-2013 PRODUCE, Texto Unico Ordenado de la Ley de Impulso al Desarrollo Productivo y al Crecimiento Empresarial")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.1")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("3a3bf064-d74f-433f-8bf7-0f9247a9d916").subMateria("PENSIONES")
						.descripcion(
								"No dar de baja o dar de baja extemporánemente, en el sistema de seguridad en salud, a quien pierde la condicion de asegurado")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.4")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("3a3bf064-d74f-433f-8bf7-0f9247a9d916").subMateria("PENSIONES")
						.descripcion(
								"No afiliar al trabajador en el sistema de pensiones de su elección o en el que corresponde conforme a ley")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.3")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("3a3bf064-d74f-433f-8bf7-0f9247a9d916").subMateria("PENSIONES")
						.descripcion(
								"Afiliar al trabajador sin previamente haberle entregado el “Boletín Informativo” a que se refiere el artículo 15 de la LeyNº 28991, Ley de libre desafiliación informada, pensiones mínima y complementarias, y régimen especial de jubilaciónanticipada; o, en caso de habérselo entregado, no respetar los plazos señalados en el segundo párrafo del artículo 16 de lareferida ley para la afiliación del trabajador a un sistema pensionario.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.6")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("264b480e-eeef-4f8d-9c82-add7ffaeba9c").subMateria("JUBILACIÓN MINERA")
						.descripcion(
								"No retener a los trabajadores el monto por concepto de aporte al Fondo Complementario de Jubilación Minera, Metalúrgica y Siderúrgica, según lo establecido en la ley y el reglamento de la materia.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-A.7")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("264b480e-eeef-4f8d-9c82-add7ffaeba9c").subMateria("JUBILACIÓN MINERA")
						.descripcion(
								"No declarar el aporte a cargo del empleador al Fondo Complementario de Jubilación Minera, Metalúrgica y Siderúrgica, según lo establecido en la ley y el reglamento de la materia.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.8")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("264b480e-eeef-4f8d-9c82-add7ffaeba9c").subMateria("JUBILACIÓN MINERA")
						.descripcion(
								"No pagar o pagar de forma incompleta el aporte a cargo del empleador al Fondo Complementario de Jubilación Minera, Metalúrgica y Siderúrgica, según lo establecido en la ley y el reglamento de la materia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("83afe422-59a2-4d0e-a40b-3a2b59c62921").baseLegal("44-B.1")
						.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
						.idSubMateria("48fbbbe4-5f51-4ef9-8863-a5e53fc53b5c")
						.subMateria("INSCRIPCIÓN EN SEGURIDAD SOCIAL")
						.descripcion(
								"La falta de inscripción de trabajadores, u otras personas respecto de las que exista la obligación de inscripción, en el régimen de seguridad social en salud o en el régimen de seguridad social en pensiones, sean éstos públicos o privados, incurriéndose en una infracción por cada trabajador afectado.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("b17e3bb0-a231-4e73-a21b-c73ae02fbaaf").subMateria("VIH")
						.descripcion(
								"La publicidad y realización, por cualquier medio de difusión, de ofertas de empleo discrimitatorias, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("8a02c60d-d4b3-458a-8af5-9934160517db").baseLegal("30.4")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"No publicar en espacio público y visible el protocolo de contratación de conformidad con el literal o) del artículo 8 de las Normas Reglamentarias para el Funcionamiento de las Agencias Privadas de Empleo, aprobadas por Decreto Supremo Nº 020-2012-TR")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("8a02c60d-d4b3-458a-8af5-9934160517db").baseLegal("30.2")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"El incumplimiento de las agencias de empleo de las obligaciones relacionadas con la comunicación de la información relativa al ejercicio de sus actividades en el mercado de trabajo, con el contenido y en la forma y plazo establecidos.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("8a02c60d-d4b3-458a-8af5-9934160517db").baseLegal("30.1")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"El incumplimiento de las obligaciones relacionadas con la inscripción, en la forma y plazos establecidos, de las agencias de empleo, en el registro correspondiente.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.4")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"El registro fraudulento como micro o pequeña empresa, empresa promocional para personas con discapacidad o agencia de empleo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.6")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"Retener cualquier tipo de documento de identidad personal, nacional o extranjero, objetos personales, objetos de valor o similares, antecedentes penales, o cartas de recomendación por parte de las agencias privadas de empleo, de conformidad con las Normas Reglamentarias para el Funcionamiento de las Agencias Privadas de Empleo, aprobadas por Decreto Supremo Nº 020-2012-TR")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.5")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("AGENCIAS DE EMPLEO")
						.descripcion(
								"Exigir o requerir a los buscadores de empleo cualquier tipo de pago y/o cobro como consecuencia del servicio de colocación; así como condicionar la obtención del referido servicio a la adquisición de un bien o servicio, de conformidad con las Normas Reglamentarias para el Funcionamiento de las Agencias Privadas de Empleo, aprobadas por Decreto Supremo Nº 020-2012-TR.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("184927e0-988b-43b1-b767-1d9062085aeb").subMateria("OFERTA DE EMPLEO")
						.descripcion(
								"La publicidad y realización, por cualquier medio de difusión, de ofertas de empleo discrimitatorias, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("e8365ab7-4c05-43bb-adb2-9fcf9692c12a").subMateria("DISCRIMINACION")
						.descripcion(
								"La publicidad y realización, por cualquier medio de difusión, de ofertas de empleo discrimitatorias, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.4")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("37905d88-9ef1-4612-ac0e-d1a691a22e4f").subMateria("MYPE")
						.descripcion(
								"El registro fraudulento como micro o pequeña empresa, empresa promocional para personas con discapacidad o agencia de empleo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("a60acd9f-ead6-4bab-a2aa-0c56d7866cb7").baseLegal("29.2")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("37905d88-9ef1-4612-ac0e-d1a691a22e4f").subMateria("MYPE")
						.descripcion(
								"El incumplimiento de las obligaciones relacionadas con la inscripción, en los plazos y con los requisitos previstos, de las micro y pequeñas empresas y las empresas promocionales para personas con discapacidad, en su registro correspondiente.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.4")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("fe17b57e-2736-4eba-8965-bd4378fdfb18").subMateria("REGISTRO")
						.descripcion(
								"El registro fraudulento como micro o pequeña empresa, empresa promocional para personas con discapacidad o agencia de empleo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("a60acd9f-ead6-4bab-a2aa-0c56d7866cb7").baseLegal("29.1")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("fe17b57e-2736-4eba-8965-bd4378fdfb18").subMateria("REGISTRO")
						.descripcion(
								"El incumplimiento de las obligaciones de comunicación y registro ante la Autoridad competente, en los plazos y con los requisitos previstos, de la documentación o información exigida por las normas de empleo y colocación, siempre que no esté tipificada como infracción grave.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.1")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("fe17b57e-2736-4eba-8965-bd4378fdfb18").subMateria("REGISTRO")
						.descripcion(
								"Ejercer actividades en el mercado de trabajo de colocación de trabajadores con fines lucrativos sin encontrarse registrado en el registro correspondiente o sin encontrarse éste vigente.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("512dd90d-1c35-4705-9d81-90c2223522f8").subMateria("PERSONAS CON DISCAPACIDAD")
						.descripcion(
								"La publicidad y realización, por cualquier medio de difusión, de ofertas de empleo discrimitatorias, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("a60acd9f-ead6-4bab-a2aa-0c56d7866cb7").baseLegal("29.2")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("512dd90d-1c35-4705-9d81-90c2223522f8").subMateria("PERSONAS CON DISCAPACIDAD")
						.descripcion(
								"El incumplimiento de las obligaciones relacionadas con la inscripción, en los plazos y con los requisitos previstos, de las micro y pequeñas empresas y las empresas promocionales para personas con discapacidad, en su registro correspondiente.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("8a02c60d-d4b3-458a-8af5-9934160517db").baseLegal("30.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("512dd90d-1c35-4705-9d81-90c2223522f8").subMateria("PERSONAS CON DISCAPACIDAD")
						.descripcion(
								"El incumplimiento de las disposiciones relacionadas con la promoción y el empleo de las personas con discapacidad.")
						.gravedad("GRAVE").puntajeGravedad(2).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.4")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("512dd90d-1c35-4705-9d81-90c2223522f8").subMateria("PERSONAS CON DISCAPACIDAD")
						.descripcion(
								"El registro fraudulento como micro o pequeña empresa, empresa promocional para personas con discapacidad o agencia de empleo.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("a60acd9f-ead6-4bab-a2aa-0c56d7866cb7").baseLegal("29.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("df785c1c-0635-42ee-8588-3274cc787aff").subMateria("OBLIGACIONES FORMALES")
						.descripcion(
								"Cualquier otro incumplimiento que afecte obligaciones, meramente formales o documentales, en materia de empleo y colocación.")
						.gravedad("LEVE").puntajeGravedad(1).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.3")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("b418e421-171e-4b93-9f8b-f0d7378443e0").subMateria("LIBERTAD SINDICAL")
						.descripcion(
								"La publicidad y realización, por cualquier medio de difusión, de ofertas de empleo discrimitatorias, por motivo de origen, raza, color, sexo, edad, idioma, religión, opinión, ascendencia nacional, origen social, condición económica, ejercicio de la libertad sindical, discapacidad, portar el virus HIV o de cualquiera otra índole.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build(),
				Infraccion.builder().idArticulo("c39694ca-9313-4172-ba7b-cafb403438c3").baseLegal("31.2")
						.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
						.idSubMateria("621beaef-4dae-418f-b4e5-70f9ab4f010b").subMateria("TRABAJADORES MENORES DE EDAD")
						.descripcion(
								"Ejercer actividades en el mercado de trabajo de colocación de menores trabajadores, que sean contrarias a las disposiciones sobre la materia.")
						.gravedad("MUY GRAVE").puntajeGravedad(3).build()).forEach(infraccion -> {
							log.info("Infraccion Registrada {}", infraccionService.registrar(infraccion));
						});
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
			Arrays.asList(Etapa.builder().nroOrden(1).nombreEtapa("Investigacion").estado(true).build(),
					Etapa.builder().nroOrden(3).nombreEtapa("Sancionadora").estado(true).build(),
					Etapa.builder().nroOrden(2).nombreEtapa("Instruccion").estado(true).build(),
					Etapa.builder().nroOrden(4).nombreEtapa("Concluidos").estado(false).build()).forEach(etapa -> {
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
			for (int i = 23; i <= 46; i++) {
				articuloService.registrar(
						Articulo.builder().nroArticulo(String.valueOf(i)).nombreArticulo("Articulo nro " + i).build());
			}
		} else {
			articulos.forEach(articulo -> {
				articulo.setNombreArticulo("Articulo " + articulo.getNroArticulo());
				articuloService.modificar(articulo);
			});
		}
	}

	public void testJDBC() {
		inspectorJdbc.inspectores().forEach(item -> {
			log.info("Inspector {}", item);
			Inspector inspector = inspectorService.buscarPorNombre(item.getNombreInspector());
			if (inspector != null) {
				/**
				 * Inspector nuevoInspector =
				 * inspectorService.registrar(Inspector.builder().tipo("TRABAJO")
				 * .telefono(String.valueOf(numberRandomGenerator(900000000, 999999999)))
				 * .correo(generateCorreo(item.getNombreInspector())).nombreInspector(item.getNombreInspector())
				 * .identity(item.getIndex()).build());
				 **/
				inspector.setCorreo("");
				inspector.setTelefono("");
				Inspector updateInspector = inspectorService.modificar(inspector);
				log.info("Nuevo Inspector {}", updateInspector);
			} else {
				log.info("Inspector nuevito {}",
						inspectorService.registrar(Inspector.builder().identity(item.getIndex()).cargo("Inspector")
								.tipo("TRABAJO").nombreInspector(item.getNombreInspector()).estado(true).build()));
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
			Arrays.asList(
					SubMateria.builder().nombreSubMateria("Áreas de descanso")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Abandono").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Abandono").idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Accidente de trabajo")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Accidente de trabajo")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Accidente de trabajo")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Accidente mortal")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Accidente mortal")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Acto antisindical")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Acto de hostilidad")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Afiliacion sindical")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Agencias de empleo")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Agentes contaminantes")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Agentes fisicos, quimicos y biologicos")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Alimentación")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Aportes previsionales")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Asistente social")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Auditoria").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Beneficios sociales")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Boleta de pago")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Boletin informativo")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Capacitacion")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Capacitacion")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Centro de trabajo")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Centro de trabajo")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Cesion de trabajadores")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Comite de sst")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Comparecencia")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Condiciones de trabajo")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Condiciones de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Contratistas")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Contrato de prestacion de servicios")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Contrato de trabajador extranjero")
							.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Contrato de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Contrato de trabajo")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Contrato sujeto a modalidad")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Convenio").idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Convenio colectivo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Cts").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Cuadro de categorias y funciones")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Cuota sindical")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de colaboracion")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Deber de comunicación")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Deber de comunicación")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de comunicación")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de confidencialidad")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de información")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Deber de información")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Deber de informacion cts")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de informar")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de proteccion")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Deber de vigilancia")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Declaraciones en seguridad social")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Derecho de informacion")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Derecho preferencial de contratación")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Descanso vacacional")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Desnaturalizacion")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Discriminación remunerativa")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Discriminación")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Discriminación")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Documentos laborales")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Documentos laborales")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Embarazo").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Embarazo").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Enfermedad profesional")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Enfermedad profesional")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Entrega de contrato de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Entrega del rit")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Equipos de proteccion personal")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Esquirolaje")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Esquirolaje")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Evacuacion")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Evaluacion de riegos")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Evaluacion medica")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Exámenes médicos")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Formación").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Formalidad")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Fraude").idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Fraude").idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Fraude").idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Fraude").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Fuero sindical")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Garantias").idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Higiene").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Horario de trabajo")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Hostigamiento sexual")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Huelga").idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Huelga").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Inasistencia")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Incendios").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Incidente").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Industria de alto riesgo")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Informacion boleta de pago y liquidaciones")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Informacion economica financiera")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Informacion planilla de pago")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Inscripción en seguridad social")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Inscripcion y registro renocc")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Intermediación laboral")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Intermediación laboral")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Ius variandi")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Jornada de trabajo")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Jornada de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Jubilación minera")
							.idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Lactancia").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Lactancia").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Lactario").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Laudo arbitral")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Libertad sindical")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Libertad sindical")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Libertad sindical")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Licencias").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Limites de contratacion")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Limites de contratacion")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Limites de contratacion")
							.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Limites de contratacion modalidad formativa")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Liquidacion de cts")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Liquidacion de utilidades")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Madre trabajadora")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Medida de requerimiento")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Medidas de prevención")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Medidas de prevención")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Medidas preventivas")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Modalidad formativa")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Mype").idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Negativa de identificacion")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Negociacion colectiva")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("No especifica")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("bc3b4852-bc08-4f97-b9bb-eb84f1412301").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Obligaciones formales")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Obstruccion a la labor inspectiva")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Obstruccion a la labor inspectiva coaccion")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Oferta de empleo")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Orden y limpieza")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Otros documentos laborales")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Paralizacion de labores")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Paralizacion de labores")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Participacion de trabajadores")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Pensiones").idMateria("de233a3f-108d-431b-9983-5f4ea75a07ab")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Personas con dicapacidad")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Personas con discapacidad")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Personas con discapacidad")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Plame").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Plan de formalizacion")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Plan de sst")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Planilla de pago")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Pliego de reclamos")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Politica salarial")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Prestaciones alimentarias")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Prevencion de riesgos")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Primeros auxilios")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Programa de sst")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Publicacion del horario de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Publicidad de infraccion")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Refrigerio")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro").idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro").idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
							.prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Registro").idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro de asistencia")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro de control de asistencia")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro del contrato de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder()
							.nombreSubMateria(
									"Registro nacional de empresas administradoras y empresas proveedoras de alimentos")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro nacional de trabajadores de construccion civil")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Registro sst")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Reglamento interno de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Relaciones industriales")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Remuneracion")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Remuneracion minima vital")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Retiro de bienes")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Reversion").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Riesgos ergonomicos")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Riesgos laborales")
							.idMateria("b4a4ead4-82c7-4ec5-8e01-af7ba045be61").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Riesgos laborales")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Sctr").idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Seguro de salud")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(true).build(),
					SubMateria.builder().nombreSubMateria("Seguro vida ley")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Sintesis de la legislacion laboral")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Sistema de gestion de sst")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Sobretiempo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Sst contratistas")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Subvencion")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Teletrabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Tercerización")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Tercerización")
							.idMateria("c2df4fe8-dd5d-4300-a1a7-13355cbd0fa2").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Tiempo de trabajo")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Tiempo de trabajo")
							.idMateria("15d4a5df-8935-4d14-b85d-7454e8f3cb86").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajador del hogar")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajadora gestante")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajadores del regimen pesquero")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajadores menores de edad")
							.idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajo agrario")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajo de menores de edad")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajo de menores de edad")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajo forzoso")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trabajo nocturno")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Trata de personas")
							.idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Vigilancia de la salud")
							.idMateria("6dc1f7b3-8962-4077-a49d-11eb15628a0c").prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Vih").idMateria("a2a34d38-f6d8-4223-8871-d98490c2a66e")
							.prioridad(false).build(),
					SubMateria.builder().nombreSubMateria("Vih").idMateria("edbb77e7-2a9b-4d39-be9b-17bb6dd50c2c")
							.prioridad(true).build()

			).forEach(subMateria -> {
				log.info("Nueva SubMateria {}", subMateriaService.registrar(subMateria));
			});
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
		 * "Intendencia Regional de Ucayali", true)).forEach(item -> {
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
