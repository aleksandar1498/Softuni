package com.softuni;

import java.util.Scanner;

public class SushiTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String typeSushi=scanner.nextLine();
        String nameOfTheRestaurant=scanner.nextLine();
        int numSets=Integer.parseInt(scanner.nextLine());
        char toHome=scanner.nextLine().charAt(0);
        double totPrice=0;
        double price=0;
        switch (nameOfTheRestaurant){
            case "Sushi Zone":
                switch (typeSushi){
                    case "sashimi":
                        price=4.99;
                        break;
                    case "maki":
                        price=5.29;
                        break;
                    case "uramaki":
                        price=5.99;
                        break;
                    case "temaki":
                        price=4.29;
                        break;
                }
                break;
            case "Sushi Time":
                switch (typeSushi){
                    case "sashimi":
                        price=5.49;
                        break;
                    case "maki":
                        price=4.69;
                        break;
                    case "uramaki":
                        price=4.49;
                        break;
                    case "temaki":
                        price=5.19;
                        break;
                }
                break;
            case "Sushi Bar":
                switch (typeSushi){
                    case "sashimi":
                        price=5.25;
                        break;
                    case "maki":
                        price=5.55;
                        break;
                    case "uramaki":
                        price=6.25;
                        break;
                    case "temaki":
                        price=4.75;
                        break;
                }
                break;
            case "Asian Pub":
                switch (typeSushi){
                    case "sashimi":
                        price=4.5;
                        break;
                    case "maki":
                        price=4.8;
                        break;
                    case "uramaki":
                        price=5.5;
                        break;
                    case "temaki":
                        price=5.5;
                        break;
                }
                break;
                default:
                    System.out.println(nameOfTheRestaurant+" is invalid restaurant!");
                    return;

        }
        totPrice=numSets*price;
        if(toHome == 'Y'){
            totPrice+=totPrice*.2;
        }
        System.out.printf("Tot price: %d lv",(int)Math.ceil(totPrice));
    }
}
