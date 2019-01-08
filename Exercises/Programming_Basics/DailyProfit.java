package com.softuni;

import java.util.Scanner;

public class DailyProfit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int workingDays=Integer.parseInt(scanner.nextLine());
        double profit=Double.parseDouble(scanner.nextLine());
        double changeVal=Double.parseDouble(scanner.nextLine());
        double yearProfit=profit*workingDays*12;
        yearProfit+=profit*workingDays*2.5;
        yearProfit*=.75;
        System.out.printf("%.2f",(yearProfit*changeVal)/365);
    }
}
