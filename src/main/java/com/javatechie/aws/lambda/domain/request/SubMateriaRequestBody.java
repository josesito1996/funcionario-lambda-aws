package com.javatechie.aws.lambda.domain.request;

import java.util.List;

import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
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
    @Schema(title = "Id Caso", name = "id_caso", example = "bf6468dc-fd8a-4ff8-b4f8-2fa188a1e36d")
    private String idCaso;
    
    @Size(min = 1, message = "Minimo un elemento")
    private List<String> ids;

}
