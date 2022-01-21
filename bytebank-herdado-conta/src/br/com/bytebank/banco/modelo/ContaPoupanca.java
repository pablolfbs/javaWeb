package br.com.bytebank.banco.modelo;

public class ContaPoupanca extends Conta {

	private static final long serialVersionUID = -8564860718404204396L;

	public ContaPoupanca(int agencia, int numero) {
		super(agencia, numero);
	}

	@Override
	public void deposita(double valor) {
		super.saldo += valor;	
	}
	
	@Override
	public String toString() {
		return "ContaPoupanca, " + super.toString();
	}
	
}
