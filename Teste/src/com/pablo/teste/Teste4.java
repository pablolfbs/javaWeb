package com.pablo.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Teste4 {

	public static void main(String[] args) {

		int currentLine = getLineNumber();
		System.out.println("The Current Line Number is " + currentLine);

		Date data;
		try {
			data = new SimpleDateFormat("dd/MM/yyyy").parse("01/09/2021");
			System.out.println(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

	}

	// Get the current line number in Java
	public static int getLineNumber() {
		return new Throwable().getStackTrace()[0].getLineNumber();
	}

}
