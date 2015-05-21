package com.netshoes.hiring.streamreader;

import java.util.ArrayList;
import java.util.List;

/**
 * StreamImpl is a implementation of the Stream interface
 * proposal by hiring test 
 * 
 * @author raul.sousa
 * 
 */
public class StreamReaderImpl implements StreamReader {

	/**
	 * Input of chars
	 */
	private String input;

	/**
	 * Char that was read by the system
	 */
	private List<Character> charRead;

	/**
	 * Last read index
	 */
	private int lastReadIndex = -1;

	/**
	 * Constructor
	 * 
	 * @param input
	 */
	public StreamReaderImpl(String input) {
		this.input = input;
		charRead = new ArrayList<Character>(1);
	}

	/**
	 * @see StreamReader
	 */
	public char getNext() {
		char next = input.charAt(++lastReadIndex);
		charRead.add(next);
		return next;
	}

	/**
	 * @see StreamReader
	 */
	public boolean hasNext() {

		try {
			input.charAt(lastReadIndex + 1);
			return true;
		} catch (IndexOutOfBoundsException ex) {
		}

		return false;
	}

}
