package com.softuni;

import java.util.Scanner;

public class CatLife {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String cat=scanner.nextLine();
        char gender=scanner.nextLine().charAt(0);
        int years=0;
        switch (cat){
            case "British Shorthair":
                years=13;
                break;
            case "Siamese":
                years=15;
                break;
            case "Persian":
                years=14;
                break;
            case "Ragdoll":
                years=16;
                break;
            case "American Shorthair":
                years=12;
                break;
            case "Siberian":
                years=11;
                break;
                default:
                    System.out.printf("%s is invalid cat!",cat);
                    return;

        }
        if(gender == 'f'){
            years++;
        }
        int catMonths=(int)(Math.floor(years*12/6));
        System.out.printf("%d cat months",catMonths);

    }
}
