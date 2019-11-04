/**
 *
 */
package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 * @author Aleksandar Stefanov
 *
 */
class PartialSentenceRotatorTest {
    /**
     * Test if the function works with char array whose length is odd
     *
     * @param input    is the input string , it will be transformed into an array of
     *                 chars.
     * @param expected is the expected result of the function
     *                 {@link com.dxc.internship.Rotator#revert(char[]) rotate}
     *                 applied with argument {@code input}
     */
    @SuppressWarnings("static-method")
    @ParameterizedTest(name = "{0} reversed should be {1}")
    @MethodSource("oddLengthInput")
    @DisplayName("revertWithOddCountElement")
    void revertShouldWorkWithOddLengthArray(final String input, final String expected) {
        checkRevert((a) -> Rotator.revert(a), input, expected);
    }

    /**
     * @return a stream of Arguments that will be used for the ParameterizedTest
     *         {@link RotatorTest#revertShouldWorkWithOddLengthArray(String, String)
     *         test}
     */
    @SuppressWarnings("nls")
    private static Stream<Arguments> oddLengthInput() {
        return Stream.of(Arguments.arguments("ab", "ba"), Arguments.arguments("abcd", "dcba"),
                Arguments.arguments("abcdef", "fedcba"));
    }

    /**
     * Test if the function works with char array whose length is even
     *
     * @param input    is the input string , it will be transformed into an array of
     *                 chars.
     * @param expected is the expected result of the function
     *                 {@link com.dxc.internship.Rotator#revert(char[]) rotate}
     *                 applied with argument {@code input}
     */
    @SuppressWarnings("static-method")
    @ParameterizedTest(name = "even {0} reversed should be {1}")
    @MethodSource("evenLengthInput")
    @DisplayName("revertWithEvenCountElement")
    void revertShouldWorkWithEvenLengthArray(final String input, final String expected) {
        checkRevert((a) -> Rotator.revert(a), input, expected);
    }

    /**
     * @return a stream of Arguments that will be used for the ParameterizedTest
     *         {@link RotatorTest#revertShouldWorkWithEvenLengthArray(String, String)
     *         test}
     */
    @SuppressWarnings("nls")
    private static Stream<Arguments> evenLengthInput() {
        return Stream.of(Arguments.arguments("a", "a"), Arguments.arguments("abc", "cba"),
                Arguments.arguments("abcde", "edcba"));
    }

    /**
     * Check if once the {@code func} accepts {@code input} the results is
     * {@code expected}
     *
     * @param func     lambda function that will accept the input and transform it
     *                 without returning any result
     * @param input    is the original sentence that will be passed to revert
     * @param expected is the expected result of the func once accepted the input
     */
    private static void checkRevert(final Consumer<char[]> func, final String input, final String expected) {
        final char[] original = input.toCharArray();
        final char[] result = expected.toCharArray();
        func.accept(original);
        assertTrue(Arrays.equals(original, result));
    }

    /**
     * Test if revert from index start to end is performed correctly. We test three
     * situations : start to inner inner to inner inner to end
     *
     * @param input    is the char array that will be reverted
     * @param expected is the expected result
     * @param start    is the starting index
     * @param end      is the ending index
     */
    @SuppressWarnings({ "static-method", "boxing" })
    // I've used carrying in order to achieve a function with multiple elements .
    @ParameterizedTest(name = "{0} reverted should be {1}")
    @MethodSource("methodSourceForRevertFromStartIndexToEndIndexWithInternIndexes")
    void revertFromStartIndexToEndIndex(final String input, final String expected, final int start, final int end) {
        final Function<char[], Function<Integer, Consumer<Integer>>> func = arr -> st -> en -> {
            Rotator.revert(arr, st, en);
        };
        checkRevert(func, input, expected, start, end);
        // Rotator.revert(original, start, end);

    }

    /**
     * @return a stream of Arguments that will be used for the ParameterizedTest
     *         {@link RotatorTest#revertFromStartIndexToEndIndex(String, String, int, int)
     *         test}
     */
    @SuppressWarnings({ "nls", "boxing" })
    private static Stream<Arguments> methodSourceForRevertFromStartIndexToEndIndexWithInternIndexes() {
        return Stream.of(Arguments.arguments("abcde", "adcbe", 1, 3), Arguments.arguments("abcde", "acbde", 1, 2));
    }

    /**
     * Check if once the {@code func} is processed the result is {@code expected}
     *
     * @param func     lambda function that will accept the input,the starting
     *                 index,ending index and transform it without returning any
     *                 result
     * @param input    is the original sentence that will be passed to revert
     * @param expected is the expected result of the func once accepted the input
     * @start is the starting index for the reversion
     * @end is the ending index for the reversion
     */
    // Function<Double, Function<Integer, Consumer<String>>>
    @SuppressWarnings("boxing")
    private static void checkRevert(final Function<char[], Function<Integer, Consumer<Integer>>> func,
            final String input, final String expected, final int start, final int end) {
        final char[] original = input.toCharArray();
        final char[] result = expected.toCharArray();
        func.apply(original).apply(start).accept(end);
        assertTrue(Arrays.equals(original, result));
    }

    /**
     * Test if the revert function throws the expected error if a null argument is
     * passed
     */
    @SuppressWarnings({ "nls", "static-method" })
    @Test
    void revertShouldThrowExpectedIfNullArrayIsPassed() {
        testInvalidCharArray((a) -> Rotator.revert(a), null, "sentence cannot be null");
    }

    /**
     * Test if the revert function throws the expected error if an empty argument is
     * passed
     */
    @SuppressWarnings("nls")
    @Test
    static void revertShouldThrowExpectedIfEmptyArrayIsPassed() {
        testInvalidCharArray((a) -> Rotator.revert(a), new char[0], "sentence cannot be empty");
    }

    /**
     * @param func            performed on the argument
     * @param arg             is the value that needs to be accepted by the function
     * @param expectedMessage is the expected message of the Error thrown
     */
    @SuppressWarnings("nls")
    private static void testInvalidCharArray(final Consumer<char[]> func, final char[] arg,
            final String expectedMessage) {
        final IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            func.accept(arg);
        }, "Expected IllegalArgumentException was not thrown");
        assertEquals(expectedMessage, exc.getMessage());
    }

    /**
     * Test if the revert function throws the expected error if the starting index
     * is invalid
     */
    @SuppressWarnings("static-method")
    @ParameterizedTest(name = "{0} starting index should throw error")
    @MethodSource("invalidIndexArguments")
    void revertShouldThrowExpectedIfInvalidStartIndexIsPassed(final String sentence, final int startIndex) {
        final char[] words = sentence.toCharArray();
        testInvalidSentence((a) -> Rotator.revert(words, a, words.length - 1), startIndex, "index is out of bounds");
    }

    /**
     * Test if the revert function throws the expected error if the ending index is
     * invalid
     */
    @SuppressWarnings("static-method")
    @ParameterizedTest(name = "{0} end index should throw error")
    @MethodSource("invalidIndexArguments")
    void rotateShouldThrowExpectedIfInvalidEndIndexIsPassed(final String sentence, final int endIndex) {
        final char[] words = sentence.toCharArray();
        testInvalidSentence((a) -> Rotator.revert(words, words.length - 1, a), endIndex, "index is out of bounds");
    }

    @SuppressWarnings({ "boxing", "nls" })
    static Stream<Arguments> invalidIndexArguments() {
        return Stream.of(Arguments.arguments("text", -1), Arguments.arguments("text", -2),
                Arguments.arguments("text", Integer.MAX_VALUE), Arguments.arguments("text", Integer.MIN_VALUE));
    }

    /**
     * @param func            performed on the argument
     * @param arg             is the value that needs to be accepted by the function
     * @param expectedMessage is the expected message of the Error thrown
     */
    @SuppressWarnings("nls")
    private static void testInvalidSentence(final Consumer<Integer> func, final Integer arg,
            final String expectedMessage) {
        final IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            func.accept(arg);
        }, "Expected IllegalArgumentException was not thrown");
        assertEquals(expectedMessage, exc.getMessage());
    }

    /**
     * Test if the revert function throws the expected error if the ending index is
     * invalid
     */
    @SuppressWarnings("nls")
    @ParameterizedTest(name = "{0} end index should throw error")
    @MethodSource("startIndexGreaterThanEndArguments")
    void revertShouldThrowExpectedIfStartIndexIsGreaterThenEndIndex(final int startIndex, final int endIndex) {
        final char[] words = "alex".toCharArray();
        testInvalidSentence((a, b) -> Rotator.revert(words, a, b), startIndex, endIndex,
                "start cannot be after the end");
    }

    static Stream<Arguments> startIndexGreaterThanEndArguments() {
        return Stream.of(Arguments.arguments(2, 1), Arguments.arguments(1, 0));
    }

    /**
     * @param func            performed on the argument
     * @param arg             is the value that needs to be accepted by the function
     * @param expectedMessage is the expected message of the Error thrown
     */
    @SuppressWarnings("nls")
    private static void testInvalidSentence(final BiConsumer<Integer, Integer> func, final Integer start,
            final Integer end, final String expectedMessage) {
        final IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            func.accept(start, end);
        }, "Expected IllegalArgumentException was not thrown");
        assertEquals(expectedMessage, exc.getMessage());
    }
}
