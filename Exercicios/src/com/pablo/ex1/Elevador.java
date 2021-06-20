package com.pablo.ex1;

public class Elevador {

	private int andarAtual = 0;
	private int totalAndares;
	private int capacidadeElevador;
	private int pessoasPresentes;

	public void inicializa(int capacidade, int andares) {
		this.capacidadeElevador = capacidade;
		this.totalAndares = andares;
	}

	public int entra() {
		if (getCapacidadeElevador() > getPessoasPresentes()) {
			return this.pessoasPresentes++;
		}
		return this.pessoasPresentes;
	}

	public int sai() {
		if (getPessoasPresentes() > 0) {
			return this.pessoasPresentes--;
		}
		return this.pessoasPresentes;
	}

	public int sobe() {
		if (getAndarAtual() < getTotalAndares()) {
			return this.andarAtual++;
		}
		return this.andarAtual;
	}

	public int desce() {
		if (getAndarAtual() > 0) {
			return this.andarAtual--;
		}
		return this.andarAtual;
	}

	public int getAndarAtual() {
		return andarAtual;
	}

	public void setAndarAtual(int andarAtual) {
		this.andarAtual = andarAtual;
	}

	public int getTotalAndares() {
		return totalAndares;
	}

	public void setTotalAndares(int totalAndares) {
		this.totalAndares = totalAndares;
	}

	public int getCapacidadeElevador() {
		return capacidadeElevador;
	}

	public void setCapacidadeElevador(int capacidadeElevador) {
		this.capacidadeElevador = capacidadeElevador;
	}

	public int getPessoasPresentes() {
		return pessoasPresentes;
	}

	public void setPessoasPresentes(int pessoasPresentes) {
		this.pessoasPresentes = pessoasPresentes;
	}

}
