package com.softuni;

import java.util.Scanner;

public class PointOnSegment {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x1 = Integer.parseInt(scanner.nextLine());
        int x2 = Integer.parseInt(scanner.nextLine());
        int p = Integer.parseInt(scanner.nextLine());
        int left = Math.min(x1, x2);
        int right = Math.max(x1, x2);
        if (p >= left && p <= right) {
            System.out.println("in");

        } else {
            System.out.println("out");
        }
        System.out.println(Math.min(Math.abs(left - p), Math.abs(right - p)));
    }
}
