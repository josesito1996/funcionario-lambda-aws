package com.javatechie.aws.lambda.domain.response.custom;

import java.io.Serializable;
import java.util.List;

import com.javatechie.aws.lambda.domain.response.ReactSelectResponse;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Builder
@NoArgsConstructor
@Setter
public class CustomSelectResponse implements Serializable {
    
    private static final long serialVersionUID = -4281379982881166564L;

    @Schema(title = "Base Legal", example = "[]")
    List<ReactSelectResponse> baseLegal;

    @Schema(title = "Resto de bases legales", example = "[]")
    List<ReactSelectResponse> restoBaseLegal;

}
