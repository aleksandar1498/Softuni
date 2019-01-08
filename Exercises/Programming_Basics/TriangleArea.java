package com.softuni;

import java.util.Scanner;

public class TriangleArea {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double b=Double.parseDouble(scanner.nextLine());
        double h=Double.parseDouble(scanner.nextLine());
        System.out.println("Triangle area = "+(b*h)/2);
    }
}
