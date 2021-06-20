package com.pablo.ex6;

public class Porta {

	private boolean estaAberta;
	private String cor;
	private float dimensaoX;
	private float dimensaoY;
	private float dimensaoZ;

	public Porta() {
		super();
	}

	public Porta(String cor, float dimensaoX, float dimensaoY, float dimensaoZ) {
		super();
		this.estaAberta = false;
		this.cor = cor;
		this.dimensaoX = dimensaoX;
		this.dimensaoY = dimensaoY;
		this.dimensaoZ = dimensaoZ;
	}

	public void abre() {
		this.estaAberta = true;

	}

	public void fecha() {
		this.estaAberta = false;

	}

	public void pinta(String cor) {
		this.cor = cor;

	}

	public boolean estaAberta() {
		return this.estaAberta;
	}

	public boolean isEstaAberta() {
		return estaAberta;
	}

	public void setEstaAberta(boolean estaAberta) {
		this.estaAberta = estaAberta;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public float getDimensaoX() {
		return dimensaoX;
	}

	public void setDimensaoX(float dimensaoX) {
		this.dimensaoX = dimensaoX;
	}

	public float getDimensaoY() {
		return dimensaoY;
	}

	public void setDimensaoY(float dimensaoY) {
		this.dimensaoY = dimensaoY;
	}

	public float getDimensaoZ() {
		return dimensaoZ;
	}

	public void setDimensaoZ(float dimensaoZ) {
		this.dimensaoZ = dimensaoZ;
	}

}
