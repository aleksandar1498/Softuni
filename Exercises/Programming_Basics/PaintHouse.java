package com.softuni;

import java.util.Scanner;

public class PaintHouse {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double x=Double.parseDouble(scanner.nextLine());
        double y=Double.parseDouble(scanner.nextLine());
         double h=Double.parseDouble(scanner.nextLine());
        double neededRedPaint=0.0;
        double neededGreenPaint=0.0;
        double areaGreenWalls=((x*x)*2+(x*y)*2)-(2.4 + 1.5*1.5*2);
        double areaRedWalls=(x*h)+(x*y)*2;
        System.out.printf("%.2f\n",areaGreenWalls/3.4);
        System.out.printf("%.2f",areaRedWalls/4.3);
    }
}
