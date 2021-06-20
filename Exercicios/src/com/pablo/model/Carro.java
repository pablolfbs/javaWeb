package com.pablo.model;

public class Carro {

	protected final double VELOCIDADE_MAXIMA;
	private double velAtual;

	public Carro(double velMaxima) {
		VELOCIDADE_MAXIMA = velMaxima;
	}

	public void acelerar() {
		if (velAtual + 5 > VELOCIDADE_MAXIMA) {
			velAtual = VELOCIDADE_MAXIMA;
		} else {
			velAtual += 5;
		}
	}

	public void frear() {
		if (velAtual >= 5) {
			velAtual -= 5;
		} else {
			velAtual = 0;
		}
	}

	public double getVelAtual() {
		return velAtual;
	}

	public void setVelAtual(double velAtual) {
		this.velAtual = velAtual;
	}

	@Override
	public String toString() {
		return "velocidade atual = " + velAtual;
	}

}
