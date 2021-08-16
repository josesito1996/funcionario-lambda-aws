package com.javatechie.aws.lambda.aws;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.amazonaws.services.dynamodbv2.document.spec.GetItemSpec;

@Service
public class ExternalDbAws {

    @Autowired
    private DynamoDB dynamoDB;

    public Map<String, Object> getTable(String idCaso) {
        Table tableCasos = dynamoDB.getTable("casos");
        GetItemSpec spec = new GetItemSpec().withPrimaryKey("id_caso", idCaso);
        Item casoItem = tableCasos.getItem(spec);
        return casoItem.asMap();
    }

}
