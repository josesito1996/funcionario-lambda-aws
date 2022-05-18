package com.javatechie.aws.lambda.domain.request;

import java.io.Serializable;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Builder
@Getter
@Setter
@ToString
public class MultaUitParams implements Serializable {

  private static final long serialVersionUID = -2224686706812169797L;

  @NotNull
  @NotEmpty
  @Schema(title = "Tipo Empresa", name = "tipoEmpresa", example = "MICRO EMPRESA")
  private String tipoEmpresa;

  @NotNull
  @NotEmpty
  @Schema(title = "Tipo Infraccion", name = "tipoInfraccion", example = "MUY GRAVE")
  private String tipoInfraccion;

  @NotNull
  @Min(value = 1, message = "Minimo 1 trabajador")
  @Schema(title = "Cantidad trabajadores", name = "cantidadTrabajadores", example = "28")
  private Integer cantidadTrabajadores;

}
