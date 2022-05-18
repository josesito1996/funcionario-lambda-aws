package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.javatechie.aws.lambda.util.Constants;

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
public class ResourceSendFileMailRequest implements Serializable {

	private static final long serialVersionUID = 532983844475799832L;

	@NotNull
	@NotEmpty
	@Pattern(regexp = Constants.REGEX_UUID)
	private String idFile;
	
	@NotNull
	@NotEmpty
	@Pattern(regexp = Constants.REGEX_EMAIL)
	private String destinatario;
	
	private String mensaje;
	
}
