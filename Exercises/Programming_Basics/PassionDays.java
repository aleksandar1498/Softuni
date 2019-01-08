package com.softuni;

import java.math.BigDecimal;
import java.util.Scanner;

public class PassionDays {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigDecimal initialBudget = new BigDecimal(scanner.nextLine());
        int purchases=0;
        String command = scanner.nextLine();
        while (!command.equals("mall.Enter")) {
            command = scanner.nextLine();
        }
        command = scanner.nextLine();
        while (!command.equals("mall.Exit")) {
            for (char a : command.toCharArray()) {


                if (a == '*') {
                    initialBudget=initialBudget.add(new BigDecimal(10));
                } else if (a == '%') {
                    BigDecimal price=initialBudget.divide(new BigDecimal(2));
                    if (initialBudget.compareTo(price) == 1) {

                        initialBudget = initialBudget.subtract(price);
                        purchases++;
                    }
                } else if (a >= 65 && a <= 90) {
                    BigDecimal price=new BigDecimal((int) a).multiply(new BigDecimal(.5));

                    if ( initialBudget.compareTo(price) == 1) {
                        purchases++;
                        initialBudget =initialBudget.subtract(price);
                    }
                } else if (a >= 97 && a <= 122) {
                    BigDecimal price=new BigDecimal((int) a).multiply(new BigDecimal(.3));
                    if (initialBudget.compareTo(price) == 1) {
                        purchases++;
                        initialBudget =initialBudget.subtract(price);
                    }
                } else {
                    BigDecimal price=new BigDecimal((int) a);
                    if (initialBudget.compareTo(price) == 0 || initialBudget.compareTo(price) == 1) {
                        purchases++;
                        initialBudget =initialBudget.subtract(price);
                    }
                }
            }
            command = scanner.nextLine();
        }
        if(purchases > 0){
            System.out.printf("%d purchases. Money left: %.2f lv.",purchases,initialBudget);
        }else{
            System.out.printf("No purchases. Money left: %.2f lv.",initialBudget);
        }
    }
}
