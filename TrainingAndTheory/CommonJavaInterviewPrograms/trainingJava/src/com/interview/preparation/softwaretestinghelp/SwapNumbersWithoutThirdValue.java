package com.interview.preparation.softwaretestinghelp;

import java.util.Scanner;

public class SwapNumbersWithoutThirdValue {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = 1111111111;
        int b = 222222222;

        long start  = System.nanoTime();
        int temp = a;
        a = b;
        b = temp;
        System.out.println(System.nanoTime()-start);
        start  = System.nanoTime();
        a = a+b;
        b = a-b;
        a = a-b;
        System.out.println(System.nanoTime()-start);

    }
}
