package com.softuni;

import java.text.DecimalFormat;
import java.util.Scanner;

public class OddAndEvenPositions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double OddSum=0;
        double EvenSum=0;
        double OddMin=Integer.MAX_VALUE;
        double EvenMin=Integer.MAX_VALUE;
        double OddMax=Integer.MIN_VALUE;
        double EvenMax=Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            double val=Double.parseDouble(scanner.nextLine());
            if(i%2 == 0){
                OddSum+=val;
                if(val > OddMax){
                    OddMax=val;
                }
                if( val < OddMin){
                    OddMin=val;
                }
            }else if(i%2 == 1){

                EvenSum+=val;
                if(val > EvenMax){
                    EvenMax=val;
                }
                if( val < EvenMin){
                    EvenMin=val;
                }
            }
        }
        if(OddSum-(int)OddSum != 0){
            System.out.println("OddSum="+OddSum+",");

        }else{
            System.out.println("OddSum="+(int)OddSum+",");
        }

        if(OddMin == Integer.MAX_VALUE){
            System.out.println("OddMin=No,");
        }else{
            if(OddMin-(int)OddMin != 0){
                System.out.println("OddMin="+OddMin+",");
            }else{
                System.out.println("OddMin="+(int)OddMin+",");
            }

        }
       if(OddMax == Integer.MIN_VALUE){
           System.out.println("OddMax=No");
       }else{
           if(OddMax-(int)OddMax != 0) {
               System.out.println("OddMax=" + OddMax);
           }else{
               System.out.println("OddMax=" + (int)OddMax);
           }
       }


        if(EvenSum-(int)EvenSum != 0){
            System.out.println("EvenSum="+EvenSum+",");

        }else{
            System.out.println("EvenSum="+(int)EvenSum+",");
        }

       if(EvenMin == Integer.MAX_VALUE){
           System.out.println("EvenMin=No");
       }else {
           if(EvenMin-(int)EvenMin != 0){
               System.out.println("EvenMin="+EvenMin+",");

           }else{
               System.out.println("EvenMin="+(int)EvenMin+",");
           }

       }
        if(EvenMax == Integer.MIN_VALUE){
            System.out.println("EvenMax=No");
        }else {
            if(EvenMax-(int)EvenMax != 0){
                System.out.println("EvenMax="+EvenMax+",");

            }else{
                System.out.println("EvenMax="+(int)EvenMax+",");
            }
        }
        // I can use in alternative DecimalFormat
       /* DecimalFormat dc=new DecimalFormat("#.##");

            System.out.println("OddSum="+dc.format(OddSum)+",");



        if(OddMin == Integer.MAX_VALUE){
            System.out.println("OddMin=No,");
        }else{

                System.out.println("OddMin="+dc.format(OddMin)+",");


        }
        if(OddMax == Integer.MIN_VALUE){
            System.out.println("OddMax=No");
        }else{

                System.out.println("OddMax=" + dc.format(OddMax));

        }



            System.out.println("EvenSum="+dc.format(EvenSum)+",");


        if(EvenMin == Integer.MAX_VALUE){
            System.out.println("EvenMin=No");
        }else {

                System.out.println("EvenMin="+dc.format(EvenMin)+",");


        }
        if(EvenMax == Integer.MIN_VALUE){
            System.out.println("EvenMax=No");
        }else {
                System.out.println("EvenMax="+dc.format(EvenMax)+",");


        }*/

    }
}
