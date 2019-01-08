package com.softuni;

import java.util.Scanner;

public class AlcoholMarket {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceWhisky=Double.parseDouble(scanner.nextLine());
        double quantityOfBeer=Double.parseDouble(scanner.nextLine());
        double quantityWine=Double.parseDouble(scanner.nextLine());
        double quantityRakia=Double.parseDouble(scanner.nextLine());
        double quantityWhisky=Double.parseDouble(scanner.nextLine());
        double priceOfTheRakia=priceWhisky/2;
        double priceWine=priceOfTheRakia * (1-.4);
        double priceBeer=priceOfTheRakia * (1 - .8);
        double totPrice=quantityOfBeer*priceBeer + quantityRakia*priceOfTheRakia + quantityWhisky*priceWhisky + quantityWine*priceWine;
        System.out.printf("%.2f",totPrice);
    }
}
