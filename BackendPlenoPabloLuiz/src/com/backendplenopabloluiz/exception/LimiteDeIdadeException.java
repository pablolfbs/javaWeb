package com.backendplenopabloluiz.exception;

/**
 * Classe de exceção de limite de idade de colaboradores.
 * 
 * @author pablo
 *
 */
public class LimiteDeIdadeException extends RuntimeException {
	
	private static final long serialVersionUID = -8995175375124329130L;

	public LimiteDeIdadeException(String msg) {
		super(msg);
	}
	
	public LimiteDeIdadeException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
