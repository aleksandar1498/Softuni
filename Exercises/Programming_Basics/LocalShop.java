package com.softuni;

import java.util.Scanner;

public class LocalShop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String product = scanner.nextLine();
        String town = scanner.nextLine();
        double numOfProducts = Double.parseDouble(scanner.nextLine());
        if (town.equalsIgnoreCase("Sofia")) {
            if (product.equalsIgnoreCase("coffee")) {
                System.out.printf("%f",.5 * numOfProducts);
            } else if (product.equalsIgnoreCase("water")) {
                System.out.printf("%f",.8 * numOfProducts);

            } else if (product.equalsIgnoreCase("beer")) {
                System.out.printf("%f",1.2 * numOfProducts);

            } else if (product.equalsIgnoreCase("sweets")) {
                System.out.printf("%f",1.45 * numOfProducts);

            } else if (product.equalsIgnoreCase("peanuts")) {
                System.out.printf("%f",1.6 * numOfProducts);

            }
        } else if (town.equalsIgnoreCase("Plovdiv")) {
            if (product.equalsIgnoreCase("coffee")) {
                System.out.printf("%f",.4*numOfProducts);
            } else if (product.equalsIgnoreCase("water")) {
                System.out.printf("%f",.7*numOfProducts);
            } else if (product.equalsIgnoreCase("beer")) {
                System.out.printf("%f",1.15*numOfProducts);
            } else if (product.equalsIgnoreCase("sweets")) {
                System.out.printf("%f",1.3*numOfProducts);
            } else if (product.equalsIgnoreCase("peanuts")) {
                System.out.printf("%f",1.5*numOfProducts);
            }
        } else {
            if (product.equalsIgnoreCase("coffee")) {
                System.out.printf("%f",.45*numOfProducts);
            } else if (product.equalsIgnoreCase("water")) {
                System.out.printf("%f",.7*numOfProducts);
            } else if (product.equalsIgnoreCase("beer")) {
                System.out.printf("%f",1.1*numOfProducts);
            } else if (product.equalsIgnoreCase("sweets")) {
                System.out.printf("%f",1.35*numOfProducts);
            } else if (product.equalsIgnoreCase("peanuts")) {
                System.out.printf("%f",1.55*numOfProducts);
            }
        }
    }
}
