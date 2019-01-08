package com.softuni;

import java.util.Scanner;

public class StringContains {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String sentence=scanner.nextLine();
        if(sentence.charAt(sentence.length()-1) == '?'){
            if(sentence.length() %2 == 0){
                System.out.println("SI");
            }else{
                System.out.println("No");
            }
        }else if(sentence.charAt(sentence.length()-1) == '!'){
            System.out.println("WOW");
        }else{
            System.out.println("You always say \""+sentence+"\"");
        }
    }
}
