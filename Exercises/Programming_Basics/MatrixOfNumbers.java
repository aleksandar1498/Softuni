package com.softuni;

import java.util.Scanner;

public class MatrixOfNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                // this if is used in order to split diagonally the matrix
                if(j < n-i){
                    System.out.print(i+j+1+" ");

                }else{
                    System.out.print(2*n - (i+j+1)+" ");

                }

            }
            System.out.println();
        }
    }
}
