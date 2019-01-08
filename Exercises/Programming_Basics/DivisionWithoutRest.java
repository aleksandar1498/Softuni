package com.softuni;

import java.util.Scanner;

public class DivisionWithoutRest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int divisibleBy2=0;
        int divisibleBy3=0;
        int divisibleBy4=0;
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(scanner.nextLine());
            if(val % 2 == 0){
                divisibleBy2++;
            }
            if(val % 3 == 0){
                divisibleBy3++;
            }
            if(val % 4 == 0){
                divisibleBy4++;
            }
        }
        System.out.printf("%.2f%%\n",((double)divisibleBy2/n)*100.0);
        System.out.printf("%.2f%%\n",((double)divisibleBy3/n)*100.0);
        System.out.printf("%.2f%%",((double)divisibleBy4/n)*100);

    }
}
