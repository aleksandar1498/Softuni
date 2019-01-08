package com.softuni;

import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.setOut;

public class DrawAxe {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(in);
        int n=Integer.parseInt(scanner.nextLine());
        int i =0;
            for(i =0 ;i<n;i++){
                System.out.print(drawForm("-",3*n));
                System.out.print("*");
                System.out.print(drawForm("-",i));
                System.out.print("*");
                System.out.println(drawForm("-",2*n-i-2));
            }
        for(int j =0 ;j<n/2;j++){
            System.out.print(drawForm("*",3*n+1));
            System.out.print(drawForm("-",i-1));
            System.out.print("*");
            System.out.println(drawForm("-",2*n-(i-1)-2));
        }
        for(int k =0 ;k<n/2;k++){
            if(k== (n/2-1)){
                System.out.print(drawForm("-", 3 * n - k));
                System.out.print("*");
                System.out.print(drawForm("*", k*2 + i - 1));
                System.out.print("*");
                System.out.println(drawForm("-", 2 * n - (i - 1) - 2 - k));

            }else {
                System.out.print(drawForm("-", 3 * n - k));
                System.out.print("*");
                System.out.print(drawForm("-", k*2 + i - 1));
                System.out.print("*");
                System.out.println(drawForm("-", 2 * n - (i - 1) - 2 - k));
            }
        }
     

    }
    public static String drawForm(String sym,int col){
        StringBuffer sb=new StringBuffer();
        // System.out.println(col);
        for (int i = 0; i < col; i++) {
            sb.append(sym);
        }
        return  sb.toString();
    }
}
