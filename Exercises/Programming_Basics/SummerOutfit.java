package com.softuni;

import java.util.Scanner;

public class SummerOutfit {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int deg=Integer.parseInt(scanner.nextLine());
        String partOfDay=scanner.nextLine();
        switch (partOfDay){
            case "Morning":
                if(deg >= 10 && deg <= 18){
                    System.out.printf("It's %d degrees, get your Sweatshirt and Sneakers.",deg);
                }else if(deg <= 24){
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.",deg);
                }else{
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.",deg);
                }
                break;
            case "Afternoon":
                if(deg >= 10 && deg <= 18){
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.",deg);
                }else if(deg <= 24){
                    System.out.printf("It's %d degrees, get your T-Shirt and Sandals.",deg);
                }else{
                    System.out.printf("It's %d degrees, get your Swim Suit and Barefoot.",deg);
                }
                break;
            case "Evening":
                if(deg >= 10 && deg <= 18){
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.",deg);
                }else if(deg <= 24){
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.",deg);
                }else{
                    System.out.printf("It's %d degrees, get your Shirt and Moccasins.",deg);
                }
                break;
        }
    }
}
