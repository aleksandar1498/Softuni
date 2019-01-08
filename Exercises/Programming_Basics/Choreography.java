package com.softuni;

import java.util.Scanner;

public class Choreography {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numSteps=Integer.parseInt(scanner.nextLine());
        int numDancers=Integer.parseInt(scanner.nextLine());
        int numDays=Integer.parseInt(scanner.nextLine());
        double stepsPerDay=(double)(numSteps/numDays);
        double percentStepsPerDay=Math.ceil((stepsPerDay*100)/numSteps);
        double percentStepsPerEachDancer=percentStepsPerDay/numDancers;

        if(percentStepsPerDay <= 13){
            System.out.printf("Yes, they will succeed in that goal! %.2f%%.",percentStepsPerEachDancer);

        }else{
            System.out.printf("No, They will not succeed in that goal! Required %.2f%% steps to be learned per day.",percentStepsPerEachDancer);
        }
    }
}
