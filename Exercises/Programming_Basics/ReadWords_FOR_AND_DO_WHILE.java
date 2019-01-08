package com.softuni;

import java.util.Scanner;

public class ReadWords_FOR_AND_DO_WHILE {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String input="";
        // By using while
        System.out.println("WHILE");
        while(!input.equals("fine")){
            input=scanner.nextLine();
            if(input.charAt(0) == input.charAt(input.length()-1)){
                System.out.println("The first and the last character are the same");
            }
        }
        // by using do-while
        System.out.println("DO WHILE");
        do{
            input=scanner.nextLine();
            if(input.charAt(0) == input.charAt(input.length()-1)){
                System.out.println("The first and the last character are the same");
            }

        }while(!input.equals("fine"));
    }
}
