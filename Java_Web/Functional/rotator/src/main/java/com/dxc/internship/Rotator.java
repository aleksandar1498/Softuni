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
     * Reverts an array of chars from {@code start} index to {@code end} index
     *
     * @param sentence is the char array that needs to be reverted. If it is null or
     *                 empty array an IllegalArgumentExceptionIsThrown
     * @param start    is the starting index for the reversion . It is inclusive
     * @param end      is the ending index for the reversion. It is inclusive
     * @throws IllegalArgumentException if : -word is null or empty -start index is
     *                                  less then 0 or more then the length of the
     *                                  word -end index is less then 0 or more then
     *                                  the length of the word -start index is
     *                                  greater than end index
     */
    public static void revert(final char[] sentence, final int start, final int end) {
        checkValidityArray(sentence);
        checkIndexValidity(sentence, start, end);
        revertFragment(sentence, start, end);
    }

    private static int middleIndex(final int start, final int end) {
        return start + (end - start) / 2;
    }

    private static void revertFragment(final char[] sentence, final int start, final int end) {
        int i = 0;
        final int middle = middleIndex(start, end);
        while (start + i <= middle) {
            final char temp = sentence[start + i];
            sentence[start + i] = sentence[end - i];
            sentence[end - i] = temp;
            i++;
        }
    }

    /**
     * Reverts an array of chars
     *
     * @param sentence is the char array that needs to be reverted this method
     *                 implements polymorphism, calls the original implementation of
     *                 the method by setting the starting and ending value
     *                 {@link #revert(char[], int, int) revert}
     */
    public static void revert(final char[] sentence) {
        checkValidityArray(sentence);
        Rotator.revert(sentence, 0, sentence.length - 1);
    }

    /**
     * Reverts the order of the whole words in the array of char ,maintaining the
     * number and the order of the spaces
     *
     * @param word is the char array that needs to be reverted
     * @throws IllegalArgumentException If {@code word} is null,or {@code word} is
     *                                  empty
     */
    public static void revertInternWords(final char[] word) {
        Rotator.revert(word);
        int startIndex = -1;
        for (int i = 0; i < word.length; i++) {

            if (isWordFound(startIndex) == false && !isDelimiter(word, i)) {
                startIndex = i;
            } else if (isWordFound(startIndex) && isDelimiter(word, i)) {
                revert(word, startIndex, i - 1);
                startIndex = -1;
            }

        }

        if (isWordFound(startIndex)) {
            revert(word, startIndex, word.length - 1);
        }

    }

    private static boolean isWordFound(final int startIndex) {
        return startIndex != -1;
    }

    private static boolean isDelimiter(final char[] word, final int i) {
        return word[i] == ' ';
    }

    /**
     * Utility method used to check if the passed argument is valid
     *
     * @param word is the argument that needs to be checked
     * @throws IllegalArgumentException if the passed argument is null or the passed
     *                                  argument length is equal to '0'
     */

    private static void checkValidityArray(final char[] sentence) {
        if (sentence == null) {
            throw new IllegalArgumentException("sentence cannot be null");
        }
        if (sentence.length == 0) {
            throw new IllegalArgumentException("sentence cannot be empty");
        }

    }

    private static void checkIndexValidity(final char[] sentence, final int start, final int end) {
        checkIndexValidity(sentence, start);
        checkIndexValidity(sentence, end);
        checkIndexValidity(start, end);
    }

    private static void checkIndexValidity(final char[] sentence, final int index) {
        if (index < 0 || index >= sentence.length) {
            throw new IllegalArgumentException("index is out of bounds");

        }
    }

    private static void checkIndexValidity(final int start, final int end) {
        if (start > end) {
            throw new IllegalArgumentException("start cannot be after the end");
        }
    }

}
