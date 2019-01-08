package com.softuni;

import java.util.Scanner;

public class CurrencyConverter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double val = Double.parseDouble(scanner.nextLine());
        String inputCurrency = scanner.nextLine();
        String outputCurrency = scanner.nextLine();
        double valInLev = 0;
        if (inputCurrency.toUpperCase().equals("USD")) {
            valInLev = val * 1.79549;
        } else if (inputCurrency.toUpperCase().equals("EUR")) {
            valInLev = val * 1.95583;
        } else if (inputCurrency.toUpperCase().equals("GBP")) {
            valInLev = val * 2.53405;
        } else {
            valInLev = val;
        }
//107.57
        if (outputCurrency.toUpperCase().equals("USD")) {
            System.out.printf("%.2f USD",(valInLev / 1.79549));
        } else if (outputCurrency.toUpperCase().equals("EUR")) {
            System.out.printf("%.2f EUR",(valInLev / 1.95583));
        } else if (outputCurrency.toUpperCase().equals("GBP")) {
            System.out.printf("%.2f GBP",(valInLev / 2.53405));
        } else {
            System.out.printf("%.2f BGN",valInLev);
        }
    }
}
