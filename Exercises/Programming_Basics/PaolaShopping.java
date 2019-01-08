package com.softuni;

import java.util.Scanner;

public class PaolaShopping {
    private static final int MAX_EXPENSE = 100;
    private static final int MAX_NUMBER_OF_PRODUCTS = 3;
public static final boolean DEBUG=false;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double expense = 0;
        int boughtProducts = 0;

        while (expense < MAX_EXPENSE && boughtProducts < MAX_NUMBER_OF_PRODUCTS) {
            System.out.println("Insert the price of the product");
            double newProductPrice = Double.parseDouble(scanner.nextLine());
                if ((expense + newProductPrice) <= MAX_EXPENSE) {
                    expense += newProductPrice;
                    boughtProducts++;
                } else {
                    System.out.println("Your product is too expensive");
                }

        }

        System.out.println("You've spent "+expense+" euro");
    }
}
