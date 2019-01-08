package com.softuni;

import java.util.Scanner;

public class GreaterNumberUsingFor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(scanner.nextLine());
            if(val > max){
                max=val;
            }
        }
        System.out.println(max);
    }
}
