package com.softuni;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class LettersCombination {
    public static void main(String[] args) {
        //BufferedReader input=new BufferedReader(new InputStreamReader(System.in));
Scanner scanner=new Scanner(System.in);

            char initialLetter=scanner.next().charAt(0);

            int finalLetter=scanner.next().charAt(0);


            int letterToAvoid=scanner.next().charAt(0);
            int c=0;

            for (char i = (char)initialLetter; i < (char)finalLetter; i++) {
                for (char j = (char)initialLetter; j < (char)finalLetter; j++) {
                    for (char k = (char)initialLetter; k < (char)finalLetter; k++) {
                        if(!String.valueOf(i+""+j+""+k).contains(String.valueOf(letterToAvoid))){
                            System.out.println(i+""+j+""+k+" ");
                            c++;
                        }

                    }

                }
            }
        System.out.println(c);


    }
}
