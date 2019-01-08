package com.softuni;

import java.util.Scanner;

public class SumOfPrimesAndNot {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int sumPrime=0,sumNonPrime=0;
        String action=scanner.nextLine();
        while(!action.equals("stop")){
            int divisors=0,c=1;
            int val=Integer.parseInt(action);
            if(val < 0){
                System.out.println("Number is negative.");

            }else {
                while (c <= val) {
                    if (val % c == 0) {
                        divisors++;
                    }
                    c++;
                }
                if (divisors > 2 || val == 1) {
                    sumNonPrime += val;

                } else{

                    sumPrime += val;

                }

            }
            action = scanner.nextLine();

        }
        System.out.printf("Sum of all prime numbers is: %d\n",sumPrime);
        System.out.printf("Sum of all non prime numbers is: %d",sumNonPrime);
    }
}
