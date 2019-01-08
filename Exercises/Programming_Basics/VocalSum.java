package com.softuni;

import java.util.Scanner;

public class VocalSum {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        int sumVocal=0;
        for (int i = 0; i <= word.length()-1; i++) {
            switch (word.charAt(i)){
                case 'a':
                    sumVocal+=1;
                    break;
                case 'e':
                    sumVocal+=2;
                    break;
                case 'i':
                    sumVocal+=3;
                    break;
                case 'o':
                    sumVocal+=4;
                    break;
                case 'u':
                    sumVocal+=5;
                        break;
            }
        }
        System.out.println(sumVocal);
    }
}
