package com.softuni;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;


public class MagicDates {




    public static void main(String[] args) {
       Scanner scanner=new Scanner(System.in);
       int initialYear=Integer.parseInt(scanner.nextLine());

       // System.out.println(weightDate("17032007"));
       int finalYear=Integer.parseInt(scanner.nextLine());
       int weight=Integer.parseInt(scanner.nextLine());
       boolean found=false;
       LocalDate startDate=LocalDate.of(initialYear,1,1);
       LocalDate endDate=LocalDate.of(finalYear,12,31);
        endDate=endDate.plusDays(1);
        for (LocalDate date = startDate; date.isBefore(endDate); date = date.plusDays(1))
        {
            String data=String.valueOf(date.getDayOfMonth())+String.valueOf(date.getMonthValue())+String.valueOf(date.getYear());

            if(weight == weightDate(data)){
                System.out.println(DateTimeFormatter.ofPattern("dd-MM-yyyy").format(date));
                found=true;
            }
        }
        if(found==false)
        System.out.println("No");


    }
    static int weightDate(String date){
        int sum=0;
       // System.out.println("inner "+date);
        for (int i = 0; i < date.length()-1; i++) {
            for (int j = i+1; j < date.length(); j++) {
               // System.out.println(String.valueOf(date.charAt(i))+" and "+Integer.parseInt(String.valueOf(date.charAt(j))));
                sum+=Integer.parseInt(String.valueOf(date.charAt(i)))*Integer.parseInt(String.valueOf(date.charAt(j)));

            }

           // System.out.println("sum" +sum);
        }
       // System.out.println("sum" +sum);

        return sum;
    }



    }


