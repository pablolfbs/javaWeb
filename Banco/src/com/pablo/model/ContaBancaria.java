package com.pablo.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ContaBancaria {

	private final String NUM_CONTA;
	private BigDecimal valorDepositoInicial;
	private BigDecimal saldo;

	private Cliente cliente;

	public ContaBancaria(String NUM_CONTA, Cliente cliente, BigDecimal valorDepositoInicial) {
		this.NUM_CONTA = NUM_CONTA;
		this.cliente = cliente;
		this.valorDepositoInicial = valorDepositoInicial;
	}

	public ContaBancaria(String NUM_CONTA, Cliente cliente) {
		this.NUM_CONTA = NUM_CONTA;
		this.cliente = cliente;
		this.valorDepositoInicial = BigDecimal.ZERO;
	}

	@Override
	public String toString() {
		return "ContaBancaria [numeroConta=" + NUM_CONTA + ", valorDepositoInicial=R$" + valorDepositoInicial.setScale(2) + ", saldo=R$"
				+ saldo.setScale(2) + ", cliente=" + cliente + "]";
	}

}
