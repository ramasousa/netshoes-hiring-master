package com.netshoes.hiring.ceprestfull.exception;

/**
 * Exception class for invalid input cep
 * 
 * @author raul.sousa
 * 
 */
public class InvalidCepException extends Exception {

	/**
	 * Serial Version UID
	 */
	private static final long serialVersionUID = 8008223647769926275L;

	public InvalidCepException() {
	}

	/**
	 * 
	 * @param message
	 */
	public InvalidCepException(String message) {
		super(message);
	}
	
	/**
	 * 
	 * @param message
	 * @param cause
	 */
	public InvalidCepException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public InvalidCepException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

	/**
	 * 
	 * @param cause
	 */
	public InvalidCepException(Throwable cause) {
		super(cause);
	}
}
