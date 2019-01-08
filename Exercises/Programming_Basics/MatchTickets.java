package com.softuni;

import java.util.Scanner;

public class MatchTickets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        String  category=scanner.nextLine();
        int people=Integer.parseInt(scanner.nextLine());
        if(people>=1 && people <= 4){
            budget*=.25;
        }else if(people>=5 && people <= 9){
            budget*=.4;
        }else if(people>=10 && people <= 24){
            budget*=.5;
        }else if(people>=25 && people <= 49){
            budget*=.6;
        }else{
            budget*=.75;
        }
        switch (category){
            case "VIP":
                if(budget >= (499.99*people)){
                    System.out.printf("Yes! You have %.2f leva left.",budget-(499.99*people));
                }else{
                    System.out.printf("Not enough money! You need %.2f leva.",(499.99*people)-budget);

                }
                break;
            case "Normal":
                if(budget >= 249.99){
                    System.out.printf("Yes! You have %.2f leva left.",budget-(249.99*people));
                }else{
                    System.out.printf("Not enough money! You need %.2f leva.",(249.99*people)-budget);

                }
                break;
        }
    }
}
