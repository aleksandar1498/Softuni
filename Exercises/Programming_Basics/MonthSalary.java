package com.softuni;

import java.util.Scanner;

public class MonthSalary {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int workingDaysInMonth=Integer.parseInt(scanner.nextLine());
        double salaryPerDay=Double.parseDouble(scanner.nextLine());
        double currencyChange=Double.parseDouble(scanner.nextLine());
        double yearSalary=(workingDaysInMonth * salaryPerDay )* 14.5;
        yearSalary*=(1-.25);
        double salaryInLeva=yearSalary*currencyChange;
        System.out.printf("%.2f",(salaryInLeva / 365));

    }
}
