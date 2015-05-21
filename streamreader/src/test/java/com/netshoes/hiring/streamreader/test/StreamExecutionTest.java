package com.netshoes.hiring.streamreader.test;

import com.netshoes.hiring.streamreader.StreamReaderExecution;

/**
 * StreamExecution test class
 * 
 * @author raul.sousa
 * 
 */
public class StreamExecutionTest {

	/**
	 * Main
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// Test cases
		String[] cases = { "bbBBbbBBbbJ" };
		StreamReaderExecution.main(cases);

		// Test numbers
		String[] numbers = { "111111119" };
		StreamReaderExecution.main(numbers);

		// Test specialChars
		String[] specialChars = { "!!!#$@^&*¨" };
		StreamReaderExecution.main(specialChars);

		// Test equals
		String[] equals = { "AAAAA" };
		StreamReaderExecution.main(equals);

		// Test empty
		String[] empty = { "   R" };
		StreamReaderExecution.main(empty);
	}
}
