package com.softuni;

import java.util.Scanner;

public class DiamondOfStars {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        if (n % 2 == 0) {
            // draw the top
            for (int i = 0; i < (n / 2)-1; i++) {
                System.out.print(createFrom("-", (n - 1) / 2 - i));
                System.out.print("*");
                System.out.print(createFrom("-", 2 * i));
                System.out.print("*");
                System.out.println(createFrom("-", (n - 1) / 2 - i));
            }
            // draw the bottom
            for (int i = (n / 2)-1; i >= 0; i--) {
                System.out.print(createFrom("-", (n - 1) / 2 - i));
                System.out.print("*");
                System.out.print(createFrom("-", 2 * i));
                System.out.print("*");
                System.out.println(createFrom("-", (n - 1) / 2 - i));
            }
        } else {


            for (int i = 0; i <= n / 2; i++) {

                if (i == 0) {
                    System.out.print(createFrom("-", (n - 1) / 2));
                    System.out.print("*");
                    System.out.println(createFrom("-", (n - 1) / 2));
                } else {
                    System.out.print(createFrom("-", (n - 1) / 2 - i));
                    System.out.print("*");
                    System.out.print(createFrom("-", 2 * i - 1));
                    System.out.print("*");
                    System.out.println(createFrom("-", (n - 1) / 2 - i));
                }
            }

            for (int i = n / 2-1; i >=0; i--) {

                if (i == 0) {
                    System.out.print(createFrom("-", (n - 1) / 2));
                    System.out.print("*");
                    System.out.println(createFrom("-", (n - 1) / 2));
                } else {
                    System.out.print(createFrom("-", (n - 1) / 2 - i));
                    System.out.print("*");
                    System.out.print(createFrom("-", 2 * i - 1));
                    System.out.print("*");
                    System.out.println(createFrom("-", (n - 1) / 2 - i));
                }
            }

        }
    }

    public static String createFrom(String sym, int stars) {
        StringBuffer toReturn = new StringBuffer();
        for (int i = 0; i < stars; i++) {
            toReturn.append(sym);
        }
        return toReturn.toString();
    }
}
