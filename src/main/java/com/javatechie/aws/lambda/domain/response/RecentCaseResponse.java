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
public class RecentCaseResponse implements Serializable {

    private static final long serialVersionUID = 5932009718057599868L;

    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Date", name = "date", example = "2020-12-21")
    private String date;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Inspection Order", name = "inspectionOrder", example = "0000003578-2020-SUNAFIL/IRE-AQP")
    private String inspectionOrder;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Case Name", name = "caseName", example = "INCA TOPS S.A.")
    private String caseName;
}
