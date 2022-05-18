package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class ContractSamiCreateRequest implements Serializable {

	private static final long serialVersionUID = -6846516224123732876L;

	@NotNull
	@NotEmpty
	private String fileName;
	
	@NotNull
	@NotEmpty
	private String fileNameAux;

	@NotNull
	@NotEmpty
	private String description;
	
	@NotNull
	private Integer size;
	
	@NotNull
	@NotEmpty
	private String type;
	
	@NotNull
	@NotEmpty
	private String userName;

}
