package com.softuni;

import java.util.Scanner;

public class DanceHall {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double lengthOfTheHall=Double.parseDouble(scanner.nextLine());
        double widthOfTheHall=Double.parseDouble(scanner.nextLine());
        double widthOfTheWardrobe=Double.parseDouble(scanner.nextLine());
        double hallArea=lengthOfTheHall*widthOfTheHall;
        double benchArea=(lengthOfTheHall*widthOfTheHall)/10;
        double wardrobeArea=widthOfTheWardrobe*widthOfTheWardrobe;
        hallArea-=(benchArea+wardrobeArea);
        double areaOfDancer=7040.0 / 10000.0;
        System.out.printf("%.0f",Math.floor(hallArea/areaOfDancer));

    }
}
