package com.softuni;

import java.util.Scanner;

public class Sum3Number {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum1=0,sum2=0,sum3=0;
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(scanner.nextLine());
            if(i==0 || i%3==0){
                sum1+=x;
            }
          //  System.out.println(((i+1)%3 == 0)+" "+((i+1)%3));
            if(i == 1 || i%3 == 1){
                System.out.println(i+"sum2 "+x);
                sum2+=x;
            }
            if(i == 2 || i%3 == 2){
                sum3+=x;
            }
        }
        System.out.println(sum1+" "+sum2+" "+sum3);
    }
}
