package com.softuni;

import java.util.Scanner;

public class GreaterCommonDivisor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());;
        int b=Integer.parseInt(scanner.nextLine());;
        while(b != 0){
            int tmp=a;
            a=b;
            b=tmp%b;
        }
        System.out.println(a);
    }
}
