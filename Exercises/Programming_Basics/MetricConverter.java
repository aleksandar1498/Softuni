package com.softuni;

import java.util.Scanner;

public class MetricConverter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double n=Double.parseDouble(scanner.nextLine());
        String startingType=scanner.nextLine();
        String finalType=scanner.nextLine();
        if(startingType.toLowerCase().equals("mm")){
            n/=1000;
        }else if(startingType.toLowerCase().equals("cm")){
            n/=100;
        }else if(startingType.toLowerCase().equals("mi")){
            n/=0.000621371192;
        }else if((startingType.toLowerCase().equals("in"))){
            n/=39.3700787;
        }else if(startingType.toLowerCase().equals("km")){
            n/=0.001;
        }else if(startingType.toLowerCase().equals("ft")){
            n/=3.2808399;
        }else if(startingType.toLowerCase().equals("yd")){
            n/=1.0936133;
        }

        if(finalType.toLowerCase().equals("mm")){
            n*=1000;
        }else if(finalType.toLowerCase().equals("cm")){
            n*=100;
        }else if(finalType.toLowerCase().equals("mi")){
            n*=0.000621371192;
        }else if((finalType.toLowerCase().equals("in"))){
            n*=39.3700787;
        }else if(finalType.toLowerCase().equals("km")){
            n*=0.001;
        }else if(finalType.toLowerCase().equals("ft")){
            n*=3.2808399;
        }else if(finalType.toLowerCase().equals("yd")){
            n*=1.0936133;
        }
        System.out.printf("%.8f",n);
    }
}
