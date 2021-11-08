package com.pablo.exception;

public class ContaBancariaException extends RuntimeException {
	
	private static final long serialVersionUID = 4928852361924079005L;

	public ContaBancariaException(String msg) {
		super(msg);
	}

}
