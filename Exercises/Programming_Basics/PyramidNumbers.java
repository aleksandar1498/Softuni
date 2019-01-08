package com.softuni;

import java.util.Scanner;

public class PyramidNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(count+1+" ");
                count ++;
                if (count == n) {
                    return;
                }

            }
            System.out.println();
        }
    }
}
