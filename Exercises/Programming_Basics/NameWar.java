package com.softuni;

import java.util.Scanner;

public class NameWar {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean war = true;
        String nameOfTheWinner="";
        int winnerInTheWar = Integer.MIN_VALUE;
        while (war) {
            String action = scanner.nextLine();
            if (action.equals("STOP")) {
                war = false;
            } else {
                int sumChars = 0;
                for (int i = 0; i < action.length(); i++) {
                    sumChars += (int) (action.charAt(i));
                }
                if (sumChars > winnerInTheWar) {
                    nameOfTheWinner = action;
                    winnerInTheWar = sumChars;
                }
            }
        }
        System.out.printf("Winner is %s - %d!",nameOfTheWinner,winnerInTheWar);
    }
}
