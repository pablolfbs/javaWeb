package com.pablo.model;

import java.util.List;

public class Compra {

	private List<Item> itens;

	public double obterValorCompra() {
		double tot = 0;
		for (Item item : itens) {
			tot += item.getProduto().getPreco() * item.getQuantidade();
		}
		return tot;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

}
