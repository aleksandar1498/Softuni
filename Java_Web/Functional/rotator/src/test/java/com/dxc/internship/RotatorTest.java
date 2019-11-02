package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RotatorTest {
	static final char[] WORD = { 'a', 'b', 'c', 'd', 'e' };
	static final int WORD_LENGTH = 5;

	@Test
	void revertShouldWorkWithOddLengthArray() {
		char[] original = "ab".toCharArray();
		char[] expected = "ba".toCharArray();
		Rotator.revert(original);
		assertTrue(Arrays.equals(original, expected));
	}

	@ParameterizedTest(name = "{0} reversed should be {1}")
	@MethodSource("evenLengthInput")
	void revertShouldWorkWithEvenLengthArray(String input,String expected) {
		char[] original = input.toCharArray();
		char[] result = expected.toCharArray();
		Rotator.revert(original);
		assertTrue(Arrays.equals(original, result));
	}

	final static Stream<Arguments> evenLengthInput(){
		return Stream.of(
			Arguments.arguments("a","a"),
			Arguments.arguments("abc","cba"),
			Arguments.arguments("abcde","edcba")
		);
	}

	@Test
	void revertShouldThrowExpectedIfNullArrayIsPassed() {
		testInvalidData((a) -> Rotator.revert((char[]) a), null, "word cannot be null");
	}

	@Test
	void revertShouldThrowExpectedIfEmptyArrayIsPassed() {
		testInvalidData((a) -> Rotator.revert((char[]) a), new char[0], "word cannot be empty");
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, WORD_LENGTH })
	void revertShouldThrowExpectedIfInvalidStartIndexIsPassed(int startIndex) {
		testInvalidData((a) -> Rotator.revert(WORD, (int) a, WORD.length), startIndex, "index is out of bounds");
	}

	@ParameterizedTest
	@ValueSource(ints = { -1, -2, Integer.MAX_VALUE, Integer.MIN_VALUE, WORD_LENGTH })
	void rotateShouldThrowExpectedIfInvalidEndIndexIsPassed(int endIndex) {
		testInvalidData((a) -> Rotator.revert(WORD, WORD.length, (int) a), endIndex, "index is out of bounds");
	}

	private void testInvalidData(final Consumer<Object> func, Object arg, String expectedMessage) {
		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
			func.accept(arg);
		}, "Expected IllegalArgumentException was not thrown");
		assertTrue(exc.getMessage().equals(expectedMessage));
	}
}
