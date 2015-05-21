package com.netshoes.hiring.adressrestfull.exception;

/**
 * Exception for address that already exists
 * 
 * @author raul.sousa
 * 
 */
public class InvalidAddressException extends Exception {

	/**
	 * Serial Version Auto Generated from IDE
	 */
	private static final long serialVersionUID = 3127268725081459130L;


	public InvalidAddressException() {
	}

	/**
	 * Constructor receive a {@link String} - message input parameter
	 * 
	 * @param message
	 */
	public InvalidAddressException(String message) {
		super(message);
	}

	/**
	 * Constructor receive a {@link Throwable} input parameter
	 * 
	 * @param cause
	 */
	public InvalidAddressException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor receive a {@link String} - message and a {@link Throwable} input parameters
	 * 
	 * @param message
	 * @param cause
	 */
	public InvalidAddressException(String message, Throwable cause) {
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
	public InvalidAddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
