package com.interview.preparation.javarevisited;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println(isPrime(6));
    }
    private static boolean isPrime(int n) {
        int divisors = 1;
        if(n == 2 || n == 3){
            return  true;
        }
        if(n%2 == 0){
            return false;
        }
        int sqrt = (int) Math.sqrt(n);
        for (int i = 3; i < Math.sqrt(n); i+=2) {
            if(n%i == 0){
                    return false;
            }
        }
        return true;
    }
}
