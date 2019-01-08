package com.softuni;

import java.util.Scanner;

public class ReplaceWords {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String words=scanner.nextLine();
        String wordToReplace=scanner.nextLine();
        String newWord=scanner.nextLine();
        if(words.contains(wordToReplace)){
            System.out.println("In");
           words=  words.replace(wordToReplace,newWord);


        }else{
            System.out.println("Your word is not taking part in the line");
        }
        System.out.println(words);
    }
}
