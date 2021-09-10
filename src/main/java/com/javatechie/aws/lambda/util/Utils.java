package com.javatechie.aws.lambda.util;

import java.sql.Date;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Random;

public class Utils {

    public static int numberRandomGenerator(int min, int max) {
        return new Random().nextInt(max - min) + min;
    }

    public static String generateCorreo(String name) {
        return name.replaceAll(" ", "").toLowerCase().concat("@gmail.com");
    }

    public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
        return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    }

    public static String separadorDeCadenas(String cadena, String caracter, int index) {
        if (cadena != null) {
            if (!cadena.isEmpty()) {
                String[] array = cadena.split(caracter);
                if (array != null) {
                    if (index < array.length) {
                        return array[index];
                    }
                }
            }
        }
        return "";
    }

}
