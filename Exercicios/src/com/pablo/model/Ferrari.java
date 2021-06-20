package com.pablo.model;

public class Ferrari extends Carro {
	
	public Ferrari() {
		this(315);
	}
	
	public Ferrari(double velMaxima) {
		super(velMaxima);
	}

	@Override
	public void acelerar() {
		if (getVelAtual() + 300 > VELOCIDADE_MAXIMA) {
			setVelAtual(VELOCIDADE_MAXIMA);
		} else {
			setVelAtual(getVelAtual() + 300);
		}
	}
}
