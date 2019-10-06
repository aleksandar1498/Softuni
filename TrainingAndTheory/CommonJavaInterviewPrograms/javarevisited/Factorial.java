package com.interview.preparation.javarevisited;

import java.util.Map;
import java.util.TreeMap;

public class Factorial {
    static Map<Integer, Integer> cache = new TreeMap<>();

    public static void main(String[] args) {
        long startTime = System.nanoTime();
        System.out.println(factorial(5));
        long elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);
        startTime = System.nanoTime();
        System.out.println(factorial(5));
        elapsedTime = System.nanoTime() - startTime;
        System.out.println(elapsedTime);
    }

    private static int factorialWithMemoization(int n) {
        int fact = -1;
        try {
            fact = cache.get(n);
        } catch (NullPointerException ex) {
            fact = factorial(n);
            cache.put(n, fact);
        }
        return fact;
    }

    private static int factorial(int n) {
        if (n == 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
}
