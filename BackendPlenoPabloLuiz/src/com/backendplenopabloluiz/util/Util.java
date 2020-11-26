package com.backendplenopabloluiz.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Classe utilitária.
 * 
 * @author pablo
 *
 */
public class Util {
	
	private Util() {
		throw new IllegalStateException("Utility class");
	}

	/**
	 * Método que calcula a idade do colaborador.
	 * 
	 * @param data
	 * @return
	 */
	public static int calculaIdade(Date data) {
		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(data);

		Calendar today = Calendar.getInstance();
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		return today.before(dateOfBirth) ? --age : age;
	}

	/**
	 * Método que pega a resposta da requisição e tranforma numa String no formato json.
	 * @param buffereReader
	 * @return
	 * @throws IOException
	 */
	public static String converteJsonEmString(BufferedReader buffereReader) throws IOException {
		String resposta;
		StringBuilder jsonEmString = new StringBuilder();
		
		while ((resposta = buffereReader.readLine()) != null) {
			jsonEmString.append(resposta);
		}
		return jsonEmString.toString();
	}

}
