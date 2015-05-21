package com.netshoes.hiring.adressrestfull.exception;

/**
 * Generic errors exception class
 * 
 * @author raul.sousa
 * 
 */
public class GenericException extends Exception {

	/**
	 * Serial Version Auto Generated from IDE
	 */
	private static final long serialVersionUID = 3158107873609695096L;


	public GenericException() {
	}

	/**
	 * Constructor receive a {@link String} - message input parameter
	 * 
	 * @param message
	 */
	public GenericException(String message) {
		super(message);
	}

	/**
	 * Constructor receive a {@link Throwable} input parameter
	 * 
	 * @param cause
	 */
	public GenericException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor receive a {@link String} - message and a {@link Throwable} input parameters
	 * 
	 * @param message
	 * @param cause
	 */
	public GenericException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor receive a {@link String} - message, {@link Throwable} - cause, {@link Boolean} - enableSuppression and
	 * {@link Boolean} - writableStackTrace input parameters
	 * 
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public GenericException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
