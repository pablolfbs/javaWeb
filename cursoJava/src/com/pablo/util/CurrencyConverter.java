package com.pablo.util;

public class CurrencyConverter {
	
	public static double cotacao(double valor) {
		return 1 * valor;
	}

	public static double aPagar(double valor, double quantidade) {
		return iof(cotacao(valor) * quantidade);
	}
	
	public static double iof(double valor) {
		return valor += valor * 6 / 100;
	}

}
