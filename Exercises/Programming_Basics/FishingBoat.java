package com.softuni;

import java.util.Scanner;

public class FishingBoat {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int budget=Integer.parseInt(scanner.nextLine());
        String season=scanner.nextLine();
        int numFisher=Integer.parseInt(scanner.nextLine());
        double price=0;
        switch (season){
            case "Spring":
                price=3000;
                break;
            case "Summer":
            case "Autumn":
                price=4200;
                break;
            case "Winter":
                price=2600;
                break;
        }
        if(numFisher <= 6){
            price*=.9;
        }else if(numFisher <= 11){
            price*=.85;
        }else{
            price*=.75;
        }
        if(numFisher%2 == 0 && !season.equals("Autumn")){
            price*=.95;
        }
        if(price <= budget){
            System.out.printf("Yes! You have %.2f leva left.",budget-price);
        }else{
            System.out.printf("Not enough money! You need %.2f leva.",price-budget);
        }
    }
}
