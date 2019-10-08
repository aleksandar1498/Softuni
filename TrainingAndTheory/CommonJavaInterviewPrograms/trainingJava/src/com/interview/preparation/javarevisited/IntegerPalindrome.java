package com.interview.preparation.javarevisited;

import java.util.ArrayList;
import java.util.List;

public class IntegerPalindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome(10012));
    }

    private static boolean isPalindrome(int palindrome) {
        int reversed = 0;
        int original = palindrome;
        while(palindrome != 0){
            int reminder = palindrome % 10;
            reversed = reversed*10+reminder;
            palindrome /= 10;
        }
        System.out.println(reversed);
        return reversed == original;
    }

    /*
    private static boolean isPalindrome(int n) {
        List<Integer> mappedNumber = mapNumber(n);
        for (int i = 0; i < Math.floor(mappedNumber.size() / 2.0); i++) {
            if (mappedNumber.get(i)-mappedNumber.get(mappedNumber.size() - i-1) != 0) {
                return false;
            }
        }
        return true;
    }

    private static List<Integer> mapNumber(int n) {
        List<Integer> mappedNumber = new ArrayList<>();
        while (n / 10 > 0) {
            mappedNumber.add(n % 10);
            n /= 10;
        }
        mappedNumber.add(n % 10);
        return mappedNumber;
    }*/
}
