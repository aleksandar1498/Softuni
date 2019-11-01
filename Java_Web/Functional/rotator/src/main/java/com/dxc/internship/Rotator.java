/**
 * 
 */
package com.dxc.internship;

/**
 * @author Aleksandar Stefanov
 *
 */
public final class Rotator {

	private Rotator() {
		// Utility class
	}
	/**
	 * @param word is the char array that needs to be reverted. If it is null or empty array an IllegalArgumentExceptionIsThrown
	 * @param start is the starting index for the reversion . It is inclusive
	 * @param end is the ending index for the reversion. It is inclusive
	 * @throws IllegalArgumentException if :
	 *  -word is null or empty
	 *  -start index is less then 0 or more then the length of the word 
	 *  -end index is less then 0 or more then the length of the word 
	 *  -start index is greater than end index
	 */
	public static final void revert(char[] word, int start, int end) {
		checkValidityArray(word);
		
		if (start < 0 || start >= word.length || end < 0 || end >= word.length) {
			throw new IllegalArgumentException("index is out of bounds");
		}
		if (start > end) {
			throw new IllegalArgumentException("start cannot be after the end");
		}
		int middle = start + (end - start) / 2;
		while (start <= middle) {
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;
			start++;
			end--;
		}
	}
	/**
	 * @param word is the char array that needs to be reverted
	 * this method implements polymorphism, calls the original implementation of the method by setting the starting and ending value {@link #revert(char[], int, int) revert}
	 */
	public static final void revert(char[] word) {
		checkValidityArray(word);
		
		Rotator.revert(word, 0, word.length - 1);
	}
	private static void checkValidityArray(char [] word) {
		if(word == null) {
			throw new IllegalArgumentException("word cannot be null");
		}
		if (word.length == 0) {
			throw new IllegalArgumentException("word cannot be empty");
		}
	}

}
