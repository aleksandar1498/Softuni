package com.softuni;

import java.util.Scanner;

public class USDtoBGN {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double usd=Double.parseDouble(scanner.nextLine());
        double lev=usd* 1.79549;
        System.out.printf("%.2f",lev);
    }
}
