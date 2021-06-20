package com.pablo.teste;

import java.util.Calendar;
import java.util.Date;

public class Teste {
	
	public static void main(String[] args) {
		
		Date data1 = new Date();
		Date data2 = new Date();
		
		Calendar cal1 = Calendar.getInstance();
		cal1.set(2020, 4, 25);
		data1 = cal1.getTime();
		System.out.println(data1);
		System.out.println(cal1);
		cal1.add(Calendar.DATE, 10);
		System.out.println(cal1);
		Date dt1 = cal1.getTime();
		System.out.println(dt1);
		
		System.out.println("");
		
		Calendar cal2 = Calendar.getInstance();
		cal2.set(2020, 4, 25);
		data2 = cal2.getTime();
		System.out.println(data2);
		System.out.println(cal2);
		cal2.add(Calendar.DAY_OF_MONTH, 10);
		System.out.println(cal2);
		Date dt2 = cal2.getTime();
		System.out.println(dt2);
		
	}

}
