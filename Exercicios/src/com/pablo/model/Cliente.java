package com.pablo.model;

import java.util.List;

public class Cliente {

	private String nome;

	private List<Compra> compras;

	public Cliente(String nome) {
		super();
		this.nome = nome;
	}

	public double obterValorTotal() {
		double vTot = 0;
		for (Compra compra : compras) {
			vTot += compra.obterValorCompra();
		}
		return vTot;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<Compra> getCompras() {
		return compras;
	}

	public void setCompras(List<Compra> compras) {
		this.compras = compras;
	}

}
