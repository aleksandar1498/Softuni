package com.softuni;

import java.util.Scanner;

public class RadiantToDegrees {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        Double r=Double.parseDouble(scanner.nextLine());
        Double deg=(r*180)/Math.PI;
        System.out.printf("%.0f",deg);
    }
}
