package com.softuni;

import java.util.Scanner;

public class AreaTriangle {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double x1=Double.parseDouble(scanner.nextLine());
        double y1=Double.parseDouble(scanner.nextLine());
        double x2=Double.parseDouble(scanner.nextLine());
        double y2=Double.parseDouble(scanner.nextLine());
        double x3=Double.parseDouble(scanner.nextLine());
        double y3=Double.parseDouble(scanner.nextLine());
        double a=Math.max(x2,x3)-Math.min(x2,x3);
        double h=Math.max(y1,y2) - Math.min(y1,y2);
        System.out.println("Area "+ (a*h)/2);
    }
}
