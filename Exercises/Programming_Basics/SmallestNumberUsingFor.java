package com.softuni;

import java.util.Scanner;

public class SmallestNumberUsingFor {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int min=Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(scanner.nextLine());
            if(val < min){
                min=val;
            }
        }
        System.out.println(min);
    }
}
