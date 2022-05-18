package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_EMAIL;
import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
public class CompraInsightRequest implements Serializable {
    private static final long serialVersionUID = -7763021557146881720L;

    @NotNull
    @NotEmpty
    @Pattern(regexp = REGEX_UUID, message = "Formato incorrecto")
    @Schema(title = "Id Insight", name = "idInsight", required = true, pattern = REGEX_UUID, example = "123e4567-e89b-12d3-a456-556642440000")
    private String idInsight;

    @NotNull
    @NotEmpty
    @Schema(title = "Numero telefono", name = "celular", required = true, example = "962508776")
    private String celular;

    @Schema(title = "Titulo", name = "titulo", example = "Titulo Insight")
    private String titulo;

    @Schema(title = "Consulta", name = "consulta", example = "--", description = "Datos ingresados por el cliente, que desea consultar sobre una funcionalidad de SAMI")
    private String consulta;

    @NotNull
    @NotEmpty
    @Pattern(regexp = REGEX_EMAIL, message = "Formato incorrecto")
    @Schema(title = "Nombre Usuario", name = "nombreUsuario", example = "campos@gmail.com", required = true, description = "Correo del usuario que va solicitar el servicio")
    private String nombreUsuario;
}
