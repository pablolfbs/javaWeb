package util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Util {

	private Util() {

	}

	/**
	 * Formata uma string de 11 caracteres para o formato de cpf.
	 * 
	 * @param cpf
	 * @return
	 */
	public static String formataCpf(String cpf) {
		try {
			if (cpf.length() == 11)
				return (cpf.substring(0, 3) + "." + cpf.substring(3, 6) + "." + cpf.substring(6, 9) + "-"
						+ cpf.substring(9, 11));

		} catch (Exception e) {
			System.err.println("Impossível formatar cpf: " + e);
			e.printStackTrace();
		}
		return cpf;
	}

	/**
	 * Altera a primeira letra de cada palavra para maiúscula.
	 * 
	 * @param texto
	 * @return
	 */
	public static String capitalize(String texto) {
		int indexAnterior = 0;
		int index = 0;
		StringBuilder textoCapitalizado = new StringBuilder();

		while (index >= 0) {
			if (index > 0) {
				if (!Arrays.asList("e", "da", "de", "do", "das", "dos").contains(texto.substring(indexAnterior, index)))
					textoCapitalizado.append(texto.substring(indexAnterior, indexAnterior + 1).toUpperCase()
							.concat(texto.substring(indexAnterior + 1, index + 1).toLowerCase()));
				else
					textoCapitalizado.append(texto.substring(indexAnterior, indexAnterior + 1)
							.concat(texto.substring(indexAnterior + 1, index + 1).toLowerCase()));
				indexAnterior = index + 1;
			}
			index = texto.indexOf(" ", index + 1);
			if (index == -1)
				textoCapitalizado.append(texto.substring(indexAnterior, indexAnterior + 1).toUpperCase()
						.concat(texto.substring(indexAnterior + 1).toLowerCase()));
		}
		return textoCapitalizado.toString();
	}

	/**
	 * Calcula a Idade baseado em String. Exemplo:
	 * calculaIdade("20/08/1977","dd/MM/yyyy");
	 * 
	 * @param dataNasc
	 * @param pattern
	 * @return
	 */
	public static int calculaIdade(String dataNasc, String pattern) {

		DateFormat sdf = new SimpleDateFormat(pattern);
		Date dataNascInput = null;

		try {
			dataNascInput = sdf.parse(dataNasc);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Calendar dateOfBirth = new GregorianCalendar();
		dateOfBirth.setTime(dataNascInput);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;
	}

	/**
	 * Calcula a Idade baseado em java.util.Date
	 * 
	 * @param dataNasc
	 * @return
	 */
	public static int calculaIdade(java.util.Date dataNasc) {

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNasc);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();

		// Obtém a idade baseado no ano
		int age = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);

		dateOfBirth.add(Calendar.YEAR, age);

		// se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if (today.before(dateOfBirth)) {
			age--;
		}
		return age;

	}

}
