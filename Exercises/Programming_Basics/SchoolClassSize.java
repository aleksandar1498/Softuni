package com.softuni;

import java.util.Scanner;

public class SchoolClassSize {
    public static void main(String [] args){
        Scanner input =new Scanner(System.in);
        int sits=0;
        double l=0,w=0;
        l=Double.parseDouble(input.nextLine());
        w=Double.parseDouble(input.nextLine());

        // I am removing the corridor
        w-=1;
        sits+= (int) (l/1.2);
        int rows=(int) (w/.7);
        sits=(sits*rows)-3 ;
        System.out.println(sits);


    }
}
