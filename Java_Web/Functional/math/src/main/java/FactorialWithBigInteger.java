package main.java;

import java.math.BigInteger;

public class FactorialWithBigInteger {
	public static void main(String [] args) {
		for(int i=0;i<1000;i++) {
			System.out.println(FactorialWithBigInteger.factorialRecursive(i));	
		}
	
	}
	public static BigInteger factorialRecursive(int n) {
		checkValid(n);
		if (n == 0 || n == 1) {
			return BigInteger.ONE;
		}
		return BigInteger.valueOf(n).multiply(factorialRecursive(n-1));
	}
	
	public static BigInteger factorialIterative(int n) {
		checkValid(n);
		if (n == 0 || n == 1) {
			return BigInteger.ONE;
		}
		
		
		return BigInteger.valueOf(n).multiply(factorialRecursive(n-1));
	}
	private static void checkValid(int n){
		if (n < 0 ) {
			throw new IllegalArgumentException("Invalid argument exception");
		}
	}
}
