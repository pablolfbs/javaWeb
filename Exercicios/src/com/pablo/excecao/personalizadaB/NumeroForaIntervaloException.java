package com.pablo.excecao.personalizadaB;

public class NumeroForaIntervaloException extends Exception {

	private static final long serialVersionUID = -194279251501873527L;
	
	private String nomeDoAtributo;
	
	public NumeroForaIntervaloException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo '%s' está negativo", nomeDoAtributo);
	}

}
