package com.netshoes.hiring.cepservice.exception;

/**
 * Exception class for invalid input cep
 * 
 * @author raul.sousa
 * 
 */
public class InvalidCepException extends Exception {

	/**
	 * Serial uuid
	 */
	private static final long serialVersionUID = 8008223647769926275L;

	public InvalidCepException() {
	}

	public InvalidCepException(String message) {
		super(message);
	}
	
	public InvalidCepException(String message, Throwable cause) {
		super(message, cause);
	}

	public InvalidCepException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}


	public InvalidCepException(Throwable cause) {
		super(cause);
	}
}
