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
public class ResourceSamiChangeRequest implements Serializable {

	private static final long serialVersionUID = 401217336783194933L;

	@NotNull
	@NotEmpty
	@Pattern(regexp = REGEX_UUID)
	private String id;
	
	private Boolean isUtil;
	
	private Boolean isFavorite;
	
	private Boolean isRemoved;
	
}
