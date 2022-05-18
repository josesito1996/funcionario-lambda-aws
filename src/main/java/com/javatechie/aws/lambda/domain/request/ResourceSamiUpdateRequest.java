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
public class ResourceSamiUpdateRequest implements Serializable {

	private static final long serialVersionUID = -6846516224123732876L;

	@NotNull
	@NotEmpty
	@Pattern(regexp = Constants.REGEX_UUID)
	private String id;
	
	@NotNull
	@NotEmpty
	private String url;

}
