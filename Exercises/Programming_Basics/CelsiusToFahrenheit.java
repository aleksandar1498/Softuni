package com.softuni;

import java.util.Scanner;

public class CelsiusToFahrenheit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continueLoop=true;
        String startingParameter = "", finalParameter = "";
    do {
        do {
            startingParameter = scanner.nextLine();
            if (startingParameter.equalsIgnoreCase("C") == false && startingParameter.equalsIgnoreCase("F") == false) {
                System.out.println("Attention , your input is not valid");
            }
        } while (startingParameter.equalsIgnoreCase("C") == false && startingParameter.equalsIgnoreCase("F") == false);
        do {
            finalParameter = scanner.nextLine();
            if (finalParameter.equalsIgnoreCase("C") == false && finalParameter.equalsIgnoreCase("F") == false) {
                System.out.println("Attention , your input is not valid");
            }
        } while (finalParameter.equalsIgnoreCase("C") == false && finalParameter.equalsIgnoreCase("F") == false);
        System.out.println("Insert the temperature");
        double temperature = Double.parseDouble(scanner.nextLine());
        switch (startingParameter.toLowerCase()) {
            case "c":
                switch (finalParameter.toLowerCase()) {
                    case "f":
                        double f = temperature * 1.8 + 32;
                        System.out.println("The converted temperature in " + finalParameter + " is " + f);

                        break;
                    case "c":
                        System.out.println("The temperature is already in Celsius");
                        break;
                    default:
                        System.out.println("Input not valid");
                        break;

                }
                break;
            case "f":
                switch (finalParameter.toLowerCase()) {
                    case "f":
                        System.out.println("The temperature is already in Fahrenheit");
                        break;
                    case "c":
                        double c = 5 * (temperature - 32) / 9;
                        System.out.println("The converted temperature in " + finalParameter + " is " + c);
                        break;
                    default:
                        System.out.println("Input not valid");
                        break;

                }
                break;
            default:
                System.out.println("Input not valid");
                break;
        }
        System.out.println("Do you want to do another conversion ?");
        if(scanner.nextLine().equalsIgnoreCase("end")){
            continueLoop = false;
        }
    }while(continueLoop);
    }

}
