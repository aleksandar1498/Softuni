package com.softuni;

import java.util.Scanner;

public class IncreasingFourNumber {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        int c = 0;
        for (int i = a; i <= b; i++) {
            for (int j = a; j <= b; j++) {
                for (int k = a; k <= b; k++) {
                    for (int l = a; l <= b; l++) {
                        if (l > k && k > j && j > i) {
                            System.out.println(i + " " + j + " " + k + " " + l);
                            c++;
                        }
                    }
                }
            }
        }
        if(c == 0){
            System.out.println("No");
        }
    }
}
