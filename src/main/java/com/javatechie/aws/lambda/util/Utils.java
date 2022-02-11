package com.javatechie.aws.lambda.util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class Utils {

	public static int numberRandomGenerator(int min, int max) {
		return new Random().nextInt(max - min) + min;
	}

	public static String generateCorreo(String name) {
		return name.replaceAll(" ", "").toLowerCase().concat("@gmail.com");
	}

	public static LocalDateTime convertToLocalDateTime(String dateTime) {
		return LocalDateTime.parse(dateTime);
	}

	public static String fechaFormateadaOther(LocalDateTime fecha) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String fechaFormateada = fecha.format(formatter);
		return fechaFormateada;
	}

	public static LocalDate convertToLocalDateViaInstant(Date dateToConvert) {
		return dateToConvert.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	}

	public static Date convertToDateViaInstant(LocalDate dateToConvert) {
		return Date.from(dateToConvert.atStartOfDay().atZone(ZoneId.systemDefault()).toInstant());
	}

	public static Date convertToDateViaInstant(LocalDateTime dateToConvert) {
		return Date.from(dateToConvert.atZone(ZoneId.systemDefault()).toInstant());
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

	/**
	 * Metoddo que convierte primera letra del texto en mayuscula.
	 * 
	 * @param texto
	 * @return
	 */
	public static String primeraLetraMayuscula(String texto) {
		char[] arr = texto.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			if (i == 0) {
				arr[0] = Character.toUpperCase(arr[0]);
			} else {
				arr[i] = Character.toLowerCase(arr[i]);
			}
		}
		return new String(arr);
	}

	public static String convertirNumeroAMes(Integer numeroMes) {
		Locale locale = new Locale("es", "ES");
		Month mes = Month.of(numeroMes);
		return mes.getDisplayName(TextStyle.SHORT_STANDALONE, locale).toUpperCase();
	}

	/*
	 * Funcion que redondea numeros
	 */
	public static Double redondearDecimales(double valorInicial, int numeroDecimales) {
		double parteEntera, resultado;
		resultado = valorInicial;
		parteEntera = Math.floor(resultado);
		resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
		resultado = Math.round(resultado);
		resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
		return resultado;
	}

	public static String getExtension(String fileName) {
		return fileName.substring(fileName.indexOf("."), fileName.length());
	}

	public static String getBase64Fragment(String base64) {
		if (!base64.isEmpty()) {
			String[] cadenas = base64.split(",");
			return cadenas[1];
		}
		return "";
	}

	public static String generateRandomColor() {
		String[] letters = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", "E", "F" };
		String color = "#";
		for (int i = 0; i < 6; i++) {
			color += letters[(int) Math.round(Math.random() * 15)];
		}
		return color;
	}

	public static List<String> generateColorList(Integer cantidad) {
		List<String> items = new ArrayList<>();
		for (int i = 0; i < cantidad; i++) {
			items.add(generateRandomColor());
		}
		return items;
	}

	public static Integer getPorcentaje(int cantidad, int cantidadTotal) {
		Double porcentaje = ((double) cantidad / (double) cantidadTotal) * 100;
		return porcentaje.intValue();
	}
}
