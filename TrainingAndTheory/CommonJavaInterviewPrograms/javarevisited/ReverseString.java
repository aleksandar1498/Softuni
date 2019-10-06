package com.interview.preparation.javarevisited;

public class ReverseString {
    public static void main(String[] args) {
        String word = "alex";

        StringBuilder stringBuilder = new StringBuilder(word);
        System.out.println(stringBuilder.reverse());

        // The algorithmic variant
        String reversed = "";
        for (int i = word.length() - 1; i >= 0; i--) {
            reversed+=word.charAt(i);
        }
        System.out.println(reversed);
    }
}
