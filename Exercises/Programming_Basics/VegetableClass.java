package com.softuni;

import java.util.Scanner;

public class VegetableClass {
    public static void main(String [] args){
        Scanner input=new Scanner(System.in);
        double vegetablePriceInLeva=0,fruitPriceInLeva=0,weightVegetables=0,weightFruit=0;

            vegetablePriceInLeva = Double.parseDouble(input.nextLine());
            fruitPriceInLeva = Double.parseDouble(input.nextLine());
            weightVegetables = Double.parseDouble(input.nextLine());
            weightFruit = Double.parseDouble(input.nextLine());
        System.out.println(((fruitPriceInLeva*weightFruit)+(vegetablePriceInLeva*weightVegetables))/1.94);
    }
}
