package com.pablo.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class StringToLocalDate {

	public static void main(String[] args) {
		
		String dataStr = "12-09-1978";
		System.out.println(dataStr);
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		LocalDate data = LocalDate.parse(dataStr, formatter);
		System.out.println(data);
		
		String dataStr2 = "2021-03-15";
	
		System.out.println(stringToLocalDate(dataStr2));
		System.out.println(localDateToString(stringToLocalDate(dataStr2)));		
		
	}

	private static LocalDate stringToLocalDate(String data) {
		return LocalDate.parse(data, DateTimeFormatter.ofPattern("yyyy-MM-dd"));
	}
	
	private static String localDateToString(LocalDate data) {
		return data.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
	}
}
