package com.softuni;

import java.util.Scanner;

public class WaterForTheFamily {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double r=Double.parseDouble(scanner.nextLine()) / 100;
        System.out.println(r+" in meters");
        double depth=Double.parseDouble(scanner.nextLine());
        double volume=Math.PI * Math.pow(r,2)*depth;
        double volumeInLiters=volume*1000;
        System.out.println(volume+" "+volumeInLiters);
        if(volumeInLiters / 1000 > 0){
            System.out.println("The water is enough for the daily usage of the family");
        }

    }
}
