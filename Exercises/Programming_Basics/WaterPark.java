package com.softuni;

import java.util.Scanner;

public class WaterPark {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String monthOfYear = scanner.nextLine();
        int hoursInTheWaterpark = Integer.parseInt(scanner.nextLine());
        int peopleInTheGroup = Integer.parseInt(scanner.nextLine());
        String partOfTheDay = scanner.nextLine();
        double price = 0.0;
        switch (monthOfYear.toLowerCase()) {
            case "march":
            case "april":
            case "may":
                if (partOfTheDay.equals("day")) {
                    price = 10.50;
                } else {
                    price = 8.4;
                }
                break;
            case "june":
            case "july":
            case "august":
                if (partOfTheDay.equals("day")) {
                    price = 12.6;
                } else {
                    price = 10.2;
                }
                break;
        }
        if(peopleInTheGroup >= 4){
            price*=.9;
        }
        if(hoursInTheWaterpark >= 5){
            price*=.5;
        }
        System.out.printf("Price per person for one hour: %.2f\n",price);
        System.out.printf("Total cost of the visit : %.2f",price*hoursInTheWaterpark*peopleInTheGroup);

    }
}
