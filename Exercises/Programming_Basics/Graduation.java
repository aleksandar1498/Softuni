package com.softuni;

import java.util.Scanner;

public class Graduation {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        double sum=0.0;
        int year=1;
        int repeatYear=0;
        while(year <= 12 && repeatYear <= 1){
            double grade=Double.parseDouble(scanner.nextLine());
            if(grade >= 4){
                sum+=grade;
                year++;
            }else{
                repeatYear++;
            }

        }
        if(repeatYear > 1){
            System.out.printf("%s has been excluded at %d grade",name,year);

        }else{
            System.out.printf("%s graduated. Average grade: %.2f",name,(sum/12));

        }
    }
}
