package com.softuni;

import java.util.Scanner;

public class DateAfter5Days {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int d=Integer.parseInt(scanner.nextLine());
        int m=Integer.parseInt(scanner.nextLine());
        int days=0;
        if(m==4 || m==6 || m==9 || m==11){
            days=30;
        }else if(m==2){
            days=28;
        }else{
            days=31;
        }
        if((d+5) > days){
            if(m+1 > 12){
                m=1;
            }else{
                m++;
            }
            d=d+5;
            d%=days;
            System.out.printf("%d.%02d",d,m);
        }else{
            d=d+5;
            d%=days;
            System.out.printf("%d.%02d",d,m);
        }
    }
}
