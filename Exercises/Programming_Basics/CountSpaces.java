package com.softuni;

import java.util.Scanner;

public class CountSpaces {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input=scanner.nextLine();
        int spaces=0;
        for(int i=0;i<=input.length()-1;i++){
            if(input.charAt(i) == ' '){
                spaces++;
            }
        }
        System.out.println(spaces);

    }
}
