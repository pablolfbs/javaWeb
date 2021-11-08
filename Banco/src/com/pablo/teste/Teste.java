package com.pablo.teste;

import java.math.BigDecimal;
import java.util.Objects;

import com.pablo.model.Cliente;

public class Teste {

	public static void main(String[] args) {

		Cliente c1 = new Cliente();
		c1.setNomeTitular("Pablo");
		c1.abrirConta("125-7", c1, new BigDecimal(100)).ifPresent(System.out::println);
		
		if (Objects.nonNull(c1.getContaBancaria())) {
			c1.imprimeDadosDaConta();
			c1.imprimeSaldo();
			c1.depositar(c1.getContaBancaria().getNUM_CONTA(), new BigDecimal(500));
			c1.imprimeSaldo();
			c1.sacar(c1.getContaBancaria().getNUM_CONTA(), new BigDecimal(50));
			c1.imprimeSaldo();
			c1.imprimeDadosDaConta();
		} else {
			System.out.println("Conta inexistente!");
		}

		System.out.println();
		
		Cliente c2 = new Cliente();
		c2.setNomeTitular("Ingrid");
		c2.abrirConta("128-5", c2).ifPresent(System.out::println);

		if (Objects.nonNull(c2.getContaBancaria())) {
			c2.imprimeDadosDaConta();
			c2.imprimeSaldo();
			c2.depositar(c2.getContaBancaria().getNUM_CONTA(), new BigDecimal(300));
			c2.imprimeSaldo();
			c2.sacar(c2.getContaBancaria().getNUM_CONTA(), new BigDecimal(800));
			c2.imprimeSaldo();
			c2.imprimeDadosDaConta();
		} else {
			System.out.println("Conta inexistente!");
		}

	}

}
