package com.softuni;

import java.util.Scanner;

public class ChristmasHat {
    public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
     int n=Integer.parseInt(scanner.nextLine());;
        System.out.print(drawForm(n*2-1,"."));
        System.out.print("/|\\");
        System.out.println(drawForm(n*2-1,"."));
        System.out.print(drawForm(n*2-1,"."));
        System.out.print("\\|/");
        System.out.println(drawForm(n*2-1,"."));
        for (int i = 0; i < n*2; i++) {
            if(i==0){
                System.out.print(drawForm(n*2-1-i,"."));
                System.out.print(drawForm(3,"*"));
                System.out.println(drawForm(n*2-1-i,"."));
            }else{
                System.out.print(drawForm(n*2-1-i,"."));
                System.out.print("*");
                System.out.print(drawForm(i,"-"));

                System.out.print("*");
                System.out.print(drawForm(i,"-"));
                System.out.print("*");
                System.out.println(drawForm(n*2-1-i,"."));

            }

        }
        System.out.println(drawForm(n*4+1,"*"));
        System.out.println(drawAlternateForm(n*4+1,"*","."));
        System.out.println(drawForm(n*4+1,"*"));

    }
    public static String drawForm(int n,String sym){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < n; i++) {
            sb.append(sym);
        }
        return sb.toString();
    }
    public static String drawAlternateForm(int n,String symA,String symB){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < n; i++) {
            if(i%2 == 0){
                sb.append(symA);
            }else{
                sb.append(symB);
            }

        }
        return sb.toString();
    }
}
