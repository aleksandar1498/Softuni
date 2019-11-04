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
final class WordInSentenceRotatorTest {

    /**
     * Test if words in a sentence (array of chars) are reverted correctly,
     * maintaining the position of the spaces and symbols
     *
     * @param input    is the word that will be reverted once transformed to char of
     *                 arrays
     * @param expected
     */
    @ParameterizedTest(name = " {0}  reverted should be {1}")
    @DisplayName("revertOfWordsPresentInAnCharArray")
    @MethodSource("methodSourceForRevertInternWords")
    static void revertInternWordsShouldReturnRevertedWordsInAnArrayOfChars(final String input, final String expected) {
        checkRevert(a -> Rotator.revertInternWords(a), input, expected);
    }

    /**
     * @return a stream of Arguments that will be used for the ParameterizedTest
     *         {@link RotatorTest#revertInternWordsShouldReturnRevertedWordsInAnArrayOfChars(String, String)
     *         test}
     */
    @SuppressWarnings("nls")
    private static Stream<Arguments> methodSourceForRevertInternWords() {
        return Stream.of(Arguments.arguments("alex", "alex"), Arguments.arguments("alex!@#Ales", "alex!@#Ales"),
                Arguments.arguments("I am alex", "alex am I"), Arguments.arguments(" ", " "),
                Arguments.arguments("   ", "   "), Arguments.arguments(" I am alex", "alex am I "),
                Arguments.arguments("I   am alex", "alex am   I"), Arguments.arguments("I am alex ", " alex am I"));
    }

    private static void checkRevert(final Consumer<char[]> func, final String input, final String expected) {
        final char[] original = input.toCharArray();
        final char[] result = expected.toCharArray();
        func.accept(original);
        assertTrue(Arrays.equals(original, result));
    }

    @SuppressWarnings("static-method")
    @Test
    void shouldThrowIfNullIsPassed() {
        checkInvalidData((a) -> Rotator.revertInternWords(a), null, "sentence cannot be null");
    }

    @SuppressWarnings("static-method")
    @Test
    void shouldThrowIfEmptyCharArrayIsPassed() {
        checkInvalidData((a) -> Rotator.revertInternWords(a), new char[0], "sentence cannot be empty");
    }

    private static void checkInvalidData(final Consumer<char[]> func, final char[] input,
            final String expectedMessage) {
        final IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
            func.accept(input);
        }, "Expected IllegalArgumentException was not thrown");

        assertTrue(expectedMessage.equals(exc.getMessage()));
    }

}
