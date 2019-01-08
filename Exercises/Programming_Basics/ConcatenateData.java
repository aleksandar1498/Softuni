package com.softuni;

import java.util.Scanner;

public class ConcatenateData {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String name=scanner.nextLine();
        String surname=scanner.nextLine();
        int age=Integer.parseInt(scanner.nextLine());
        String town=scanner.nextLine();
        System.out.printf("You are %s %s, a %d-years old person from %s.",name,surname,age,town);
    }
}
