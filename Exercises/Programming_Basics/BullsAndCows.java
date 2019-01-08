package com.softuni;


import java.util.Scanner;

public class BullsAndCows {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String result = "";
        int secretNumber = Integer.parseInt(scanner.nextLine());

     //   int numBulls = Integer.parseInt(scanner.nextLine());
       // int numCows = Integer.parseInt(scanner.nextLine());
        int bulls = 0, cows = 0;
        for (int digit1 = 1; digit1 < 10; digit1++) {
            for (int digit2 = 1; digit2 < 10; digit2++) {
                for (int digit3 = 1; digit3 < 10; digit3++) {
                    for (int digit4 = 1; digit4 < 10; digit4++) {
                        int guessDigit1 = (secretNumber / 1000)%10;
                        int guessDigit2 = (secretNumber / 100 )% 10;
                        int guessDigit3 = (secretNumber / 10)% 10;
                        int guessDigit4 = secretNumber % 10;
                        if (guessDigit1 == digit1) {
                            bulls++;
                            guessDigit1 = -1;
                            digit1 = -2;
                        }
                        if (guessDigit2 == digit2) {
                            bulls++;
                            guessDigit2 = -1;
                            digit2 = -2;
                        }
                        if (guessDigit3 == digit3) {
                            bulls++;
                            guessDigit3 = -1;
                            digit3 = -2;
                        }
                        if (guessDigit4 == digit4) {
                            bulls++;
                            guessDigit4 = -1;
                            digit4 = -2;
                        }
                        System.out.println(digit1+""+digit2+""+digit3+""+digit4+" "+bulls);
                    }
                }
            }
        }

        result = result.trim();
        if (result.length() > 0) {
            System.out.println(result);
        } else {
            System.out.println("No");
        }

    }


}
/* MY VARIANT
                        String com = combination;
                        int bulls = 0;
                        String secretN = String.valueOf(secretNumber);
                        for (int i = 0; i < combination.length(); i++) {
                            if (combination.charAt(i) == secretN.charAt(i)) {
                                bulls++;
                                System.out.println(combination.charAt(i)+" is equal to "+secretN.charAt(i));
                                combination = combination.substring(0, i).concat("b").concat(combination.substring(i + 1, combination.length()));
                                secretN = secretN.substring(0, i).concat("f").concat(secretN.substring(i + 1, secretN.length()));
                            }
                        }
                        int cows = 0;
                        for (int i = 0; i < secretN.length(); i++) {
                            for (int j = 0; j < combination.length(); j++) {
                                if (i != j) {
                                    if (combination.charAt(i) == secretN.charAt(j)) {
                                        cows++;
                                        combination = combination.substring(0, i).concat("c").concat(combination.substring(i + 1, combination.length()));
                                        System.out.println(combination);


                                        System.out.println();
                                    }
                                }
                            }
                        }
                        if (bulls == numBulls && cows == numCows) {
                            result = result.concat(com + " ");
                        }
*/