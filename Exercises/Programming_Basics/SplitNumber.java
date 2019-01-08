package com.softuni;

import java.util.Scanner;

public class SplitNumber {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        String nS=String.valueOf(n);
        for(int i=0;i<=nS.length()-1;i++){
            System.out.println(nS.charAt(i));
        }
        //System.out.println(n%1000);
        int temp=n;

        while(n>0){
            int digit=n%10;
            System.out.println(digit);
            n/=10;
        }


    }
}
