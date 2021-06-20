package com.pablo.teste;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.pablo.model.Funcionario2;

public class MainApp {
	
	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		
//		Conta c = new Conta();
//		c.abrirConta();
//		c.deposita(100);
//		System.out.println(c.getSaldo());
//		c.saca(500);
//		System.out.println(c.getSaldo());
		
		Funcionario2 f = null;
		List<Funcionario2> lista = new ArrayList<Funcionario2>();
		
		System.out.println("How many employees wil be registered?");
		int n = in.nextInt();
		int id; 
		
		for (int i = 0; i < n; i++) {
			
			id = in.nextInt();
			in.nextLine();
			String name = in.nextLine();
			double salary = in.nextDouble();
			
			f = new Funcionario2(id, name, salary);
			lista.add(f);
			
			System.out.println("Employee #" + (i + 1));
			System.out.println("Id: " + f.getId());
			System.out.println("Name: " + f.getName());
			System.out.println("Salary: " + f.getSalary());
		}
		
		System.out.println("Enter the employee id that will have salary increase: ");
		id = in.nextInt();
		System.out.println("Enter the percentage: ");
		double percentage = in.nextDouble();
		
		f.increaseSalary(percentage);
		
		System.out.println("List of employees: ");
		lista.toString();
		
		in.close();
	}

}
