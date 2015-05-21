package com.netshoes.hiring.adressrestfull.exception;

/**
 * Address validation exception class
 * 
 * @author raul.sousa
 * 
 */
public class AddressValidationException extends Exception {

	/**
	 * Serial Version Auto Generated from IDE
	 */
	private static final long serialVersionUID = 3457040175541507652L;


	/**
	 * 
	 */
	public AddressValidationException() {
	}

	/**
	 * Constructor receive a {@link Throwable} input parameter
	 * 
	 * @param cause
	 */
	public AddressValidationException(Throwable cause) {
		super(cause);
	}
	
	/**
	 * Constructor receive a {@link String} - message and a {@link Throwable} input parameters
	 * 
	 * @param message
	 * @param cause
	 */
	public AddressValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * Constructor receive a {@link String} - message input parameter
	 * 
	 * @param message
	 */
	public AddressValidationException(String message) {
		super(message);
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
	public AddressValidationException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
