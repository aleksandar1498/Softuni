package com.softuni;

import java.util.Scanner;

public class Matrix {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());
        int c=Integer.parseInt(scanner.nextLine());
        int d=Integer.parseInt(scanner.nextLine());
        for (int i = a; i <=b ; i++) {
            for (int j = a; j <= b; j++) {
                for (int k = c; k <=d ; k++) {
                    for (int l = c; l <=d; l++) {
                        if(((i+l) == (j+k)) && (i != j) && (k != l)){
                            System.out.print(i+""+j+"\n"+k+""+l+"\n\n");
                        }
                    }
                }

            }
        }
    }
}
