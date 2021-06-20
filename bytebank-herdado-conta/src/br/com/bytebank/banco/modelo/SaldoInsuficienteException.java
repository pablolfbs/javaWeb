package br.com.bytebank.banco.modelo;

public class SaldoInsuficienteException extends Exception{
	
	private static final long serialVersionUID = 1555899283889752904L;

	public SaldoInsuficienteException(String msg) {
		super(msg);
	}

}
