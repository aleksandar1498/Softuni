package com.softuni;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PartyInvite {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int sumValid = 0, sumInvalid = 0;
        Pattern validateString = Pattern.compile("^[a-zA-Z]*$");
        String action = scanner.nextLine();

        while (!action.equals("Statistic")) {
            Matcher check = validateString.matcher(action);
            if (check.find()) {

                System.out.println(action.substring(0, 1).toUpperCase() + "" + action.substring(1, action.length()).toLowerCase());

                sumValid++;

            } else {
                sumInvalid++;
                System.out.println("Invalid name!");
            }
        action=scanner.nextLine();
        }

        System.out.printf("Valid names are %.2f%% from %d names.\n",(sumValid*100.0)/(sumValid+sumInvalid),sumInvalid+sumValid);
        System.out.printf("Invalid names are %.2f%% from %d names.\n",(sumInvalid*100.0)/(sumValid+sumInvalid),sumInvalid+sumValid);

    }
}
