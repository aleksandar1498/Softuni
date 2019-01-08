package com.softuni;

import java.util.Scanner;

public class IvoShopping {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Double.parseDouble(scanner.nextLine());
        int numChocolates=Integer.parseInt(scanner.nextLine());
        double litresMilk=Double.parseDouble(scanner.nextLine());
        double mandarinQuantity=Math.floor(numChocolates*.65);

        double totPrice=numChocolates*.65 + litresMilk*2.70 + mandarinQuantity*.20;
        if(budget >= totPrice){
            System.out.printf("You got this, %.2f money left!",budget-totPrice);
        }else{
            System.out.printf("Not enough money, you need %.2f more!",totPrice-budget);
        }
    }
}
