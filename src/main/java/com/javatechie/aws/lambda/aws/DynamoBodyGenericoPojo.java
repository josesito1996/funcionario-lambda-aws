package com.javatechie.aws.lambda.aws;

import java.io.Serializable;

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
public class DynamoBodyGenericoPojo implements Serializable {

    private static final long serialVersionUID = 5927367649659462589L;

    private String value;

    private String label;

    private String campoAux;

}
