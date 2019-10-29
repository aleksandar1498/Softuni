/**
 *
 */
package main.java;

/**
 * @author astefanov2
 *
 */
public class Factorial {

    public static long factorialRecursive(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid argument exception");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        return n * factorialRecursive(n - 1);
    }

    public static long factorialIterative(int n) {
        if (n < 0 || n > 20) {
            throw new IllegalArgumentException("Invalid argument exception");
        }
        if (n == 0 || n == 1) {
            return 1;
        }

        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }
}
