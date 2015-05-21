package com.netshoes.hiring.adressrestfull.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Exception class to Resource not found exception
 * 
 * @author raul.sousa
 * 
 */
@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4518465499553296716L;


	public ResourceException() {
	}

	/**
	 * Constructor receive a {@link String} - message input parameter
	 * 
	 * @param message
	 */
	public ResourceException(String message) {
		super(message);
	}

	/**
	 * Constructor receive a {@link Throwable} input parameter
	 * 
	 * @param cause
	 */
	public ResourceException(Throwable cause) {
		super(cause);
	}

	/**
	 * Constructor receive a {@link String} - message and a {@link Throwable} input parameters
	 * 
	 * @param message
	 * @param cause
	 */
	public ResourceException(String message, Throwable cause) {
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
	public ResourceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
