package com.softuni;

import java.util.Scanner;

public class PalindromString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        boolean palindrome=true;
        for (int i = 0; i < word.length(); i++) {
            if(word.charAt(i) != word.charAt(word.length()-1-i)){
palindrome=false;
            }
        }
        if(palindrome){
            System.out.println("It is palindrome");
        }else{
            System.out.println("It is not palindrome");
        }
    }
}
