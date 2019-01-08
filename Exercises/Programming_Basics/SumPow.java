package com.softuni;

import java.util.Scanner;

public class SumPow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
       int n=Integer.parseInt(scanner.nextLine());
       for(int i=0;i<=n;i++){
           System.out.println(Math.pow(i,2));
       }
        System.out.println();
    }
}
