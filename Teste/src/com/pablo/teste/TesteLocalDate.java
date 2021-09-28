package com.pablo.teste;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

public class TesteLocalDate {
	
	private static Logger logger = Logger.getLogger(TesteLocalDate.class);
	
	public static void main(String[] args) {
		
		org.apache.log4j.BasicConfigurator.configure();
		
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2020, 8, 12);
		Date data = cal.getTime();
		
		LocalDateTime dataLocal = LocalDateTime.now();
		ZonedDateTime dataZona = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		logger.info(dataLocal.format(dtf));
		
		logger.info(cal.getTime());
		logger.info(data);
		logger.info(dataLocal);
		logger.info(dataZona);
		
		LocalDate ldNow = LocalDate.now();
		logger.info(ldNow);
		logger.info(LocalDate.of(1990, Month.AUGUST, 6));
		
		LocalTime ltNow = LocalTime.now();
		logger.info(ltNow);
		
		LocalDateTime ldtNow = LocalDateTime.now();
		logger.info(ldtNow);
		
		Instant iNow = Instant.now();
		logger.info("Instant - " + iNow);
		logger.info("Instant em milissegundos - " + iNow.toEpochMilli());
		
		ZonedDateTime zdtNow = ZonedDateTime.now();
		logger.info(zdtNow);
		
		Date d1 = new Date();
		logger.info(d1.toInstant());
		Instant instant = d1.toInstant();
		ZonedDateTime localDateTime1 = instant.atZone(ZoneId.systemDefault());
		LocalDate localDate = instant.atZone(ZoneId.systemDefault()).toLocalDate();
		logger.info(localDate);
		ZonedDateTime localDateTime2 = Instant.ofEpochMilli(d1.getTime()).atZone(ZoneId.systemDefault());
		logger.info(localDateTime1);
		logger.info(localDateTime2);
		
		Instant inst = Instant.ofEpochMilli(new Date().getTime());
		logger.info(inst.atZone(ZoneId.systemDefault()));
		
	}

}
