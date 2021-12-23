package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
public class ScoreResponse implements Serializable {

    private static final long serialVersionUID = -1967923227360022119L;

    private Integer idItem;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Item Score", name = "itemScore", example = "2")
    private String itemScore;

    private int max;

    private int score;

}
