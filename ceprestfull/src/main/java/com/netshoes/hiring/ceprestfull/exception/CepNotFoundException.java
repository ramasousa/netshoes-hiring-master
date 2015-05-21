package com.netshoes.hiring.ceprestfull.exception;

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

	/**
	 * 
	 */
	public CepNotFoundException() {
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public CepNotFoundException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CepNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}
	
	/**
	 * 
	 * @param message
	 */
	public CepNotFoundException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param cause
	 */
	public CepNotFoundException(Throwable cause) {
		super(cause);
	}

}
