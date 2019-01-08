package com.softuni;

import java.util.Scanner;

public class MultiplyTable {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int digit3=n%10;
        n/=10;
        int digit2=n%10;
        n/=10;
        int digit1=n%10;
        for (int i = 1; i <= digit3 ; i++) {
            for (int j = 1; j <= digit2; j++) {
                for (int k = 1; k <= digit1 ; k++) {
                    System.out.printf("%d * %d * %d = %d;\n",i,j,k,i*j*k);
                }
            }
        }
    }
}
