package com.softuni;

import java.util.Scanner;

public class FanShop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        int numElements=Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numElements; i++) {
            String typeElement=scanner.nextLine();

            switch (typeElement){
                case "hoodie":
                    budget-=30;
                    break;
                case "keychain":
                    budget-=4;
                    break;
                case "T-shirt":
                    budget-=20;
                    break;
                case "flag":
                    budget-=15;
                    break;
                case "sticker":
                    budget-=1;
                    break;
            }
        }
        if(budget < 0){
            System.out.printf("Not enough money, you need %.2f more lv.",Math.abs(budget));

        }else{
            System.out.printf("You bought %d items and left with %.2f lv.",numElements,budget);

        }
    }
}
