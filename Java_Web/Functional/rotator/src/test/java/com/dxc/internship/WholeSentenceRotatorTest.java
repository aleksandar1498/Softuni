package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

/**
 *
 * @author Aleksandar Stefanov
 *
 */
class WholeSentenceRotatorTest {

    /**
     * Test if the function works with char array whose length is odd
     *
     * @param input    is the input string , it will be transformed into an array of
     *                 chars.
     * @param expected is the expected result of the function
     *                 {@link com.dxc.internship.Rotator#revert(char[]) rotate}
     *                 applied with argument {@code input}
     */
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
    private static Stream<Arguments> oddLengthInput() {
        return Stream.of(Arguments.arguments("ab", "ba"), Arguments.arguments("abcd", "dcba"),
                Arguments.arguments("ab  cd", "dc  ba"), Arguments.arguments("abcdef", "fedcba"));
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
    private static Stream<Arguments> evenLengthInput() {
        return Stream.of(Arguments.arguments("a", "a"), Arguments.arguments("abc", "cba"),
                Arguments.arguments("abcde", "edcba"), Arguments.arguments("ab c de", "ed c ba"));
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

    @Test
    void shouldThrowIfNullIsPassed() {
        checkInvalidData((a) -> Rotator.revert(a), null, "sentence cannot be null");
    }

    @Test
    void shouldThrowIfEmptyCharArrayIsPassed() {
        checkInvalidData((a) -> Rotator.revert(a), new char[0], "sentence cannot be empty");
    }

    private static void checkInvalidData(final Consumer<char[]> func, final char[] input,
            final String expectedMessage) {
        final IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            func.accept(input);
        }, "Expected IllegalArgumentException was not thrown");

        assertTrue(expectedMessage.equals(exc.getMessage()));
    }
}
