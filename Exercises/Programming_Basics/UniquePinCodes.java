package com.softuni;

import java.util.Scanner;

public class UniquePinCodes {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());
        int c=Integer.parseInt(scanner.nextLine());
        for (int i = 2; i <= a; i+=2) {
            for (int j = 2; j <= b; j++) {
                for (int k = 2; k <= c ; k+=2) {
                    if(j==2 || j== 3 || j==5 || j==7)
                    System.out.println(i+" "+j+" "+k);
                }
            }
        }
    }
}
