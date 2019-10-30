/**
 * 
 */
package main.java;

import static org.junit.jupiter.api.Assertions.*;

import java.lang.reflect.Executable;
import java.math.BigInteger;
import java.util.concurrent.Executor;
import java.util.function.IntToLongFunction;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;


/**
 * @author astefanov2
 *
 */

class FactorialTest {

	
	@Test
	void iterativeForZero() {
		FactorialTest.checkForZero(Factorial::factorialIterative);
	}
	
	@Test
	void recursiveForZero() {
		FactorialTest.checkForZero(Factorial::factorialRecursive);
	}

	private static void checkForZero(IntToLongFunction function){
		assertEquals(function.applyAsLong(0), 1);
	}
	
	@Test
	void iterativeShouldReturnInvalidForLessThenZero() {
		FactorialTest.checkForLessThenZero(Factorial::factorialIterative);
	}
	@Test
	void recursiveShouldReturnInvalidForLessThenZero() {
		FactorialTest.checkForLessThenZero(Factorial::factorialRecursive);
	}

	private static void checkForLessThenZero(IntToLongFunction function){
		assertThrows(IllegalArgumentException.class,() -> function.applyAsLong(-1));
	}

	@ParameterizedTest
	@ValueSource(ints = {21,100,1000, Integer.MAX_VALUE})
	void recursiveForHighestValue(int number) {
		FactorialTest.checkForTopValue(Factorial::factorialRecursive,number);
	}

	@ParameterizedTest
	@ValueSource(ints = {21,100,1000, Integer.MAX_VALUE})
	void iterativeForHighestValue(int number) {
		FactorialTest.checkForTopValue(Factorial::factorialIterative,number);
	}
	private static void checkForTopValue(IntToLongFunction function,int value){
		assertThrows(IllegalArgumentException.class , () -> function.applyAsLong(value));
	}

	@Test
	void recursiveForMultiple() {
		FactorialTest.checkEquality(Factorial::factorialRecursive);
	}
	@Test
	void iterativeForMultiple() {
		FactorialTest.checkEquality(Factorial::factorialIterative);
	}
	
	private static void checkEquality(IntToLongFunction val) {
		long [] expected= {
				1,
				1,
				2,
				6,
				24,
				120,
				720,
				5040,
				40320,
				362880,
				3628800,
				39916800,
				479001600,
				6227020800L,
				87178291200L,
				1307674368000L,
				20922789888000L,
				355687428096000L,
				6402373705728000L,
				121645100408832000L,
				2432902008176640000L,
		};
		
		for(int i=0;i<expected.length;i++) {
			assertEquals(expected[i],val.applyAsLong(i));
		}
	}


	/*
		Notes

		Extended version
	 */
	@Test
	void recursiveForTen() {
		IntToLongFunction factTest = (int val) -> {
			return Factorial.factorialRecursive(val);
		};
		assertEquals(factTest.applyAsLong(10),3628800);
	}


}
