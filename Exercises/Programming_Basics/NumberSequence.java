package com.softuni;

import java.util.Scanner;

public class NumberSequence {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String n=scanner.nextLine();
        int min=Integer.MAX_VALUE;

        int max=Integer.MIN_VALUE;
       while(!n.equals("END")){

           if(Integer.parseInt(n)< min){
               min=Integer.parseInt(n);
           }else if(Integer.parseInt(n) > max){
               max=Integer.parseInt(n);
           }
           n=scanner.nextLine();
       }
        System.out.printf("Max number: %d\nMin number: %d",max,min);
    }
}
