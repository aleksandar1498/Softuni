package com.softuni;

import java.util.Scanner;

public class TicketCombination1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int count=1;
        for (char i = 'B'; i <= 'L' ; i++) {
            for (char j = 'f'; j >= 'a'; j--) {
                for (int k = 'A'; k <= 'C'; k++) {
                    for (int l = 1; l <= 10 ; l++) {
                        for (int m = 10; m >= 1 ; m--) {
                            if(count == n){
                                System.out.printf("Ticket combination: %c%c%c%d%d\n",i,j,k,l,m);
                                System.out.printf("Prize : %d lv.",(int)i+(int)j+(int)k+l+m);
                            }
                            count++;
                        }
                    }
                }
            }
        }
    }
}
