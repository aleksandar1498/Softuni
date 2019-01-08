package com.softuni;

import java.util.Scanner;

public class MoveBricks {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int x=Integer.parseInt(scanner.nextLine());
        int w=Integer.parseInt(scanner.nextLine());
        int m=Integer.parseInt(scanner.nextLine());
        System.out.println(Math.ceil(Double.valueOf(x)/(w*m)));
    }
}
