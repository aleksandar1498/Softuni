package com.softuni;
import java.util.Scanner;
public class RectangleArea {
    public static void main(String [] args) {
        Scanner in = new Scanner(System.in);
        int base =Integer.parseInt(in.nextLine());
        int height = Integer.parseInt(in.nextLine());
        int area = base * height;
        System.out.println(area);
    }
}
