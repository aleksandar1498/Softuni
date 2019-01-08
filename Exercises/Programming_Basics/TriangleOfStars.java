package com.softuni;

import java.util.Scanner;

public class TriangleOfStars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <= n  ; i++) {

                for (int j = 0; j < i ; j++) {
                    System.out.print(" * ");
                }
                System.out.println();

            }
        for (int i = n-1; i >0 ; i--) {

            for (int j = 0; j < i ; j++) {
                System.out.print(" * ");
            }
            System.out.println();

        }
    }
}
