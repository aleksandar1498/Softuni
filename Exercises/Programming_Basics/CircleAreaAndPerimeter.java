package com.softuni;

import java.util.Scanner;

public class CircleAreaAndPerimeter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double r=Double.parseDouble(scanner.nextLine());
        double area= Math.PI * Math.pow(r,2);
        double per= 2* Math.PI * r;
        System.out.println("Area = "+area);
        System.out.println("Perimeter = "+per);
    }
}
