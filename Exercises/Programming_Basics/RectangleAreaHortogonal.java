package com.softuni;

import java.util.Scanner;

public class RectangleAreaHortogonal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double x1 = 0, y1 = 0, x2 = 0, y2 = 0, c1 = 0, c2 = 0;
        x1 = Double.parseDouble(scanner.nextLine());
        y1 = Double.parseDouble(scanner.nextLine());
        x2 = Double.parseDouble(scanner.nextLine());
        y2 = Double.parseDouble(scanner.nextLine());
        c1 = Math.max(x1, x2) - Math.min(x1, x2);
        c2 = Math.max(y1, y2) - Math.min(y1, y2);

        double per = (c1 + c2) * 2;
        double area = c1 * c2;
        System.out.println(area+"\n"+per);

    }
}
