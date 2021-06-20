package com.pablo.teste;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class Teste2 {
	
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		int day = 1;
		Date data = new Date();
		data.setDate(day);
		System.out.println(data);
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DAY_OF_MONTH, day);
		System.out.println(cal);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.MONTH));
		System.out.println(cal.get(Calendar.YEAR));
		
		cal.set(Calendar.DATE, 10);
		
		System.out.println(cal.getTime());
		
		Produto p = new Produto("lápis");
		Object[] o = new Object[2];
		o[1] = "teste1";
		o[1] = "teste2";
		
		
		List<Object[]> lista = new ArrayList<>();
		
		lista.add(o);
		System.out.println(lista);
		for (Object[] objects : lista) {
			for (Object object : objects) {
				System.out.println(object);
			}
		}
		
		System.out.println("Pablo");
		
	}

}
