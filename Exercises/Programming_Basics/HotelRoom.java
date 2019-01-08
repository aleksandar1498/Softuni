package com.softuni;

import java.util.Scanner;

public class HotelRoom {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String month = scanner.nextLine();
        int days = Integer.parseInt(scanner.nextLine());
        double studioPrice = 0;
        double flatPrice = 0;
        switch (month) {
            case "May":
            case "October":
                flatPrice = days * 65;
                studioPrice = days * 50;
                if (days > 7 && days <14) {
                    studioPrice *= .95;
                }else if(days > 14){
                    studioPrice *= .7;
                }

                break;
            case "June":
            case "September":
                flatPrice = days * 68.7;
                studioPrice = days * 75.2;
                if (days > 14) {
                    studioPrice *= .80;
                }
                break;
            case "July":
            case "August":
                flatPrice = days * 77;
                studioPrice = days * 76;

                break;
        }
        if (days > 14) {
            flatPrice *= .9;
        }
        System.out.printf("Apartment: %.2f lv.\nStudio: %.2f lv.",flatPrice,studioPrice
        );
    }
}
