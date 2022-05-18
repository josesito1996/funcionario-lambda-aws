package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;
import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class ComentarioInspectorCreateRequestBody implements Serializable {

	private static final long serialVersionUID = 1095388141908137193L;

	@NotEmpty
	@NotNull
	private String usuario;
	
	@NotEmpty
	@NotNull
	@Pattern(regexp = REGEX_UUID)
	private String idFuncionario;
	
	@NotEmpty
	@NotNull
	private String comentario;
	
	@NotNull
	private Integer puntuacion;
	
}
