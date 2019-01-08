package com.softuni;

import java.util.Scanner;

public class CocaColaProduction {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String choice="";
        do{
            double r=Double.parseDouble(scanner.nextLine());
            double V=Double.parseDouble(scanner.nextLine());
            double height=(V/(Math.PI*Math.pow(r,2)));
            System.out.println("The height of the bottle is "+height);
            System.out.println("The perfect price for the bottle is "+(2*Math.PI*r*(r+height)));
            System.out.println("Do you want to calculate other products ?");
            choice=scanner.nextLine();
        }while(choice.equals("yes"));
    }
}
