package com.softuni;

import java.util.Scanner;

public class DrawStop {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int totLength=2*(n+1)+(2*n)+1;
       // System.out.println("tot "+totLength);
        for(int i=0;i<=n+1;i++){
            if(i==0){
                System.out.print(drawForm(".", n + 1 - i));
                System.out.print(drawForm("_", 2 * n + 1));
                System.out.println(drawForm(".", n + 1 - i));

            }else if(i== n+1){
                System.out.print(drawForm(".", n + 1 - i));
                System.out.print("//");
                System.out.print(drawForm("_", (totLength-2*(n + 1 - i)-2)/2-3));
                System.out.print("STOP!");
                System.out.print(drawForm("_", (totLength-2*(n + 1 - i)-2)/2-3));

                System.out.print("\\\\");
                System.out.println(drawForm(".", n + 1 - i));
            }else{
                System.out.print(drawForm(".", n + 1 - i));
                System.out.print("//");
                System.out.print(drawForm("_", totLength-2*(n + 1 - i)-4));
                System.out.print("\\\\");
                System.out.println(drawForm(".", n + 1 - i));
            }
        }



        for(int i=n+2;i>=3;i--){
            if(i==(n+2)){
                System.out.print("\\\\");
                System.out.print(drawForm("_", (totLength-2)-2));
                System.out.println("//");
            }else{
                System.out.print(drawForm(".", n + 2 - i));
                System.out.print("\\\\");
                System.out.print(drawForm("_", totLength-2-2*(n+2-i)-2));
                System.out.print("//");
                System.out.println(drawForm(".", n + 2- i));
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
