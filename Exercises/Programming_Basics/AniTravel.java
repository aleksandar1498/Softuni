package com.softuni;

import java.util.Scanner;

public class AniTravel {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String action="";

        do{
            action=scanner.nextLine();
            if(!action.equals("End")) {
                int price = Integer.parseInt(scanner.nextLine());
                while (price > 0) {
                    int savedMoney = Integer.parseInt(scanner.nextLine());
                    price -= savedMoney;
                }
                System.out.println("Going to " + action + "!");
            }

        }while(!action.equals("End"));
    }

}
