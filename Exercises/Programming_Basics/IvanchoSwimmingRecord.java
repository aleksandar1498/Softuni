package com.softuni;

import java.util.Scanner;

public class IvanchoSwimmingRecord {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double recordTime=Double.parseDouble(scanner.nextLine());
        double lengthOfThePool=Double.parseDouble(scanner.nextLine());
        double secondsPerMeter=Double.parseDouble(scanner.nextLine());
        double neededTime=lengthOfThePool*secondsPerMeter;
        double slowedByTheWater=((int)(lengthOfThePool)/15)*12.5;

        neededTime+=slowedByTheWater;

        if(neededTime < recordTime){
            System.out.printf("Yes, he succeeded! The new world record is %.2f seconds.",neededTime);
        }else{
            System.out.printf("No, he failed! He was %.2f seconds slower.",(neededTime-recordTime));
        }
    }
}
