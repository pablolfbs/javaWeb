package com.pablo.excecao.personalizadaA;

public class StringVaziaException extends RuntimeException {

	private static final long serialVersionUID = -194279251501873527L;
	
	private String nomeDoAtributo;
	
	public StringVaziaException(String nomeDoAtributo) {
		this.nomeDoAtributo = nomeDoAtributo;
	}
	
	public String getMessage() {
		return String.format("O atributo '%s' está vazio", nomeDoAtributo);
	}

}
