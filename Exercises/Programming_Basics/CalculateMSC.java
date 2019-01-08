package com.softuni;

import java.util.Scanner;

public class CalculateMSC {
    enum MSCresults{
        UNDERWEIGHT,OK,OVERWEIGHT,OBESE
    }
    public static void main(String[] args) {

        Scanner scanner=new Scanner(System.in);
        MSCresults msc;
        double weight=Double.parseDouble(scanner.nextLine());
        double height=Double.parseDouble(scanner.nextLine());
        double IMC = weight / Math.pow(height,2);
        System.out.println(IMC);
        if(IMC < 18.5){
            msc=MSCresults.UNDERWEIGHT;
        }else if(IMC < 25 ){
            msc=MSCresults.OK;
        }else if(IMC < 30){
            msc=MSCresults.OVERWEIGHT;
        }else{
            msc=MSCresults.OBESE;
        }
        System.out.println(msc);
    }
}
