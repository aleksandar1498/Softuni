package com.softuni;

import java.util.Scanner;

public class ReverseString {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        String [] words=input.split(" ");
        String reversed="";
        for(int i=words.length-1;i>=0;i--){
            reversed=reversed.concat(words[i]+" ");
        }
        System.out.println(reversed);
    }
}
