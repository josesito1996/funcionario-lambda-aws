package com.javatechie.aws.lambda.domain.response;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

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
    
    private boolean hasDataContact;
    
    @JsonInclude(Include.NON_NULL)
    private String name;
    
    @JsonInclude(Include.NON_NULL)
    private String position;
    
    private int casesFound;
    
    private int fineCases;
    
    @JsonInclude(Include.NON_NULL)
    private ContactResponse contact;
    
    private List<ScoreResponse> score;
    
    private List<RecentCaseResponse> recentCases;
}

