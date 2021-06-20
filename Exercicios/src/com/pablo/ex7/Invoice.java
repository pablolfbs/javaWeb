package com.pablo.ex7;

public class Invoice {

	private int nItem;
	private String descItem;
	private int quantidade;
	private float preco;

	public Invoice(int nItem, String descItem, int quantidade, float preco) {
		this.nItem = nItem;
		this.descItem = descItem;
		this.quantidade = quantidade > 0 ? quantidade : 0;
		this.preco = preco > 0 ? preco : 0.00f;
	}
	
	public float getInvoiceAmount() {
		return getPreco() * getQuantidade();
	}

	public int getnItem() {
		return nItem;
	}

	public void setnItem(int nItem) {
		this.nItem = nItem;
	}

	public String getDescItem() {
		return descItem;
	}

	public void setDescItem(String descItem) {
		this.descItem = descItem;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	@Override
	public String toString() {
		return "Invoice [nItem=" + nItem + ", descItem=" + descItem + ", quantidade=" + quantidade + ", preco=" + preco
				+ "]";
	}

}
