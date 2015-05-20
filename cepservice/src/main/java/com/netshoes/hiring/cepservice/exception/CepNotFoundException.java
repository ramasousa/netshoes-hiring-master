package com.netshoes.hiring.cepservice.exception;

/**
 * Exception class for cep not found
 * 
 * @author raul.sousa
 * 
 */
public class CepNotFoundException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5899183967850752187L;

	public CepNotFoundException() {
	}

	public CepNotFoundException(String message) {
		super(message);
	}

	public CepNotFoundException(Throwable cause) {
		super(cause);
	}

	public CepNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	public CepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
