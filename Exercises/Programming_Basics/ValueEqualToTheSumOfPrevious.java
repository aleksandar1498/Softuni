package com.softuni;

import java.util.Scanner;

public class ValueEqualToTheSumOfPrevious {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

      /*  int[] vals = new int[n];
        int maxSum = Integer.MIN_VALUE;
        int maxValue = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            vals[i] = Integer.parseInt(scanner.nextLine());
            if (vals[i] > maxValue) {
                maxValue = vals[i];
            }
        }
        for (int i = 0; i < n; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                if (i != j) {
                    sum += vals[j];
                }


            }

            if (vals[i] == sum) {
                System.out.println("Yes\nSum = "+vals[i]);
                return;
            } else {
                if (vals[i] == maxValue) {
                    System.out.println("No\nDiff = "+Math.abs(vals[i] - sum));
                return;
                }


            }
        }*/
// SOLUTION WITHOUT USING ARRAYS
        int sum=0;
        int maxNum=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            int val=Integer.parseInt(scanner.nextLine());
            sum+=val;
            if(val > maxNum){
                maxNum=val;
            }
        }
        sum-=maxNum;
        if(sum == maxNum){
            System.out.println("Yes\nSum = "+sum);
        }else{
            System.out.println("No\nDiff = "+Math.abs(maxNum - sum));

        }
    }
}
