package com.interview.preparation.javarevisited;

public class ArmstrongNumber {
    public static void main(String[] args) {
        System.out.println(isArmstrongNumber(154));
    }

    private static boolean isArmstrongNumber(int number) {
        int sum = 0;
        int n = number;
        while(number != 0){
            int reminder = number%10;
            sum+=Math.pow(reminder,3);
            number/=10;
        }
        return  sum == n;
    }
}
