package com.softuni;

import java.util.Scanner;

public class Vacation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double costVacation = Double.parseDouble(scanner.nextLine());
        double avaibleMoney = Double.parseDouble(scanner.nextLine());
        int daysOnlySpending = 0, days = 0;
        while (avaibleMoney < costVacation && ! (daysOnlySpending >= 5)) {
            String action = scanner.nextLine();
            double money = Double.parseDouble(scanner.nextLine());
            days++;
            if (action.equals("spend")) {
                avaibleMoney -= money;
                if (money > avaibleMoney) {
                    avaibleMoney = 0;
                }
                daysOnlySpending++;

            } else if (action.equals("save")) {

                avaibleMoney += money;
                daysOnlySpending = 0;
            }

        }
        if (daysOnlySpending >= 5) {
            System.out.printf("You can't save the money.\n%d", days);
            return;
        }
        if(avaibleMoney >= costVacation){
            System.out.printf("You saved the money for %d days.", days);
        }
    }
}
