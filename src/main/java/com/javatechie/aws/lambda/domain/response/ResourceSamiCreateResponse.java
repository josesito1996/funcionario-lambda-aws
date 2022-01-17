package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

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
	
	private String description;
	
	private String base64;
	
	private LocalDateTime upLoadDate;
	
	private String type;
	
	private Boolean esUtil;
	
	private Boolean esFavorito;
}
