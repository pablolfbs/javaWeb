package com.pablo.ex9;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {
	
	public static void main(String[] args) {
		
		DateTimeFormatter isoDateTime = DateTimeFormatter.ISO_DATE_TIME;

		LocalDateTime ldtNow = LocalDateTime.now();
		System.out.println(ldtNow);
		
		String format = isoDateTime.format(ldtNow);
		System.out.println(format);
		
		
	}

}
