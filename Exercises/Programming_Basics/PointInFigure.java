package com.softuni;

import java.util.Scanner;

public class PointInFigure {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=Integer.parseInt(scanner.nextLine());
        int y=Integer.parseInt(scanner.nextLine());
        if((x>= 4 && x <= 10 && y >= -5 && y<= 3) || (x>=2 && x<= 12 && y>=-3 && y <=1)){
            System.out.println("in");
        }else{
            System.out.println("out");
        }

    }
}
