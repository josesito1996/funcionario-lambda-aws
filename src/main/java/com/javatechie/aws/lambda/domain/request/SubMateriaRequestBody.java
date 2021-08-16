package com.javatechie.aws.lambda.domain.request;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class SubMateriaRequestBody {

    @JsonProperty("id_caso")
    private String idCaso;
    
    @Size(min = 1, message = "Minimo un elemento")
    private List<String> ids;

}
