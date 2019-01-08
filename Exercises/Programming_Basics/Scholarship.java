package com.softuni;

import java.util.Scanner;

public class Scholarship {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double monthIncome = Double.parseDouble(scanner.nextLine());
        double markResults = Double.parseDouble(scanner.nextLine());
        double minimalSalary = Double.parseDouble(scanner.nextLine());
        if (monthIncome > minimalSalary) {
            if (markResults >= 5.5) {
                System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(markResults * 25));
            } else {
                System.out.println("You cannot get a scholarship!");
            }
        } else {
            if (markResults >= 5.5) {
                if ((minimalSalary * .35) > (markResults * 25)) {
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(minimalSalary * .35));
                } else {
                    System.out.printf("You get a scholarship for excellent results %.0f BGN", Math.floor(markResults * 25));
                }
            } else {
                if (markResults > 4.5) {
                    System.out.printf("You get a Social scholarship %.0f BGN", Math.floor(minimalSalary * .35));

                }else{
                    System.out.println("You cannot get a scholarship!");

                }
            }
        }
    }
}
