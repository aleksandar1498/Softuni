package com.softuni;

import java.util.Scanner;

public class SlotMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char n = scanner.nextLine().charAt(0);
        int n1 = Integer.parseInt(scanner.nextLine());
        int m = scanner.nextLine().charAt(0);
        int m1 = Integer.parseInt(scanner.nextLine());
        int k = scanner.nextLine().charAt(0);
        int k1 = Integer.parseInt(scanner.nextLine());
        String combination = ((char) ((int) (n) + n1)) + "" + ((char) ((int) (m) + m1)) + "" + ((char) ((int) (k) + k1));
        if (combination.equals("@@@")) {
            System.out.printf("%s\n!!! YOU LOSE EVERYTHING !!!", combination);
        } else if (combination.equals("777")) {
            System.out.printf("%s *** JACKPOT *** ", combination);
        } else {
            System.out.println(combination);
        }
    }
}
