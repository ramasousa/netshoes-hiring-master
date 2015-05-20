package com.netshoes.hiring.jstream;

/**
 * Stream execution main class
 * 
 * @author raul.sousa
 * 
 */
public class StreamExecution {

	/**
	 * Null char constant
	 */
	static final char NULL_CHAR = 0;

	/**
	 * Main execution method
	 * 
	 * @param args- The first index will be the input chars list as String
	 *            
	 */
	public static void main(String[] args) {
		char firstChar = firstChar(new StreamImpl(args[0]));
		System.out.println(NULL_CHAR == firstChar ? "No different char found." : "First different char is -> " + firstChar);
	}

	/**
	 * This method gets the first different char in a input
	 * 
	 * @param input
	 *            
	 * @return
	 */
	public static char firstChar(Stream input) {

		char firstCharDifferent = NULL_CHAR;
		char lastChar = NULL_CHAR;

		while (input.hasNext()) {

			char actualChar = input.getNext();

			if (lastChar != 0 && charIsDifferent(lastChar, actualChar)) {
				firstCharDifferent = actualChar;
				break;
			}

			lastChar = actualChar;
		}

		return firstCharDifferent;
	}

	/**
	 * Verify if a char is different from another
	 * 
	 * @param last
	 * @param actual
	 *            
	 * @return if both is different or not
	 */
	private static final boolean charIsDifferent(char last, char actual) {
		return Character.toLowerCase(last) != Character.toLowerCase(actual);
	}

}
