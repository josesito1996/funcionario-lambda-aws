package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;

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
public class CaseByInspectorResponse implements Serializable {
    
    private static final long serialVersionUID = -6365568019613633921L;
    
    @JsonInclude(Include.NON_NULL)
    private String idInspector;
    
    @Schema(title = "Tiene casos", name = "hasDataContact", example = "true")
    @JsonInclude(Include.NON_NULL)
    private boolean hasDataContact;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Name", name = "name", example = "Nakandakari Huaman Maritza Cindy", description = "Nombre del inspector")
    private String name;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Position", name = "position", example = "Inspector", description = "Cargo del inspector")
    private String position;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Cases Found", name = "casesFound", example = "6", description = "Cantidad de casos que tiene el inspector")
    private int casesFound;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Fine Cases", name = "fineCases", example = "0", description = "Cantidad de casos con multa que tiene el inspector")
    private int fineCases;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Contact", name = "contact")
    private ContactResponse contact;
    
    @JsonInclude(Include.NON_NULL)
    private List<ScoreResponse> score;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Recent cases", name = "recentCases")
    private List<RecentCaseResponse> recentCases;
    
    @JsonInclude(Include.NON_NULL)
    private List<ComentarioResponse> comments;
}

