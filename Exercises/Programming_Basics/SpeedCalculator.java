package com.softuni;

import java.util.Scanner;

public class SpeedCalculator {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int initialSpeed=Integer.parseInt(scanner.nextLine());
        int rangeInitialSpeed=Integer.parseInt(scanner.nextLine());
        int range2Speed=Integer.parseInt(scanner.nextLine());
        int range3Speed=Integer.parseInt(scanner.nextLine());;

        double distance =(rangeInitialSpeed/60.0)*Double.valueOf(initialSpeed);
        double secondSpeed=initialSpeed*1.1;
        distance+=secondSpeed*(range2Speed/60.0);
        double thirdSpeed=secondSpeed*.95;
        distance+=thirdSpeed*(range3Speed/60.0);
        System.out.printf("%.2f",distance);
    }
}
