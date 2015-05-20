package com.netshoes.hiring.cepservice.model;

import java.io.Serializable;

/**
 * Class for failed status response
 * 
 * @author raul.sousa
 * 
 */
public class FailedStatus implements Serializable {

	/**
	 * Serial UID
	 */
	private static final long serialVersionUID = -8057035661381180402L;

	/**
	 * Empty constructor
	 */
	public FailedStatus() {
		super();
	}

	/**
	 * Constructor with status message
	 * 
	 * @param statusMessage
	 */
	public FailedStatus(String statusMessage) {
		super();
		this.statusMessage = statusMessage;
	}

	/**
	 * Bad status message
	 */
	private String statusMessage;

	/**
	 * @return the statusMessage
	 */
	public String getStatusMessage() {
		return statusMessage;
	}

	/**
	 * @param statusMessage - the statusMessage to set
	 *           
	 */
	public void setStatusMessage(String statusMessage) {
		this.statusMessage = statusMessage;
	}

}
