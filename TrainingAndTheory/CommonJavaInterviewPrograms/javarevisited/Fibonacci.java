package com.interview.preparation.javarevisited;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Fibonacci {
    private static Map<Integer,Integer> memoization = new TreeMap<>();

    public static void main(String[] args) {
        System.out.println(memoizingFibonacci(7));
    }

    private static int memoizingFibonacci(int n) {
        int fib = -1;
        try {
            fib = memoization.get(n);
        } catch (NullPointerException ex) {
            fib = fibonacci(n);
            memoization.put(n, fib);

        }
        return fib;

    }

    private static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }
}
