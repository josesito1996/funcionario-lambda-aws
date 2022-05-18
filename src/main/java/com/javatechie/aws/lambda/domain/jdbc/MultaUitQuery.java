package com.javatechie.aws.lambda.domain.jdbc;

import java.io.Serializable;

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
public class MultaUitQuery implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 773180466500930399L;
  
  @JsonInclude(Include.NON_NULL)
  private String tipoEmpresa;
  
  @JsonInclude(Include.NON_NULL)
  private String tipoInfraccion;
  
  @JsonInclude(Include.NON_NULL)
  private Double monto;
  
  @JsonInclude(Include.NON_NULL)
  private Double montoUit;
  
  @JsonInclude(Include.NON_NULL)
  private Integer cantidadTrabajadores;
  
  @JsonInclude(Include.NON_NULL)
  private Double montoMulta;
}
