package com.softuni;

import java.util.Scanner;

public class TailoringWorkshop {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int tables = Integer.parseInt(scanner.nextLine());

        double lengthOfTheTable = Double.parseDouble(scanner.nextLine());
        double widthOfTheTable = Double.parseDouble(scanner.nextLine());
        double area1 = tables * (lengthOfTheTable + 2 * .3) * ((widthOfTheTable + 2 * .3));

        double area2 = tables * ((lengthOfTheTable / 2) * (lengthOfTheTable / 2));

        double totCostUSD = (area1 * 7) + (area2 * 9);
        System.out.printf("%.2f USD\n%.2f BGN", totCostUSD, (totCostUSD * 1.85));

    }
}
