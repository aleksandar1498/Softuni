package com.softuni;

import java.util.Scanner;

public class ConcatStings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String a=scanner.nextLine();
        String b=scanner.nextLine();
        System.out.println(a+" "+a.length());
        System.out.println(b+" "+b.length());
        String ab=a.concat(b);
        System.out.println(ab+" "+ab.length());
        if(a.length()+b.length() == ab.length()){
            System.out.println("They are really concatenited");
        }else{
            System.out.println("They are not concatenited");
        }
    }
}
