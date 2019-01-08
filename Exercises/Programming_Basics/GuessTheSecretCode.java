package com.softuni;

import java.util.Scanner;

public class GuessTheSecretCode {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String secretCode = String.valueOf((int)(Math.random()*(999999-100000)));
        System.out.println(secretCode);
        //int chances = 1;
        boolean found=false;
        System.out.println("Try to guess the secret code");
        do {
            int sumOfTheGuessedNumbers = 0, numOfGuessedNumbers = 0;
            String myCode = String.valueOf((int)(Math.random()*(999999-100000)));
            if (myCode.equals(secretCode)) {
                System.out.println("Great you've guessed the code");
                System.exit(0);
            } else {
                System.out.println(secretCode.length());
                System.out.println(myCode.length());
              for (int i = 0; i <= secretCode.length()-1; i++) {
                  System.out.println(" i "+i);
                  System.out.println(secretCode.charAt(i));
                  System.out.println(myCode.charAt(i));
                  //if (secretCode.charAt(i) == myCode.charAt(i)) {
                      //  sumOfTheGuessedNumbers += Integer.parseInt(String.valueOf(secretCode.charAt(i)));
                        //numOfGuessedNumbers++;
                    //}
                }
            }
           // System.out.println(sumOfTheGuessedNumbers + " " + numOfGuessedNumbers);
          //  chances++;
        } while (found == false);
    }
}
