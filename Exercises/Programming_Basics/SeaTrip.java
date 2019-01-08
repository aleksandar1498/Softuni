package com.softuni;

import java.util.Scanner;

public class SeaTrip {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double moneyForFood=Double.parseDouble(scanner.nextLine());
        double moneyForSouvenirs=Double.parseDouble(scanner.nextLine());
        double hotelBill=Double.parseDouble(scanner.nextLine());
    double neededMoney=0.0;
    neededMoney+=54.39;
    neededMoney+=moneyForFood*3;
    neededMoney+=moneyForSouvenirs*3;
    neededMoney+=hotelBill*.9;
    neededMoney+=hotelBill*.85;
    neededMoney+=hotelBill*.8;
        System.out.printf("Money needed: %.2f",neededMoney);


    }
}
