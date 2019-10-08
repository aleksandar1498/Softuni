package com.interview.preparation.softwaretestinghelp;

import java.util.Scanner;

public class IsPalindromeString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        System.out.println(isPalindrome(word));
    }
    private static boolean isPalindrome(String word){
        word = word.toLowerCase();
        int mid = (int)Math.floor(word.length()/2.0);
        for(int i=0;i<mid;i++){
            if(word.charAt(i) != word.charAt(word.length()-i-1)){
                return false;
            }
        }
        return true;
    }
}
