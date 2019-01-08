package com.softuni;

import java.util.Scanner;

public class EqualPair {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
       /*int sum[]=new int[n];
       int minSum=Integer.MAX_VALUE;
       int maxSum=Integer.MIN_VALUE;
        for (int i = 0; i < n ; i++) {
                int num1=Integer.parseInt(scanner.nextLine());
                int num2=Integer.parseInt(scanner.nextLine());
                sum[i]=num1+num2;

                if(sum[i] > maxSum){
                    maxSum=sum[i];
                }
                if(sum[i] < minSum){
                    minSum=sum[i];
                }
        }
        for (int i = 0; i < sum.length-1; i++) {
           if(sum[i] != sum[i+1]){
               System.out.printf("No, maxdiff=%d",maxSum-minSum);
               return;
           }
        }
        System.out.printf("Yes, value=%d",sum[0]);
        */
       // SOLUTION WITHOUT ARRAY'S
        int maxDiff=Integer.MIN_VALUE;
        int oldSum=0;
        boolean allEqual=true;
        for (int i = 0; i < n; i++) {

            int a=Integer.parseInt(scanner.nextLine());
            int b=Integer.parseInt(scanner.nextLine());
            int sum=a+b;

            if(i == 0){
                oldSum=sum;
            }else{
                if(Math.abs(sum-oldSum) > maxDiff){
                    maxDiff=Math.abs(sum-oldSum);
                }
                if(sum != oldSum){
                    allEqual=false;
                }
                oldSum=sum;
            }

        }
        if(allEqual) {
            System.out.printf("Yes, value=%d", oldSum);
        }else{
            System.out.printf("No, maxdiff=%d",maxDiff);
        }

    }
}
