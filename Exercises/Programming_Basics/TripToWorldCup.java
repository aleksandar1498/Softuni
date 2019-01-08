package com.softuni;

import java.util.Scanner;

public class TripToWorldCup {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double ticketToDestination=Double.parseDouble(scanner.nextLine());
        double ticketToHome=Double.parseDouble(scanner.nextLine());
        double ticketFootballMatch=Double.parseDouble(scanner.nextLine());
        int numMatches=Integer.parseInt(scanner.nextLine());
        int percentageDiscount=Integer.parseInt(scanner.nextLine());
        ticketToDestination*=1.0-(double)percentageDiscount/100;
        ticketToHome*=1.0-(double)percentageDiscount/100;
        double totPriceGames=ticketFootballMatch*numMatches*6;
        double totPrice=(ticketToDestination+ticketToHome)*6+totPriceGames;
        System.out.printf("Total sum: %.2f lv.\nEach friend has to pay %.2f lv.",totPrice,totPrice/6);

    }
}
