package com.softuni;

import java.util.Scanner;

public class WordToTheEnd {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String sentence=scanner.nextLine();
        String word=sentence.substring(0,sentence.indexOf(" "));
        sentence=sentence.substring(sentence.indexOf(" ")+1,sentence.length()).concat(" "+word);
        System.out.println(word+" \n"+sentence);
    }
}
