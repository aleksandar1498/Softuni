package com.softuni.arrays;

import java.util.HashMap;
import java.util.Scanner;

public class FlowerPrice {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        HashMap<String,Double> flower=new HashMap<String, Double>(){
            {
                put("petunia", .50);
                put("viola del pensiero", .75);
                put("rosa", 1.50);
                put("violetta", .50);
                put("garofano", .80);
            }

        };

        String name=scanner.nextLine();
        double quantity=Double.parseDouble(scanner.nextLine());

        System.out.println(flower.get(name)*quantity);;
    }
}
