package com.pablo.teste;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

import org.apache.log4j.Logger;

public class Teste5 {

	private static Logger logger = Logger.getLogger(Teste5.class);
	Date d = new Date();

	public static void main(String[] args) {
		
		org.apache.log4j.BasicConfigurator.configure();

		Date d1 = new Date();
		Calendar cal = GregorianCalendar.getInstance();
		cal.set(2021, Calendar.MARCH, 28);
		logger.info(cal.getTime().compareTo(d1));

		logger.info(d1);
		logger.info(cal.getTime());

		logger.info(d1.compareTo(cal.getTime()));
		logger.info(cal.getTime().compareTo(d1));
		logger.info(d1.compareTo(d1));
		
		cal.set(2021, Calendar.OCTOBER, 28);

		logger.info(cal.getTime().compareTo(d1));
		logger.info(d1.compareTo(cal.getTime()));

	}

}

class Dia implements Comparable<Dia> {
	private int numero;
	private Date data;

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dia other = (Dia) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		return true;
	}

	@Override
	public int compareTo(Dia d) {
		return d.getData().compareTo(this.data);
	}
}
