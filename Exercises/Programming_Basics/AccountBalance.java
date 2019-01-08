package com.softuni;

import java.util.Scanner;

public class AccountBalance {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int k=0;
        double balance=0.0;
        while(k<n){
            double importVal=Double.parseDouble(scanner.nextLine());
            System.out.printf("Increase : %.2f\n",importVal);
            balance+=importVal;
            k++;
        }
        System.out.printf("Total: %.2f",balance);
    }
}
