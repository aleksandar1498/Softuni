package com.dxc.internship;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.Consumer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RotatorTest {
	static final char [] WORD = {'a','b','c','d','e'}; 
	static final int WORD_LENGTH = 5;
	@Test
	void rotateShouldThrowExpectedIfNullArrayIsPassed() {
		testInvalidData((a) -> Rotator.revert((char[])a), null, "word cannot be null");
	}

	@Test
	void rotateShouldThrowExpectedIfEmptyArrayIsPassed() {
		testInvalidData((a) -> Rotator.revert((char[])a), new char[0], "word cannot be empty");
	}
	
	@ParameterizedTest
	@ValueSource(ints = {-1,-2,Integer.MAX_VALUE,Integer.MIN_VALUE,WORD_LENGTH})
	void rotateShouldThrowExpectedIfInvalidStartIndexIsPassed(int startIndex) {
		testInvalidData((a) -> Rotator.revert(WORD,(int)a,WORD.length),startIndex,"index is out of bounds");
	}
	@ParameterizedTest
	@ValueSource(ints = {-1,-2,Integer.MAX_VALUE,Integer.MIN_VALUE,WORD_LENGTH})
	void rotateShouldThrowExpectedIfInvalidEndIndexIsPassed(int endIndex) {
		testInvalidData((a) -> Rotator.revert(WORD,WORD.length,(int)a),endIndex,"index is out of bounds");
	}
	
	private void testInvalidData(final Consumer<Object> func, Object arg, String expectedMessage) {
		IllegalArgumentException exc = assertThrows(IllegalArgumentException.class, () -> {
			func.accept(arg);
		}, "Expected IllegalArgumentException was not thrown");
		assertTrue(exc.getMessage().equals(expectedMessage));
	}
}
