package com.pablo.teste;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main2 {

	public static void main(String[] args) {

		SimpleDateFormat sdfh = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Calendar cal = Calendar.getInstance();
		int mouthStart = cal.get(Calendar.MONTH);

		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		Date dataInicio = null;
		Date dataFim = null;

		if (cal.get(Calendar.DATE) <= 15) {
			calendar.set(Calendar.MONTH, mouthStart - 1);
			calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));

			dataInicio = calendar.getTime();
			System.out.println(dataInicio);

			calendar.add(Calendar.MONTH, 1);
			calendar.add(Calendar.MILLISECOND, -1);

			dataFim = calendar.getTime();
			System.out.println(dataFim);

		} else {
			calendar.set(Calendar.MONTH, mouthStart);
			calendar.set(Calendar.YEAR, cal.get(Calendar.YEAR));

			dataInicio = calendar.getTime();
			System.out.println(dataInicio);

			calendar.add(Calendar.DATE, 15);
			calendar.add(Calendar.MILLISECOND, -1);

			dataFim = Calendar.getInstance().getTime();
			System.out.println(dataFim);
		}

		String dia = sdfh.format(dataInicio).substring(8, 10);
		String mes = sdfh.format(dataInicio).substring(5, 7);
		String anoCompleto = sdfh.format(dataInicio).substring(0, 4);

		System.out.println(dia);
		System.out.println(mes);
		System.out.println(anoCompleto);

		String diaF = sdfh.format(dataFim).substring(8, 10);
		String mesF = sdfh.format(dataFim).substring(5, 7);
		String anoCompletoF = sdfh.format(dataFim).substring(0, 4);

		System.out.println(diaF);
		System.out.println(mesF);
		System.out.println(anoCompletoF);

		System.out.println(dataInicio);
		System.out.println(dataFim);

		System.out.println("Fim");

	}

}
