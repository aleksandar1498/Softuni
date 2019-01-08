package com.softuni;

import java.util.Scanner;

public class Birthday {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int l=Integer.parseInt(scanner.nextLine());
        int w=Integer.parseInt(scanner.nextLine());
        int h=Integer.parseInt(scanner.nextLine());
        double percent=Double.parseDouble(scanner.nextLine());
        double volume=(l*w)*h;
        volume*=0.001;
        double newVolume=volume - ((volume*percent)/100);
        System.out.printf("%.3f",newVolume);
    }
}
