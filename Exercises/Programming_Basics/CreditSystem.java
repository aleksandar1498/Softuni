package com.softuni;

import java.util.Scanner;

public class CreditSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numGrades = Integer.parseInt(scanner.nextLine());
        double sumCredits = 0;
        double sumGrades = 0;
        for (int i = 0; i < numGrades; i++) {
            int creditPlusGrade = Integer.parseInt(scanner.nextLine());
            int grade = creditPlusGrade % 10;
            creditPlusGrade = (creditPlusGrade - grade) / 10;
            sumGrades += grade;
            switch (grade) {
                case 3:
                    sumCredits += creditPlusGrade * .5;
                    break;
                case 4:
                    sumCredits += creditPlusGrade * .7;
                    break;
                case 5:
                    sumCredits += creditPlusGrade * .85;
                    break;
                case 6:
                    sumCredits += creditPlusGrade * 1;
                    break;
            }
        }
        double average=sumGrades/numGrades;
        System.out.printf("%.2f\n%.2f",(double)(sumCredits),average);
    }
}
