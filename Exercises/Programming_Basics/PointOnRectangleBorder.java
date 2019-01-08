package com.softuni;

import java.util.Scanner;

public class PointOnRectangleBorder {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double x1=Double.parseDouble(scanner.nextLine());
        double y1=Double.parseDouble(scanner.nextLine());
        double x2=Double.parseDouble(scanner.nextLine());
        double y2=Double.parseDouble(scanner.nextLine());
        double x=Double.parseDouble(scanner.nextLine());
        double y=Double.parseDouble(scanner.nextLine());
        if((x == x1 && (y >= Math.min(y1,y2)  &&  y <= Math.max(y1,y2))) || (x == x2 && (y >= Math.min(y1,y2)  &&  y <= Math.max(y1,y2))) || ((y == y1) && (x >= Math.min(x1,x2) && x <= Math.max(x1,x2))) || ((y == y2) && (x >= Math.min(x1,x2) && x <= Math.max(x1,x2)))) {
            System.out.println("Border");
        }else{
            System.out.println("Inside / Outside");
        }

    }
}
