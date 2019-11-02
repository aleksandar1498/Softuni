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

	public static void main(String[] args) {

		Rotator.revertInternWords(new char[] { ' ', ' ', ' ' });
		Rotator.revertInternWords(
				new char[] { 'I', ' ', 'A', 'm', ' ', 'H', 'e', 'l', 'l', 'o', ' ', ' ', 'I', 'v', '!', 'a', 'n' });
		Rotator.revertInternWords(new char[] { 'I', ' ', 'A', 'm', ' ', 'H', 'e', 'l', 'l', 'o', ' ', ' ', 'I', 'v',
				'!', 'a', 'n', ' ', ' ' });
		Rotator.revertInternWords(new char[] { ' ', 'I', ' ', 'A', 'm', ' ', 'H', 'e', 'l', 'l', 'o', ' ', ' ', 'I',
				'v', '!', 'a', 'n', ' ', ' ' });
	}

	/**
	 * Reverts an array of chars from {@code start} index  to {@code end} index 
	 * 
	 * @param word  is the char array that needs to be reverted. If it is null or
	 *              empty array an IllegalArgumentExceptionIsThrown
	 * @param start is the starting index for the reversion . It is inclusive
	 * @param end   is the ending index for the reversion. It is inclusive
	 * @throws IllegalArgumentException if : -word is null or empty -start index is
	 *                                  less then 0 or more then the length of the
	 *                                  word -end index is less then 0 or more then
	 *                                  the length of the word -start index is
	 *                                  greater than end index
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
		String.copyValueOf(word);
		while (start <= middle) {
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;
			start++;
			end--;
		}
	}

	/**
	 * Reverts an array of chars
	 * 
	 * @param word is the char array that needs to be reverted this method
	 *             implements polymorphism, calls the original implementation of the
	 *             method by setting the starting and ending value
	 *             {@link #revert(char[], int, int) revert}
	 */
	public static final void revert(char[] word) {
		checkValidityArray(word);
		Rotator.revert(word, 0, word.length - 1);
	}

	/**
	 * Reverts the order of the whole words in the array of char ,maintaining the number and the order of the spaces
	 * @param word is the char array that needs to be reverted
	 * @throws  IllegalArgumentException
     *          If {@code word} is null,or {@code word} is empty
	 */
	public static final void revertInternWords(char[] word) {
		revert(word);
		int startIndex = -1;
		for (int i = 0; i < word.length; i++) {

			if (startIndex == -1 && word[i] != ' ') {
				startIndex = i;
			} else if (startIndex != -1 && word[i] == ' ') {
				revert(word, startIndex, i - 1);
				startIndex = -1;
			}

		}

		if (startIndex != -1) {
			revert(word, startIndex, word.length - 1);
		}

		System.out.println(word);
	}

	/**
	 * Utility method used to check if the passed argument is valid 
	 * @param word is the argument that needs to be checked
	 * @throws IllegalArgumentException 
	 * 	if the passed argument is null or the passed argument length is equal to '0'
	 */
	private static void checkValidityArray(char[] word) {
		if (word == null) {
			throw new IllegalArgumentException("word cannot be null");
		}
		if (word.length == 0) {
			throw new IllegalArgumentException("word cannot be empty");
		}
	}

}
