package com.pablo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
public class Funcionario2 {
	
	@Getter
	@Setter
	private int id;
	
	@Getter
	@Setter
	private String name;
	
	@Getter
	private double salary;
	
	public double increaseSalary(double percentage) {
		return this.salary += this.salary * percentage / 100;
	}
	
}
