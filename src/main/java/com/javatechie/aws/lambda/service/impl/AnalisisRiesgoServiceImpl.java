package com.javatechie.aws.lambda.service.impl;

import static com.javatechie.aws.lambda.util.ListUtils.transformFromReactSelect;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.javatechie.aws.lambda.aws.CasoPojo;
import com.javatechie.aws.lambda.aws.ExternalDbAws;
import com.javatechie.aws.lambda.domain.AnalisisRiesgo;
import com.javatechie.aws.lambda.domain.AnalisisRiesgoTableResponse;
import com.javatechie.aws.lambda.domain.InfraccionItem;
import com.javatechie.aws.lambda.domain.ReactSelect;
import com.javatechie.aws.lambda.domain.dto.AnalisisRiesgoDto;
import com.javatechie.aws.lambda.domain.request.InfraccionAnalisisRequest;
import com.javatechie.aws.lambda.domain.request.InfraccionItemRequest;
import com.javatechie.aws.lambda.domain.response.AnalisisRiesgoDetalle;
import com.javatechie.aws.lambda.domain.response.HistorialAnalisisResponse;
import com.javatechie.aws.lambda.domain.response.chart.BarChartResponse;
import com.javatechie.aws.lambda.domain.response.chart.SeriesResponse;
import com.javatechie.aws.lambda.exception.BadRequestException;
import com.javatechie.aws.lambda.exception.NotFoundException;
import com.javatechie.aws.lambda.respository.GenericRepo;
import com.javatechie.aws.lambda.respository.RepoAnalisisRiesgo;
import com.javatechie.aws.lambda.service.AnalisisRiesgoService;
import com.javatechie.aws.lambda.util.Utils;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnalisisRiesgoServiceImpl extends CrudImpl<AnalisisRiesgo, String> implements AnalisisRiesgoService {

	@Autowired
	private RepoAnalisisRiesgo repo;

	@Autowired
	private ExternalDbAws external;

	@Override
	protected GenericRepo<AnalisisRiesgo, String> getRepo() {
		return repo;
	}

	@Transactional
	@Override
	public Map<String, Object> registrarAnalisisRiesgo(InfraccionAnalisisRequest request) {
		log.info("AnalisisRiesgoServiceImpl.registrarAnalisisRiesgo");
		if (external.getTable(request.getIdCaso()).isEmpty()) {
			throw new NotFoundException("No existe Caso relacionado al ID : " + request.getIdCaso());
		}
		// AnalisisRiesgo getAnalisis = buscarPorId(request.getIdCaso());
		// if (getAnalisis.getIdAnalisis() != null) {
		// throw new BadRequestException("Ya existe un registro con este ID");
		// }
		AnalisisRiesgo analisisRiesgo = transformAnalisisRiesgo(request);
		analisisRiesgo.setSumaMultaPotencial(
				analisisRiesgo.getInfracciones().stream().mapToDouble(item -> item.getMultaPotencial()).sum());
		analisisRiesgo.setSumaProvision(
				analisisRiesgo.getInfracciones().stream().mapToDouble(item -> item.getProvision()).sum());
		AnalisisRiesgo newRow = registrar(analisisRiesgo);
		if (newRow.getIdAnalisis() != null) {
			Map<String, Object> newMap = new HashMap<String, Object>();
			newMap.put("ID", newRow.getIdAnalisis());
			return newMap;
		}
		return new HashMap<String, Object>();
	}

	/**
	 * Pasar a un clase Aparte
	 */
	private AnalisisRiesgo transformAnalisisRiesgo(InfraccionAnalisisRequest request) {
		return AnalisisRiesgo.builder().idCaso(request.getIdCaso())
				.origenCaso(ReactSelect.builder().label(request.getOrigenCaso().getLabel())
						.value(request.getOrigenCaso().getValue()).build())
				.nombreAsesor(request.getNameAsesor()).infracciones(transformInfraccionItems(request.getInfractions()))
				.nivelRiesgo(ReactSelect.builder().label(request.getNivelRiesgo().getLabel())
						.value(request.getNivelRiesgo().getValue()).build())
				.cantidadInvolucrados(request.getCantInvolucrados()).fechaRegistro(LocalDate.now()).build();
	}

	private List<InfraccionItem> transformInfraccionItems(List<InfraccionItemRequest> requests) {
		return requests.stream().map(this::transformInfraccionItem).collect(Collectors.toList());
	}

	private InfraccionItem transformInfraccionItem(InfraccionItemRequest request) {
		return InfraccionItem.builder()
				.materia(ReactSelect.builder().label(request.getMateria().getLabel())
						.value(request.getMateria().getValue()).build())
				.subMaterias(ReactSelect.builder().value(request.getSelectSubmateria().getValue())
						.label(request.getSelectSubmateria().getLabel()).build())
				.baseLegal(ReactSelect.builder().value(request.getSelectBaseLegal().getValue())
						.label(request.getSelectBaseLegal().getLabel())
						.campoAux(request.getSelectBaseLegal().getCampoAux()).build())
				.gravedad(request.getGravedad()).provision(request.getProvision()).descripcion(request.getDescripcion())
				.trabajadoresAfectados(request.getAfectados()).uitMultaPotencial(request.getUitMultaPotencial())
				.multaPotencial(request.getMultaPotencial()).build();
	}

	@Override
	public AnalisisRiesgo buscarPorId(String id) {
		Optional<AnalisisRiesgo> optional = verPorId(id);
		if (!optional.isPresent()) {
			throw new NotFoundException("No existe Registro relacionado al ID : " + id);
		}
		return optional.get();
	}

	@Override
	public InfraccionAnalisisRequest verPorIdAnalisis(String idAnalisis) {
		AnalisisRiesgo analisis = listarPorIdCaso(idAnalisis).stream().reduce((first,second)-> second).orElse(AnalisisRiesgo.builder().build());
		if (analisis.getIdAnalisis() == null) {
			throw new BadRequestException("Caso con el ID " + idAnalisis + " no existe");
		}
		ReactSelect origenCaso = analisis.getOrigenCaso();
		List<InfraccionItem> infracciones = analisis.getInfracciones();
		return InfraccionAnalisisRequest.builder().origenCaso(transformFromReactSelect(origenCaso))
				.nameAsesor(analisis.getNombreAsesor()).infractions(infracciones.stream().map(item -> {
					return InfraccionItemRequest.builder().materia(transformFromReactSelect(item.getMateria()))
							.selectSubmateria(transformFromReactSelect(item.getSubMaterias()))
							.selectBaseLegal(transformFromReactSelect(item.getBaseLegal())).gravedad(item.getGravedad())
							.provision(item.getProvision()).descripcion(item.getDescripcion())
							.afectados(item.getTrabajadoresAfectados()).uitMultaPotencial(item.getUitMultaPotencial())
							.multaPotencial(item.getMultaPotencial()).build();
				}).collect(Collectors.toList())).nivelRiesgo(transformFromReactSelect(analisis.getNivelRiesgo()))
				.cantInvolucrados(analisis.getCantidadInvolucrados()).idCaso(idAnalisis).build();
	}

	@Override
	public List<AnalisisRiesgo> listarPorIdCaso(String idCaso) {
		return repo.findByIdCaso(idCaso);
	}

	@Override
	public AnalisisRiesgoDetalle verPorIdCaso(String idCaso) {
		CasoPojo caso = external.tableCaso(idCaso);
		if (caso.getId() == null) {
			throw new BadRequestException("Caso con el ID " + idCaso + " no existe");
		}
		List<AnalisisRiesgo> analisis = listarPorIdCaso(idCaso).stream()
				.sorted(Comparator.comparing(AnalisisRiesgo::getFechaRegistro))
				.collect(Collectors.toList());
		List<AnalisisRiesgoDto> analisisDto = analisis.stream()
				.map(item -> {
					return AnalisisRiesgoDto.builder().idAnalisis(item.getIdAnalisis()).idCaso(item.getIdCaso())
							.sumaMultaPotencial(item.getSumaMultaPotencial()).sumaProvision(item.getSumaProvision())
							.fecha(Utils.fechaFormateadaMes(item.getFechaRegistro())).build();
				}).collect(Collectors.toList());

		List<SeriesResponse> series = new ArrayList<>();
		Map<String, Double> mapMultaPotencial = analisisDto.stream().collect(Collectors.groupingBy(
				AnalisisRiesgoDto::getFecha, Collectors.summingDouble(item -> item.getSumaMultaPotencial())));
		Map<String, Double> mapProvisiones = analisisDto.stream().collect(Collectors
				.groupingBy(AnalisisRiesgoDto::getFecha, Collectors.summingDouble(item -> item.getSumaProvision())));

		series.add(SeriesResponse.builder().data(mapMultaPotencial.entrySet().stream()
				.map(item -> item.getValue().intValue()).collect(Collectors.toList())).build());
		series.add(SeriesResponse.builder().data(
				mapProvisiones.entrySet().stream().map(item -> item.getValue().intValue()).collect(Collectors.toList()))
				.build());
		List<String> meses = analisisDto.stream().map(item -> item.getFecha()).distinct()
				.collect(Collectors.toList());
		log.info("Meses {}",meses);
		return AnalisisRiesgoDetalle.builder().nombreCaso(caso.getDescripcionCaso())
				.nroOrdenInspeccion(caso.getOrdenInspeccion())
				.barChart(BarChartResponse.builder()
						.items(meses)
						.totales(series).build())
				.totalMultaPotencial(mapMultaPotencial.entrySet().stream().mapToDouble(Entry::getValue).sum())
				.totalProvision(mapProvisiones.entrySet().stream().mapToDouble(Entry::getValue).sum())
				.historial(analisis.stream().sorted(Comparator.comparing(AnalisisRiesgo::getFechaRegistro).reversed()).map(item -> {
					return HistorialAnalisisResponse.builder()
							.fecha(Utils
									.fechaFormateadaOther(LocalDateTime.of(item.getFechaRegistro(), LocalTime.now())))
							.table(item.getInfracciones().stream().map(element -> {
								return AnalisisRiesgoTableResponse.builder()
										.materia(element.getMateria().getLabel())
										.subMateria(element.getSubMaterias().getLabel())
										.baseLegal(element.getBaseLegal().getCampoAux())
										.trabajadoresAfectados(element.getTrabajadoresAfectados())
										.gravedad(item.getNivelRiesgo().getLabel())
										.uitsMulta(element.getUitMultaPotencial())
										.multaPotencial(element.getMultaPotencial())
										.provision(element.getProvision())
										.descripcion(element.getDescripcion())
										.build();
							}).collect(Collectors.toList())).build();
				}).collect(Collectors.toList())).build();
	}
}
