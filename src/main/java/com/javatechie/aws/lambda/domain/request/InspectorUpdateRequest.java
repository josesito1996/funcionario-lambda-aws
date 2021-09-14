package com.javatechie.aws.lambda.domain.request;

import static com.javatechie.aws.lambda.util.Constants.REGEX_EMAIL;
import static com.javatechie.aws.lambda.util.Constants.REGEX_UUID;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

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
    private String idInspector;

    @NotNull
    @NotEmpty
    @Pattern(regexp = REGEX_EMAIL, message = "Tiene formato no valido")
    private String correo;
    
    @NotNull
    @NotEmpty
    @Size(min = 1)
    private String nombreCargo;

    @NotNull
    @NotEmpty
    @Size(min = 7)
    private String telefono;
}
