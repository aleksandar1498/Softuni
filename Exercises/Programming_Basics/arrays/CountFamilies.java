package com.softuni.arrays;

import java.util.Scanner;

public class CountFamilies {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int k=Integer.parseInt(scanner.nextLine());
        double moneyFamily[]=new double[k];
        double maxVal=Integer.MIN_VALUE;
        for (int i = 0; i < k; i++) {
            moneyFamily[i]=Double.parseDouble(scanner.nextLine());
            if(moneyFamily[i] > maxVal){
                maxVal=moneyFamily[i];
            }
        }
        for(double singleFamilyReddit:moneyFamily){
            if(singleFamilyReddit >= maxVal*.9){
                System.out.println("The reddit of "+singleFamilyReddit+" is high ");
            }
        }
    }
}
