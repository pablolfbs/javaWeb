package com.pablo.ex7;

public class Main {

	public static void main(String[] args) {
		
		Invoice in = new Invoice(1, "pen drive", 2, 15.00f);
		
		System.out.println(in.getInvoiceAmount());
		
		System.out.println(in);
		
		Empregado emp1 = new Empregado("Pablo", "Faria", 5000.00);
		Empregado emp2 = new Empregado("Ingrid", "Lima", 5200.00);
		
		System.out.println(emp1);
		System.out.println(emp2);
		
		System.out.println(emp1.salarioAnual());
		System.out.println(emp2.salarioAnual());
		
		System.out.println(emp1.salarioComAumento());
		System.out.println(emp2.salarioComAumento());
		
	}

}
