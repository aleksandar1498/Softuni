package com.softuni;

import java.util.Scanner;



        public class HotelRoom1 {
            public static void main(String[] args) {
                Scanner scanner = new Scanner(System.in);

                int hours = Integer.parseInt(scanner.nextLine());
                int minute = Integer.parseInt(scanner.nextLine());
                int hourCome = Integer.parseInt(scanner.nextLine());
                int minCome = Integer.parseInt(scanner.nextLine());

                int examTime = hours * 60 + minute;
                int arrivalTime = hourCome * 60 + minCome;

                int result = arrivalTime - examTime;

                if (result > 0) {
                    System.out.println("Late");
                    if (result < 60) {
                        System.out.printf("%d minutes after the start", result);
                    } else if (result >= 60) {
                        System.out.printf("%d:%02d hours after the start", result / 60, result % 60);
                    }
                } else if (result <= 0 && result >= -30) {
                    System.out.println("On time");
                    if (result < 0) {
                        System.out.printf("%d minutes before the start", Math.abs(result));
                    }
                } else if (result < -30) {
                    System.out.println("Early");
                    if (result > -60) {
                        System.out.printf("%d minutes before the start", Math.abs(result));
                    } else if (result <= -60) {
                        System.out.printf("%d:%02d hours before the start", Math.abs(result)/60, Math.abs(result)%60);
                    }
                }
            }
        }
