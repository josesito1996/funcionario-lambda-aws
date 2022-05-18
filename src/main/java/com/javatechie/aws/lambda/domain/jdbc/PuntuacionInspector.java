package com.javatechie.aws.lambda.domain.jdbc;

import java.io.Serializable;
import java.time.LocalDateTime;

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
public class PuntuacionInspector implements Serializable {

    private static final long serialVersionUID = -5765408340354843325L;

    private Integer idPuntuacionInspector;
    
    private String userName;
    
    private LocalDateTime fechaRegistro;
   
    private String idInspector;
    
    private Integer idPuntuacionMaestro;
    
    private Integer calificacion;
   
}
