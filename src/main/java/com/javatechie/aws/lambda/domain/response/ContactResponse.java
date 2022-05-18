package com.javatechie.aws.lambda.domain.response;

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
public class ContactResponse {
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Phone", name = "phone", example = "966753699", description = "Nro de telefono del inspector")
    private String phone;
    
    @JsonInclude(Include.NON_NULL)
    @Schema(title = "Email", name = "email", example = "nakandakarihuamanmaritzacindy@gmail.com", description = "Correo electronico del inspector")
    private String email;
}
