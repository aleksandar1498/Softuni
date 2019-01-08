package com.softuni;

import java.util.Scanner;

public class ToyShop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double priceOfTheJourney=Double.parseDouble(scanner.nextLine());
        int sumToys=0;
        double totCash=0;
        int numOfPuzzles=Integer.parseInt(scanner.nextLine());
        int numOfDolls=Integer.parseInt(scanner.nextLine());
        int numOfBears=Integer.parseInt(scanner.nextLine());
        int numMinions=Integer.parseInt(scanner.nextLine());
        int numCamions=Integer.parseInt(scanner.nextLine());
        sumToys=numOfPuzzles+numOfDolls+numOfBears+numMinions+numCamions;
        totCash=(numOfPuzzles*2.60)+(numOfDolls*3)+(numOfBears*4.10)+(numMinions*8.20)+(numCamions*2);
        if(sumToys >= 50){
            totCash*=.75;
        }
        // reduce month bill
        totCash*=.90;
        if(totCash >=priceOfTheJourney){
            System.out.printf("Yes! %.2f lv left.",(totCash-priceOfTheJourney));
        }else{
            System.out.printf("Not enough money! %.2f lv needed.",Math.abs(totCash-priceOfTheJourney));
        }
    }
}
