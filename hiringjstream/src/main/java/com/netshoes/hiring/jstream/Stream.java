package com.netshoes.hiring.jstream;

/**
 * Stream interface
 * 
 * @author raul.sousa
 * 
 */
public interface Stream {

	/**
	 * Get the next available char
	 * 
	 * @return next available char
	 */
	char getNext();

	/**
	 * Verify if has a next available char
	 * 
	 * @return if has or no a next char
	 */
	boolean hasNext();
}

