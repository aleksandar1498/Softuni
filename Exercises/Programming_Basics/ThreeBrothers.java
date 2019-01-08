package com.softuni;

import java.util.Scanner;

public class ThreeBrothers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double timeFirstBrother=Double.parseDouble(scanner.nextLine());
        double timeSecondBrother=Double.parseDouble(scanner.nextLine());
        double timeThirdBrother=Double.parseDouble(scanner.nextLine());
        double timeAtWork=Double.parseDouble(scanner.nextLine());
        double totTime=1/(1/timeFirstBrother+1/timeSecondBrother+1/timeThirdBrother);
        totTime+=totTime*.15;
        if(totTime < timeAtWork){
            System.out.printf("Cleaning time: %.2f\n",totTime);
            System.out.printf("Yes, there is a surprise - time left -> %.0f hours.",Math.floor(timeAtWork-totTime));
        }else{
            System.out.printf("Cleaning time: %.2f\n",totTime);
            System.out.printf("No, there isn't a surprise - shortage of time -> %.0f hours.",Math.ceil(totTime-timeAtWork));

        }


    }
}
