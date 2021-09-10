package com.javatechie.aws.lambda.domain.response;

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
public class RecentCaseResponse {
    @JsonInclude(Include.NON_NULL)
    private String date;
    
    @JsonInclude(Include.NON_NULL)
    private String inspectionOrder;
    
    @JsonInclude(Include.NON_NULL)
    private String caseName;
}
