package com.softuni;

import java.util.Scanner;

public class CharCombinationExceptLetter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char startLetter = scanner.nextLine().charAt(0);
        char finalLetter = scanner.nextLine().charAt(0);
        char letterToAvoid = scanner.nextLine().charAt(0);
        int validNumbers=0;
for(char a=startLetter;a<=finalLetter;a++){
    for(char b=startLetter;b<=finalLetter;b++){
        for(char c=startLetter;c<=finalLetter;c++){
            if(a != letterToAvoid && b != letterToAvoid && c!=letterToAvoid){
                System.out.println(a+""+b+""+c);
                validNumbers++;
            }
        }
    }
}
        System.out.println(validNumbers);

    }
}
