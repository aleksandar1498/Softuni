package com.softuni;

import java.util.Scanner;

public class StadiumIncome {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numSectors=Integer.parseInt(scanner.nextLine());
        int stadiumCapacity=Integer.parseInt(scanner.nextLine());
        double priceTicket=Double.parseDouble(scanner.nextLine());
        double totIncome=stadiumCapacity*priceTicket;
        double sectorIncome=totIncome/numSectors;
        double charityMoney=totIncome-(sectorIncome*.75);
        System.out.printf("Total income - %.2f BGN \n",totIncome);
        System.out.printf("Money for charit - %.2f BGN\n",charityMoney/8);
    }
}
