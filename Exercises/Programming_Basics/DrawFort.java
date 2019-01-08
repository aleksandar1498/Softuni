package com.softuni;

import java.util.Scanner;

public class DrawFort {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        if(n < 5) {
            for (int i = 0; i < n; i++) {
                if(i==0) {
                    System.out.print("/");
                    System.out.print(drawForm("^", n - 2));
                    System.out.print("\\");
                    System.out.print("/");
                    System.out.print(drawForm("^", n - 2));
                    System.out.print("\\");
                }else if(i==(n-1)){
                    System.out.print("\\");
                    System.out.print(drawForm("_", n - 2));
                    System.out.print("/");
                    System.out.print("\\");
                    System.out.print(drawForm("_", n - 2));
                    System.out.print("/");
                }else{
                    System.out.print("|");
                    System.out.print(drawForm(" ",n*2-2));
                    System.out.print("|");
                }
                System.out.println();
            }
        }else{
            int colsize=n/2;
            for (int i = 0; i < n; i++) {
                if(i==0) {
                    System.out.print("/");
                    System.out.print(drawForm("^", colsize));
                    System.out.print("\\");
                    System.out.print(drawForm("_", (2*n) - 2 *colsize -4 ));
                    System.out.print("/");
                    System.out.print(drawForm("^", colsize));
                    System.out.print("\\");
                }else if(i==(n-1)){
                    System.out.print("\\");
                    System.out.print(drawForm("_", colsize));
                    System.out.print("/");
                    System.out.print(drawForm(" ", 2*n - 2* colsize-4));
                    System.out.print("\\");
                    System.out.print(drawForm("_", colsize));
                    System.out.print("/");
                }else if(i==(n-2)){
                    System.out.print("|");
                    System.out.print(drawForm(" ", colsize +1));

                    System.out.print(drawForm("_", 2*n - 2 *colsize -4 ));

                    System.out.print(drawForm(" ", colsize+1));
                    System.out.print("|");
                }else{
                    System.out.print("|");
                    System.out.print(drawForm(" ",n*2-2));
                    System.out.print("|");
                }
                System.out.println();
            }
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
