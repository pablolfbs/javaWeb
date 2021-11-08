package com.pablo.teste;

import java.time.LocalDate;

public class TesteLocalDatePrimeiroEUltimoDiaDoMes {

	public static void main(String[] args) {

//		System.out.println(firstDayOfPreviousMonth(LocalDate.now()));
		System.out.println(lastDayOfPreviousMonth(LocalDate.now()));
//		System.out.println(firstDayOfPresentMonth(LocalDate.now()));
		System.out.println(lastDayOfPresentMonth(LocalDate.now()));

	}

//	public static LocalDate firstDayOfPreviousMonth(LocalDate date) {
//		return date.minusMonths(1).withDayOfMonth(1);
//	}

	public static LocalDate lastDayOfPreviousMonth(LocalDate date) {
		return date.withDayOfMonth(1).minusDays(1);
	}

//	public static LocalDate firstDayOfPresentMonth(LocalDate date) {
//		return date.withDayOfMonth(1);
//	}

	public static LocalDate lastDayOfPresentMonth(LocalDate date) {
		return date.plusMonths(1).withDayOfMonth(1).minusDays(1);
		// return LocalDate.of(date.getYear(), date.getMonth(), date.withDayOfMonth(1).lengthOfMonth());
	}

}
