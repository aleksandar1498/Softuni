package com.softuni;

import java.util.Scanner;

public class AreaOfFigures {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String figure=scanner.nextLine();
        if(figure.equalsIgnoreCase("square")){
            double l=Double.parseDouble(scanner.nextLine());
            System.out.println(l*l);
        }else if(figure.equalsIgnoreCase("rectangle")){
            double c1=Double.parseDouble(scanner.nextLine());
            double c2=Double.parseDouble(scanner.nextLine());
            System.out.println(c1*c2);
        }else if(figure.equalsIgnoreCase("circle")){
            double r=Double.parseDouble(scanner.nextLine());
            System.out.println(Math.pow(r,2)*Math.PI);
        }else{
            double b=Double.parseDouble(scanner.nextLine());

        }
    }
}
