package teste;

import java.util.Calendar;
import java.util.GregorianCalendar;

import util.Util;

public class TesteCalculaIdade {
	
	public static void main(String[] args) {
		
		Calendar cal = new GregorianCalendar();
		cal.set(Calendar.DATE, 12);
		cal.set(Calendar.MONTH, Calendar.SEPTEMBER);
		cal.set(Calendar.YEAR, 1978);
		
		System.out.println(Util.calculaIdade(cal.getTime()));
		
	}

}
