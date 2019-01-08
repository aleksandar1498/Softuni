package com.softuni;

import java.util.Scanner;

public class CleverLilly {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int age=Integer.parseInt(scanner.nextLine());
        double washerMachine=Double.parseDouble(scanner.nextLine());
        int toysPrice=Integer.parseInt(scanner.nextLine());
        int moneyForGift=10;
        int lillysBudget=0;
        for(int i=1;i<=age;i++){
            if(i%2 == 0){
                lillysBudget+=moneyForGift;
                lillysBudget--;
                moneyForGift+=10;

            }else{
                lillysBudget+=toysPrice;
            }
        }
        if(lillysBudget >= washerMachine){
            System.out.printf("Yes! %.2f",(double)(lillysBudget-washerMachine));
        }else{
            System.out.printf("No! %.2f",(double)(washerMachine-lillysBudget));
        }
    }
}
