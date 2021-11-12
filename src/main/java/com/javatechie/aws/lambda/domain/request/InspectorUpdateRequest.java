package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_EMAIL;
import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
public class InspectorUpdateRequest implements Serializable {
    
    private static final long serialVersionUID = -6031111855844417275L;

    @NotNull
    @NotEmpty
    @Pattern(regexp = REGEX_UUID, message = "Tiene un formato invalido")
    @Schema(title = "Id Inspector", name = "idInspector", example = "4ad3688c-c76e-4e8f-b44d-881b89298cc7")
    private String idInspector;

    @NotNull
    @NotEmpty
    @Pattern(regexp = REGEX_EMAIL, message = "Tiene formato no valido")
    @Schema(title = "Correo", name = "correo", example = "yauriguerraanalipaola@gmail.com")
    private String correo;
    
    @NotNull
    @NotEmpty
    @Size(min = 1)
    @Schema(title = "Nombre cargo", name = "nombreCargo", example = "Inspector")
    private String nombreCargo;

    @NotNull
    @NotEmpty
    @Size(min = 7)
    @Schema(title = "Telefono", name = "telefono", example = "937380399")
    private String telefono;
}
