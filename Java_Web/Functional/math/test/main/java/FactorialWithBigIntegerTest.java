package main.java;

import main.functional.interfaces.IntToBigInteger;
import org.junit.jupiter.api.Test;
import java.math.BigInteger;
import static org.junit.jupiter.api.Assertions.*;

class FactorialWithBigIntegerTest {


    @Test
    void iterativeForZero() {
        FactorialWithBigIntegerTest.checkForZero(FactorialWithBigInteger::factorialIterative);
    }

    @Test
    void recursiveForZero() {
        FactorialWithBigIntegerTest.checkForZero(FactorialWithBigInteger::factorialRecursive);
    }

    private static void checkForZero(IntToBigInteger function){
        assertEquals(function.applyAsBigInteger(0), BigInteger.ONE);
    }

    @Test
    void iterativeShouldReturnInvalidForLessThenZero() {
        FactorialWithBigIntegerTest.checkForLessThenZero(FactorialWithBigInteger::factorialIterative);
    }
    @Test
    void recursiveShouldReturnInvalidForLessThenZero() {
        FactorialWithBigIntegerTest.checkForLessThenZero(FactorialWithBigInteger::factorialRecursive);
    }

    private static void checkForLessThenZero(IntToBigInteger function){
        assertThrows(IllegalArgumentException.class,() -> function.applyAsBigInteger(-1));
    }




}