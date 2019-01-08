package com.softuni;

import java.util.Scanner;

public class Volleyball {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String typeYear=scanner.nextLine();
        int numHolidays=Integer.parseInt(scanner.nextLine());
        int numWeeksInBornTown=Integer.parseInt(scanner.nextLine());
        int weekendsInSofia=48-numWeeksInBornTown;
        double joyWeekends=(double)(weekendsInSofia)*3.0/4.0;
        double joyDaysInHolidays=Double.valueOf(numHolidays)*2/3;

        double totDays=joyWeekends+joyDaysInHolidays+numWeeksInBornTown;
        if(typeYear.equals("leap")){
            totDays+=totDays*.15;
        }
        System.out.printf("%.0f",Math.floor(totDays));

    }
}
