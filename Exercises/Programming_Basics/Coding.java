package com.softuni;

import java.util.Scanner;

public class Coding {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int val = Integer.parseInt(scanner.nextLine());
        for (int i = val; i >0 ; i/=10) {
            int digit = i%10;
            if (digit == 0) {
                System.out.println("ZERO");
            } else {
                for (int j = 0; j < digit; j++) {
                    System.out.print((char) (digit + 33));
                }
                System.out.println();
            }
        }
       /* while (val > 0) {
            int digit = val % 10;
            val /= 10;
            if (digit == 0) {
                System.out.println("ZERO");
            } else {
                for (int i = 0; i < digit; i++) {
                    System.out.print((char) (digit + 33));
                }
                System.out.println();
            }
        }*/
    }
}
