package com.softuni;

import java.util.Scanner;

public class CoffeeMachine {
    enum error_code{
        OK("price is ok"),
        Error1("ERROR ! price less than 25 cent"),
        Error2("ERROR ! price is not a multiple of 5"),
        Error3("ERROR ! price is higher than 1 euro");
        private String err;
        error_code (String error){
            this.err=error;
        }
        String getErr(){
            return  err;
        }

    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
       int price = Integer.parseInt(scanner.nextLine());
        error_code ec=error_code.OK;
       // System.out.println(ec);
        if(price < 25){
            ec=error_code.Error1;

        }
        if(price > 100){
            ec=error_code.Error3;

        }
        if(price % 5 != 0){
            ec=error_code.Error2;

        }

        if(ec.getErr().equals(error_code.valueOf("OK").getErr() ) == false) {
            System.out.println(ec.getErr());
            System.exit(0);
        }

        int rest = 100 - price;

        if (rest / 50 > 0) {
            System.out.println(rest / 50 + " 50 cent are needed");
            rest %= 50;
        }
        if (rest / 20 > 0) {
            System.out.println(rest / 20 + " 20 cent");
            rest %= 20;
        }
        if (rest / 10 > 0) {
            System.out.println(rest / 10 + " 10 cent");
            rest %= 10;
        }
        if (rest / 5 > 0) {
            System.out.println(rest / 5 + " 5 cent");
            rest %= 5;
        }
        if (rest / 2 > 0) {
            System.out.println(rest / 2 + " 2 cent");
            rest %= 2;
        }
        if (rest / 1 > 0) {
            System.out.println(rest / 1 + " 1 cent");
        }



    }
}
