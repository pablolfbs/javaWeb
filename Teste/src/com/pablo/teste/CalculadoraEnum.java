package com.pablo.teste;

public enum CalculadoraEnum {
	
	SOMA("+") {
		@Override
		public double calcula(double a, double b) {
			return a + b;
		}
	}, SUBTRACAO("-") {
		@Override
		public double calcula(double a, double b) {
			return a - b;
		}
	}, MULTIPLICACAO("*") {
		@Override
		public double calcula(double a, double b) {
			return a * b;
		}
	}, DIVISAO("/") {
		@Override
		public double calcula(double a, double b) {
			return a / b;
		}
	};

	private String operador;

	CalculadoraEnum(String operador) {
		this.operador = operador;
	}
	
	public abstract double calcula(double a, double b);
	
	public String getOperador() {
		return operador;
	}

}
