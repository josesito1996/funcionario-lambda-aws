package com.javatechie.aws.lambda.aws;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBDocument;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@DynamoDBDocument
@Getter
@NoArgsConstructor
@Setter
@ToString
public class ActuacionPojo {

	@JsonProperty("id_actuacion")
	private String idActuacion;
	
	private String fechaActuacion;
	
	private String fechaRegistro;
	
	private String descripcion;
	
    private String descripcionAux;
	
	// private List<FuncionarioDto> funcionario;
	
	private TipoActuacionPojo tipoActuacion;
	
	private EtapaDto etapa;
	
	private EstadoCasoPojo estadoCaso;
	
	// private List<ArchivoAdjunto> archivos;
	
	// private List<Tarea> tareas;
}
