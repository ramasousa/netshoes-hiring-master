package com.netshoes.hiring.streamreader;

/**
 * Stream interface pre defined in the hiring test
 * 
 * @author raul.sousa
 * 
 */
public interface StreamReader {

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

