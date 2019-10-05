package com.interview.preparation.javarevisited;

public class Palindrome {
    public static void main(String[] args) {
        System.out.println(isPalindrome("radaras"));
    }
     static boolean  isPalindrome(String word){
        char[] splitWord = word.toLowerCase().toCharArray();

        for(int i=0;i< Math.floor(splitWord.length/2.0);i++){
            if(splitWord[i] != splitWord[splitWord.length-i-1]){
                return false;
            }
        }
        return true;
    }
}
