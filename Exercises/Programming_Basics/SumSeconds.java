package com.softuni;

import java.util.Scanner;

public class SumSeconds {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int secRunner1=Integer.parseInt(scanner.nextLine());
        int secRunner2=Integer.parseInt(scanner.nextLine());
        int secRunner3=Integer.parseInt(scanner.nextLine());
        int sum=secRunner1+secRunner2+secRunner3;
        int min=sum/60;
        int sec=sum - (min * 60);

            if(sec < 10){
                System.out.println(min+":0"+sec);
            }else{
                System.out.println(min+":"+sec);
            }

    }
}
