package com.interview.preparation.softwaretestinghelp;

import java.util.LinkedHashMap;
import java.util.Map;

public class Fibonacci {
    private static Map<Integer,Integer> cache = new LinkedHashMap<>();
    public static void main(String[] args) {
        System.out.println(fibonacci(3));
        System.out.println(fibonacciWithMemo(3));
        System.out.println(fibonacciWithoutRecursion(3));
    }
    private static int fibonacciWithoutRecursion(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        int n1 = 1;
        int n2 = 1;
        for(int i = 2 ; i < n ; i++){
            n1 = n2;
            n2+= i;
        }
        return n2;
    }
    private static int fibonacci(int n){
        if(n == 0){
            return 0;
        }
        if(n == 1 || n == 2){
            return 1;
        }
        return fibonacci(n-1)+fibonacci(n-2);
    }
    private static int fibonacciWithMemo(int n){
       if(cache.get(n) != null){
           return cache.get(n);
       }
       int fib = fibonacci(n);
       cache.put(n,fib);
       return fib;
    }
}
