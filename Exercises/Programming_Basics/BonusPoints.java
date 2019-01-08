package com.softuni;

import java.util.Scanner;

public class BonusPoints {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double n=Double.parseDouble(scanner.nextLine());
        double bonus=0;
        if(n <= 100){
            bonus+=5;
        }else if(n>100 && n <= 1000){
            bonus+=(n*.2);
        }else{
            bonus+=(n*.1);
        }
        if(n % 2 == 0){
            bonus++;
        }
        if(n%10 == 5){
            bonus+=2;
        }
        n+=bonus;
        System.out.println(bonus);
        System.out.println(n);
    }
}
