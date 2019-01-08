package com.softuni;

import java.util.Scanner;

public class TicketCombination {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int combination = 0;
        for (char i = 'B'; i <= 'L'; i++) {
            for (char j = 'f'; j >= 'a'; j--) {
                for (char k = 'A'; k <= 'C'; k++) {
                    for (int l = 1; l <= 10; l++) {
                        for (int m = 10; m >= 1; m--) {

                            if ((int) i % 2 == 0) {
                                combination++;
                                if (combination == n) {
                                    System.out.printf("Ticket combination: %s", i + "" + j + "" + k + "" + l + "" + m);
                                    System.out.printf("\nPrize: %d lv", (int) i + (int) j + (int) k + l + m);

                                }
                            }

                        }
                    }
                }
            }
        }
    }
}
