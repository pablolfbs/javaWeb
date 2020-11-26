package com.backendplenopabloluiz.exception;

/**
 * Classe de exceção da blacklist.
 * 
 * @author pablo
 *
 */
public class BlacklistColaboradorException extends RuntimeException {
	
	private static final long serialVersionUID = 2957799909049251971L;

	public BlacklistColaboradorException(String msg) {
		super(msg);
	}
	
	public BlacklistColaboradorException(String msg, Throwable cause) {
		super(msg, cause);
	}

}
