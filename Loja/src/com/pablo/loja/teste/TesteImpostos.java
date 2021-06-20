package com.pablo.loja.teste;

import java.math.BigDecimal;

import com.pablo.loja.imposto.CalculadoraDeImpostos;
import com.pablo.loja.imposto.ISS;
import com.pablo.loja.orcamento.Orcamento;

public class TesteImpostos {

	public static void main(String[] args) {
		
		Orcamento orcamento = new Orcamento(new BigDecimal("100"), 1);
		CalculadoraDeImpostos calculadora = new CalculadoraDeImpostos();
		
		System.out.println(calculadora.calcular(orcamento, new ISS()));
	}

}
