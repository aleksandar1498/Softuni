package com.softuni;

import java.util.Scanner;

public class CharityCampaign {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOfDays=Integer.parseInt(scanner.nextLine());
        int numOfBakers=Integer.parseInt(scanner.nextLine());
        int numOfCakes=Integer.parseInt(scanner.nextLine());
        int numOfWaffles=Integer.parseInt(scanner.nextLine());
        int numOfPancakes=Integer.parseInt(scanner.nextLine());
        double dayProfit=((numOfCakes*45) + (numOfWaffles*5.80) + (numOfPancakes*3.20))*numOfBakers;
        double totProfit=dayProfit*numOfDays;
        totProfit-=(totProfit/8);
        System.out.printf("%.2f",totProfit);
    }
}
