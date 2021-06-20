package com.pablo.ex1;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Main {

	public static void main(String[] args) {

		Agenda agenda = new Agenda();

		Calendar cal1 = new GregorianCalendar(1978, Calendar.SEPTEMBER, 12);
		Calendar cal2 = new GregorianCalendar(1988, Calendar.AUGUST, 25);
		Calendar cal3 = new GregorianCalendar(2018, Calendar.APRIL, 24);

		agenda.armazenaPessoa("Pablo", cal1.getTime(), 1.81f);
		agenda.armazenaPessoa("Ingrid", cal2.getTime(), 1.65f);
		agenda.armazenaPessoa("Alice", cal3.getTime(), 54f);
		
		System.out.println(agenda.buscaPessoa("Ingrid"));
		
		System.out.println();

		agenda.imprimeAgenda();
		
		System.out.println();
		
		agenda.imprimePessoa(2);
		
		System.out.println();
		
		agenda.removePessoa("Ingrid");
		
		agenda.imprimeAgenda();
		
		System.out.println();
		
		System.out.println(agenda.buscaPessoa("Alice"));
		System.out.println(agenda.buscaPessoa("Pablo"));
		System.out.println(agenda.buscaPessoa("Teste"));

	}

}
