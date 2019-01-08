package com.softuni;

import java.util.Scanner;

public class Money {

    public static void main(String [] args){
        Scanner input=new Scanner(System.in);
    int numOfBitcoins=Integer.parseInt(input.nextLine());
    double numOfYoan=0,com=0,euro=0;
    numOfYoan=Double.parseDouble(input.nextLine());
    com=Double.parseDouble(input.nextLine());
    euro+=(numOfBitcoins*1168)/1.95;
    euro+=((numOfYoan*.15)*1.76)/1.95;
    euro-=(com*euro)/100;

    System.out.println(euro);


    }
}
