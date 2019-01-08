package com.softuni;

import java.util.Scanner;

public class ChocolateBarrets {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int bars=Integer.parseInt(scanner.nextLine());
        int bonus=bars;

        do {
            if((int)(bonus/ 6) == 0){
                break;
            }
            int newBonus = bonus / 6;
            System.out.println("new "+newBonus);
            bars+=newBonus;
            bonus = (bonus % 6) + newBonus;
            System.out.println(" - "+bonus);

        } while(bonus % 6 == 0);
        System.out.println(bars+" "+bonus);

    }
}
