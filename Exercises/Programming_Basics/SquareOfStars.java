package com.softuni;

import java.util.Scanner;

public class SquareOfStars {
    public static void main(String [] args) {
        Scanner console = new Scanner(System.in);
        int n = Integer.parseInt(console.nextLine());
        for (int i = 0; i < n; i++) {
            for(int j=0 ; j<n;j++) {
                if( (i == 0) || (i== (n-1))){
                    System.out.print("*");
                }else{
                    if((j!=0) && (j != (n-1))){
                        System.out.print(" ");
                    }else{
                        System.out.print("*");
                    }
                }
            }
            System.out.println();
        }
    }
}
