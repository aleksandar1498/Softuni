package com.softuni;

import java.util.Scanner;

public class TradeComissions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String town=scanner.nextLine();
        double com=Double.parseDouble(scanner.nextLine());;
        if(town.equals("Sofia")){
            if(com>= 0 && com <= 500){
                System.out.printf("%.2f",com*.05);
            }else if(com> 500 && com <= 1000){
                System.out.printf("%.2f",com*.07);
            }else if(com> 1000 && com <= 10000){
                System.out.printf("%.2f,",com*.08);
            }else if(com> 10000){
                System.out.printf("%.2f",com*0.12);
            }else {
                System.out.println("error");
            }
        }else if(town.equals("Varna")){
            if(com>= 0 && com <= 500){
                System.out.printf("%.2f",com*.045);
            }else if(com> 500 && com <= 1000){
                System.out.printf("%.2f",com*.075);
            }else if(com> 1000 && com <= 10000){
                System.out.printf("%.2f",com*.1);
            }else if(com> 10000){
                System.out.printf("%.2f",com*0.13);
            }else {
                System.out.println("error");
            }
        }else if(town.equals("Plovdiv")){
            if(com>= 0 && com <= 500){
                System.out.printf("%.2f",com*.055);
            }else if(com> 500 && com <= 1000){
                System.out.printf("%.2f",com*.08);
            }else if(com> 1000 && com <= 10000){
                System.out.printf("%.2f",com*.12);
            }else if(com> 10000){
                System.out.printf("%.2f",com*.145);
            }else {
                System.out.println("error");
            }
        }else{
            System.out.println("error");
        }
    }
}
