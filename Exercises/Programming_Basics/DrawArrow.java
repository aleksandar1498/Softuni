package com.softuni;

import java.util.Scanner;

public class DrawArrow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n*2-1;i++){
            if(i==n-1){
                System.out.print(drawForm("#",(n+1)/2));
                System.out.print(drawForm(".",(n*2-1)-(n+1)));
                System.out.print(drawForm("#",(n+1)/2));
            }else if(i==0){
                System.out.print(drawForm(".",(n*2-1-n)/2));
                System.out.print(drawForm("#",n));
                System.out.print(drawForm(".",(n*2-1-n)/2));
            }else if(i<n-1){
                System.out.print(drawForm(".",(n*2-1-n)/2));
                System.out.print("#");
                System.out.print(drawForm(".",(n*2-1)-(n+1)));
                System.out.print("#");
                System.out.print(drawForm(".",(n*2-1-n)/2));
            }else if(i== n*2-2){
                System.out.print(drawForm(".",i-n+1));
                System.out.print("#");
                System.out.print(drawForm(".",i-n+1));

            }else{
                System.out.print(drawForm(".",i-n+1));
                System.out.print("#");
                System.out.print(drawForm(".",(n*2-1)-2*(i-n+1)-2));
                System.out.print("#");
                System.out.print(drawForm(".",i-n+1));
            }
            System.out.println();
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
