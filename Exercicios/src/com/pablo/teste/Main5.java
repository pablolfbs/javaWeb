package com.pablo.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Main5 {
	
	public static void main(String[] args) {
		
		 Calendar cal = Calendar.getInstance();
		
		int dia = Calendar.DATE;
		int mes = Calendar.MONTH;
		int ano = Calendar.YEAR;
		
		cal.set(ano, 2018);
		cal.set(mes, Calendar.APRIL);
		cal.set(dia, 24);
		
		Date data = cal.getTime();
		
		System.out.println(calculaIdadeCompleta(data)[0] + " " + calculaIdadeCompleta(data)[1] + " " + calculaIdadeCompleta(data)[2]);
		
	}
	
	public static int[] calculaIdadeCompleta(java.util.Date dataNasc) {

		Calendar dateOfBirth = new GregorianCalendar();

		dateOfBirth.setTime(dataNasc);

		// Cria um objeto calendar com a data atual
		Calendar today = Calendar.getInstance();
		Calendar mesAnterior = Calendar.getInstance();
		mesAnterior.set(Calendar.MONTH, today.get(Calendar.MONTH) - 1);

		// Obtém a idade baseado no ano
		int anos = today.get(Calendar.YEAR) - dateOfBirth.get(Calendar.YEAR);
		
		dateOfBirth.add(Calendar.YEAR, anos);

		// se a data de hoje é antes da data de Nascimento, então diminui 1(um)
		if (today.before(dateOfBirth))
			anos--;
		
		// Obtém os meses
		int meses = today.get(Calendar.MONTH) - dateOfBirth.get(Calendar.MONTH);
		
		int dias;
		
		// se o mês é antes do mês de Nascimento, então diminui 1(um)
		// e faz o cálculo dos dias decorridos
		if (today.get(Calendar.DATE) < (dateOfBirth.get(Calendar.DATE))) {
			meses--;
			dias = today.get(Calendar.DATE) - dateOfBirth.get(Calendar.DATE) + mesAnterior.getActualMaximum(Calendar.DAY_OF_MONTH);
		} else {
			dias = today.get(Calendar.DATE) - dateOfBirth.get(Calendar.DATE);
		}
		
		return new int[]{anos, meses, dias};

	}

}
