package com.pablo.teste;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class TesteDate {
	
	public static void main(String[] args) {
		
		Calendar c1 = new GregorianCalendar(2021, 10, 21);
		
		System.out.println(c1.get(Calendar.DAY_OF_WEEK));
		System.out.println(c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY);
		System.out.println(c1.get(Calendar.DAY_OF_WEEK) == 1);
		
		Date date = new Date();
		c1 = Calendar.getInstance();
		c1.setTime(date);
		c1.add(Calendar.DATE, 1);
		date = c1.getTime();
		System.out.println(date.before(new Date()));
		
		c1 = Calendar.getInstance();
		c1.add(Calendar.DATE, -6);
		System.out.println(c1.getTime());
		
		Date d1 = c1.getTime();
		Date d2 = new Date();
		System.out.println(d1.compareTo(d2));
		
		System.out.println(c1.get(Calendar.DAY_OF_MONTH) == 15);
		System.out.println(c1.get(Calendar.DATE) == 15);
		
		c1 = Calendar.getInstance();
		c1.set(Calendar.DATE, 21);
		c1.add(Calendar.MONTH, -1);
		System.out.println(c1.getTime());
		
		String s = "01-10-2021";
		String sI = "2021-10-01";
		
		LocalDate lc = LocalDate.parse(s, DateTimeFormatter.ofPattern("dd-MM-yyyy"));
		LocalDate lcI = LocalDate.parse(sI);
		System.out.println(lc);
		System.out.println(lcI);
		
		Calendar calendar = Calendar.getInstance();
		calendar.clear();
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(calendar.getTime());
		System.out.println(new Date(0));
		
	}

}
