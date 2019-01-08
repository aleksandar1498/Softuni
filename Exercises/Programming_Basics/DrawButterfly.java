package com.softuni;

import java.util.Scanner;

public class DrawButterfly {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < 2 * (n - 2) + 1 ; i++) {

            if(i== (n-2)){
                System.out.print(drawForm(" ",n-1));
                System.out.print("@");
                System.out.print(drawForm(" ",n-1));
            }else {
                if (i % 2 == 0) {
                    if(i > (n-2)){
                        System.out.print(drawForm("*", n - 2));
                        System.out.print("/");
                        System.out.print(" ");
                        System.out.print("\\");
                        System.out.print(drawForm("*", n - 2));
                    }else {
                        System.out.print(drawForm("*", n - 2));
                        System.out.print("\\");
                        System.out.print(" ");
                        System.out.print("/");
                        System.out.print(drawForm("*", n - 2));
                    }
                } else {
                    if(i > (n-2)){
                        System.out.print(drawForm("-", n - 2));
                        System.out.print("/");
                        System.out.print(" ");
                        System.out.print("\\");
                        System.out.print(drawForm("-", n - 2));

                    }else {
                        System.out.print(drawForm("-", n - 2));
                        System.out.print("\\");
                        System.out.print(" ");
                        System.out.print("/");
                        System.out.print(drawForm("-", n - 2));
                    }
                }
            }
            System.out.println();
            /*if(i%2 == 0){
                if(i==(n/2)-1){

                }
            }else{
                if(i== n/2){

                }
            }*/
        }
    }
    public static String drawForm(String sym,int col){
        StringBuffer sb=new StringBuffer();
        for (int i = 0; i < col; i++) {
            sb.append(sym);
        }
        return  sb.toString();
    }
}
