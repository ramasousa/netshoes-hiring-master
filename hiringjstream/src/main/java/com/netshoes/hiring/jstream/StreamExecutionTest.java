package com.netshoes.hiring.jstream;

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
		StreamExecution.main(cases);

		// Test numbers
		String[] numbers = { "111111119" };
		StreamExecution.main(numbers);

		// Test specialChars
		String[] specialChars = { "!!!#$@^&*¨" };
		StreamExecution.main(specialChars);

		// Test equals
		String[] equals = { "AAAAA" };
		StreamExecution.main(equals);

		// Test empty
		String[] empty = { "    R" };
		StreamExecution.main(empty);
	}
}
