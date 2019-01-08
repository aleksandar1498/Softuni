package com.softuni;

import java.util.Scanner;

public class OperationsBetweenNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N1 = Integer.parseInt(scanner.nextLine());
        int N2 = Integer.parseInt(scanner.nextLine());
        String operator = scanner.nextLine();
        switch (operator) {
            case "*":
                if (N1 * N2 % 2 == 0) {
                    System.out.printf("%d * %d = %d - even", N1, N2, N1 * N2);

                } else {
                    System.out.printf("%d * %d = %d - odd", N1, N2, N1 * N2);

                }

                break;
            case "/":
                if (N2 == 0) {
                    System.out.println("Cannot divide " + N1 + " by zero");
                } else {
                    double result = Double.valueOf(N1) / Double.valueOf(N2);
                    System.out.printf("%d / %d = %.2f", N1, N2, result);
                }
                break;
            case "+":
                if ((N1 + N2) % 2 == 0) {
                    System.out.printf("%d + %d = %d - even", N1, N2, N1 + N2);
                } else {
                    System.out.printf("%d + %d = %d - odd", N1, N2, N1 + N2);

                }


                break;
            case "-":
                if ((N1 + N2) % 2 == 0) {
                    System.out.printf("%d - %d = %d - even", N1, N2, N1 - N2);
                } else {
                    System.out.printf("%d - %d = %d - odd", N1, N2, N1 - N2);

                }
                break;
            case "%":
                if (N2 == 0) {
                    System.out.println("Cannot divide " + N1 + " by zero");
                } else {
                    System.out.printf("%d %% %d = %d", N1, N2, N1 % N2);
                }
                break;
        }
    }
}
