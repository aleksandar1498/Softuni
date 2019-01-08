package com.softuni;

import java.util.Scanner;

public class EnumerationUsage {
    enum Currency{BGN, EUR, GBP, USD};
    enum CurrencyWithVal{
        BGN(1.98),USD(1.78),GBP(2.54),EUR(2);
        private double val;
        CurrencyWithVal(double v){
            val=v;
        }
        double getCurrency(){return val;}
        void setCurrency(CurrencyWithVal c,double newCurrency){c.val=newCurrency;}
    }
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        CurrencyWithVal cur[]=CurrencyWithVal.values();
       for(CurrencyWithVal c: cur){
           System.out.println(c.getCurrency());
       }

       cur[0].setCurrency(cur[0],1.76);
        System.out.println("NEW VALUES :");
        for(CurrencyWithVal c: cur){
            System.out.println(c.getCurrency());
        }
    }
}
