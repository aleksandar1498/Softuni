package com.softuni;

import java.util.ArrayList;
import java.util.Scanner;

public class CensuredWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        ArrayList<String> badWords=new ArrayList<String>();
        String input="";
        do{
            System.out.println("Insert a bed word or press 0 to complete your list");
            input=scanner.nextLine();
            if(input.equals("0") == false)
            badWords.add(input);

        }while(input.equals("0") == false);
        System.out.println("Now insert your sentence");
        String sentence = scanner.nextLine();
        for(int i=0;i<=badWords.size()-1;i++){
            System.out.println(badWords.get(i));
            if(sentence.contains(badWords.get(i))){
                System.out.println("Your sentence is censured because it contains the word "+badWords.get(i));
                System.exit(0);
            }
        }
        System.out.println("Your sentence is ok");
    }
}
