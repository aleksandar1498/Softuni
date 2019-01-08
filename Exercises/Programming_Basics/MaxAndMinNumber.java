package com.softuni;

import java.util.ArrayList;
import java.util.Scanner;

public class MaxAndMinNumber {
    static Scanner scanner=new Scanner(System.in);
    public static void ReadNumbers(){
       int min=0;
       int max=0;
       int input=0;
       int sum=0,counter=0;
       do{
           input=Integer.parseInt(scanner.nextLine());

           if(counter == 0){
               min=input;
           }
           if(input > 0) {
               sum+=input;
               if (input < min) {
                   min = input;
               } else if (input > max) {
                   max = input;
               }
               counter++;
           }

       }while(input > 0);
        System.out.println(sum+" "+counter);
        System.out.println(min+" "+max);
        System.out.println("The average of the numbers is "+(sum/counter));
    }

    public static void main(String[] args) {
        ReadNumbers();
    }
}
