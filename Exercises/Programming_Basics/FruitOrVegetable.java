package com.softuni;

import java.util.Scanner;

public class FruitOrVegetable {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String yourInput = scanner.nextLine();
    if(yourInput.equalsIgnoreCase("banana") || yourInput.equalsIgnoreCase("apple") || yourInput.equalsIgnoreCase("kiwi") || yourInput.equalsIgnoreCase("cherry") || yourInput.equalsIgnoreCase("lemon") || yourInput.equalsIgnoreCase("grapes") ){
        System.out.println("fruit");
    }else if(yourInput.equalsIgnoreCase("tomato") || yourInput.equalsIgnoreCase("cucumber") || yourInput.equalsIgnoreCase("pepper") || yourInput.equalsIgnoreCase("carrot")){
        System.out.println("vegetable");
    }else{
        System.out.println("unknown");
    }
    }
}
