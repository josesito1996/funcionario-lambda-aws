package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class ResourceSamiCreateResponse implements Serializable {

	private static final long serialVersionUID = -4069053151723105294L;

	private String idFile;
	
	private String nombreArchivo;
	
	@JsonInclude(Include.NON_NULL)
	private String categoria;
	
	@JsonInclude(Include.NON_NULL)
	private String description;
	
	@JsonInclude(Include.NON_NULL)
	private String base64;
	
	@JsonInclude(Include.NON_NULL)
	private String upLoadDate;
	
	@JsonInclude(Include.NON_NULL)
	private String type;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean esUtil;
	
	@JsonInclude(Include.NON_NULL)
	private Boolean esFavorito;
}
