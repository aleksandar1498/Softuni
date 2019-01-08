package com.softuni;

import java.util.Scanner;

public class PerfectDiamond {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        int n=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            System.out.print(drawSpace(n-i-1," "));
            System.out.print(drawForm(i*2+1,"*","-"));
            System.out.println(drawSpace(n-i-1," "));

        }
        for(int i=n-2;i>=0;i--){
            System.out.print(drawSpace(n-i-1," "));
            System.out.print(drawForm(i*2+1,"*","-"));
            System.out.println(drawSpace(n-i-1," "));

        }

    }
    public static String drawForm(int n,String form,String form2){
        StringBuffer builder=new StringBuffer();
        for(int i=0;i<n;i++){
            if(i%2 == 0){
                builder.append(form);
            }else{
            builder.append(form2);
        }
        }
        return builder.toString();
    }
    public static String drawSpace(int n,String form){
        StringBuffer builder=new StringBuffer();
        for(int i=0;i<n;i++){

                builder.append(form);


        }
        return builder.toString();
    }
}
