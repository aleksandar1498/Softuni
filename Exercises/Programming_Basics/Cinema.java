package com.softuni;

import java.util.Scanner;

public class Cinema {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String type=scanner.nextLine();
        int rows =Integer.parseInt(scanner.nextLine());
        int cols=Integer.parseInt(scanner.nextLine());
        int sits=rows*cols;
        double earnedMoney=0.0;
   switch (type){
       case "Premiere":
           earnedMoney=sits*12;
           break;
       case "Normal":
           earnedMoney=sits*7.50;
           break;
       case "Discount":
           earnedMoney=sits*5;
           break;
   }
        System.out.printf("%.2f leva",earnedMoney);
    }
}
