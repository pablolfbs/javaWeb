package com.pablo.loja.exception;

public class DomainException extends RuntimeException {

	private static final long serialVersionUID = -4564791023410909345L;
	
	public DomainException(String mensagem) {
		super(mensagem);
	}

}
