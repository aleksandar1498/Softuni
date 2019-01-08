package com.softuni;

import java.util.Scanner;

public class FirstCommonLetter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        while(commonLetter(a,b) != a.charAt(0)){
            a=scanner.nextLine();
            b=scanner.nextLine();
        }
    }
    public static char commonLetter(String a,String b){
        char common='*';
        for (int i = 0; i < Math.min(a.length(),b.length()) ; i++) {
            if(a.charAt(i) == b.charAt(i)){
                common=a.charAt(i);
                break;
            }
        }
        return  common;
    }
}
