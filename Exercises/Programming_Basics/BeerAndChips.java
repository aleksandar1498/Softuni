package com.softuni;

import java.util.Scanner;

public class BeerAndChips {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String fanName=scanner.nextLine();
        double budget=Double.parseDouble(scanner.nextLine());
        int numBeers=Integer.parseInt(scanner.nextLine());
        int numChips=Integer.parseInt(scanner.nextLine());
        double totPrice=numBeers*1.20;
        totPrice+=Math.ceil((totPrice*.45)*numChips);
        if(totPrice <= budget){
            System.out.printf("%s bought a snack and has %.2f leva left.",fanName,budget-totPrice);
        }else{
            System.out.printf("%s needs %.2f more leva.",fanName,(totPrice-budget));
        }
    }
}
