package com.softuni;

import java.util.Scanner;

public class ShoppingManiac {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int budget = Integer.parseInt(scanner.nextLine());
        int spentMoney = 0;
        String action = scanner.nextLine();
        int boughtClothes = 0;
        while (!action.equals("enough")) {
            if (action.equals("enter")) {
                while (!action.equals("leave")) {
                    action = scanner.nextLine();
                    if (!action.equals("leave")) {
                        if (budget - Integer.parseInt(action) < 0) {
                            System.out.println("Not enough money.");
                        } else {
                            budget -= Integer.parseInt(action);

                            spentMoney += Integer.parseInt(action);
                            boughtClothes++;
                            if (budget == 0) {
                                System.out.printf("For %d clothes I spent %d lv and have %d lv left.", boughtClothes, spentMoney, budget);
                                return;
                            }
                        }
                    }
                }
            }
            action = scanner.nextLine();
        }
        System.out.printf("For %d clothes I spent %d lv and have %d lv left.", boughtClothes, spentMoney, budget);
    }
}
