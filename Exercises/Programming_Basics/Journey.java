package com.softuni;

import java.util.Scanner;

public class Journey {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        String season=scanner.nextLine();
        String destination="";
        double spentMoney=0;
        String place="";
        switch (season){
            case "summer":
                if(budget <= 100){
                    destination="Bulgaria";
                    place="Camp";
                    spentMoney=budget*.3;
                }else if(budget <= 1000){
                    destination="Balkans";
                    place="Camp";
                    spentMoney=budget*.4;
                }else{
                    destination="Europe";
                    place="Hotel";
                    spentMoney=budget*.9;
                }

                break;
            case "winter":
                if(budget <= 100){
                    destination="Bulgaria";
                    spentMoney=budget*.7;
                }else if(budget <= 1000){
                    destination="Balkans";
                    spentMoney=budget*.8;
                }else{
                    destination="Europe";
                    spentMoney=budget*.9;
                }
                place="Hotel";
                break;
        }
        System.out.printf("Somewhere in %s\n%s - %.2f",destination,place,spentMoney);
    }
}
