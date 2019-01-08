package com.softuni.arrays;

import java.util.Scanner;

public class FrequenceCharacter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String word=scanner.nextLine();
        char letter=scanner.nextLine().charAt(0);
        int count=0;
        for(char letterInWord:word.toCharArray()){
            if(letterInWord == letter){
                count++;
            }
        }
        System.out.println("The frequence is "+count);
    }
}
