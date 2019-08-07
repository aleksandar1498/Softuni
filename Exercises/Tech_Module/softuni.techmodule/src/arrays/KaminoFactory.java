package arrays;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class KaminoFactory {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int lengthOfDNA = Integer.parseInt(scanner.nextLine());
        String action = scanner.nextLine();
        StringBuffer dnaS = new StringBuffer();
        while (!action.equals("Clone them!")) {
            dnaS.append(action + " ");
            action = scanner.nextLine();
        }

        int maxSequence = Integer.MIN_VALUE;
        int maxSum = Integer.MIN_VALUE;
        int startingIndex = Integer.MAX_VALUE;
        String toShow = "";

        String[] dnasArray = dnaS.toString().split(" ");
        for (int i = 0; i < dnasArray.length; i++) {
            int lengthSubsequence = 1;
            int currentSum =0;
            String[] digits = dnasArray[i].split("!");
            for (int j = 0; j < digits.length; j++) {
                if (digits[j].equals("1")) {
                    currentSum++;
                }
            }
            for (int j = 0; j < digits.length - 1; j++) {

                if (digits[j].equals("1")) {

                    if (digits[j].equals(digits[j + 1])) {
                        lengthSubsequence++;
                    } else {
                        if (lengthSubsequence > maxSequence) {
                            maxSequence = lengthSubsequence;
                            int currentIndex;
                            if (j == 0) {
                                currentIndex = 0;
                            } else {
                                currentIndex = ((j + 1) - maxSequence);
                            }


                            startingIndex = currentIndex;
                            maxSum = currentSum;

                            toShow = dnasArray[i];
                            continue;
                        } else if (lengthSubsequence == maxSequence) {
                            int currentIndex;
                            if (j == 0) {
                                currentIndex = 0;
                            } else {
                                currentIndex = ((j + 1) - maxSequence);
                            }
                            if (currentIndex < startingIndex) {
                                toShow = dnasArray[i];
                                maxSum = currentSum;

                                startingIndex = currentIndex;
                            } else if (currentIndex == startingIndex) {
                                if (currentSum > maxSum) {
                                    toShow = dnasArray[i];
                                    maxSum = currentSum;
                                }
                            }

                            continue;
                        }

                    }
                }

            }

        }


        System.out.printf("Best DNA sample %d with sum: %d.\n%s", startingIndex, maxSum, toShow);


    }
}
