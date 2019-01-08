package com.softuni;

import java.util.Scanner;

public class DrawRocket {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());;
        for (int i = 0; i < n; i++) {
            System.out.print(drawRocket((n * 3 - 2) / 2 - i, "."));
            System.out.print("/");
            System.out.print(drawRocket(2 * i, " "));
            System.out.print("\\");

            System.out.println(drawRocket((n * 3 - 2) / 2 - i, "."));

        }
        System.out.print(drawRocket(n / 2, "."));
        System.out.print(drawRocket(2 * n, "*"));
        System.out.println(drawRocket(n / 2, "."));
        for (int j = 0; j < n * 2; j++) {
            System.out.print(drawRocket(n / 2, "."));
            System.out.print("|");
            System.out.print(drawRocket(2 * n - 2, "\\"));
            System.out.print("|");
            System.out.println(drawRocket(n / 2, "."));
        }
        for (int i = 0; i < n/2; i++) {
            System.out.print(drawRocket(n / 2 - i, "."));
            System.out.print("/");
            System.out.print(drawRocket(n*3-((n/2-i)*2+2), "*"));
            System.out.print("\\");

            System.out.println(drawRocket(n / 2 - i, "."));

        }

    }

    public static String drawRocket(int n, String sym) {
        StringBuffer builder = new StringBuffer();
        for (int i = 0; i < n; i++) {
            builder.append(sym);
        }
        return builder.toString();
    }
}
