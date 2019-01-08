package com.softuni;

import java.util.Scanner;

public class firstProgram {
    public static void main(String [] args) {
        //simple test
        int base = 0, height = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("Please insert your base :");
        base = input.nextInt();
        /*System.out.println("Your base is choosen in a random way");
        base =(int) (Math.random() * 100 +1);
        System.out.println("Your base is "+base); */
        System.out.println("Please insert your height :");
        height = input.nextInt();
        System.out.println("Area : "+(base*height/2));


    }
}
