package com.javatechie.aws.lambda.domain.response.custom;

import java.io.Serializable;
import java.util.List;

import com.javatechie.aws.lambda.domain.response.ResourceSamiCreateResponse;

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
public class ResourceGroupResponse implements Serializable {
	
	private static final long serialVersionUID = 2060963769521522836L;

	private String category;
	
	private List<ResourceSamiCreateResponse> items;
	
}
