package com.softuni;

import java.util.Scanner;

public class ChristmasTree {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= n ; i++) {
            System.out.print(createFrom(" ",n-i));
            System.out.print(createFrom("*",i));
            System.out.print(" | ");
            System.out.print(createFrom("*",i));
            System.out.println(createFrom(" ",n-i));
        }
    }
    public static String createFrom(String sym,int stars){
        StringBuffer toReturn=new StringBuffer();
        for (int i = 0; i < stars; i++) {
            toReturn.append(sym);
        }
        return toReturn.toString();
    }
}
