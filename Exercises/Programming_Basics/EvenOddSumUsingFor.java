package com.softuni;

import java.util.Scanner;

public class EvenOddSumUsingFor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int oddSum=0,evenSum=0;
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(scanner.nextLine());
            if(i%2 == 0){

                oddSum+=val;
            }else{
                evenSum+=val;
            }
        }
        if(oddSum == evenSum){
            System.out.printf("Yes, sum = %d",evenSum);
        }else{
            System.out.printf("No, diff = %d",Math.abs(evenSum-oddSum));
        }
    }
}
