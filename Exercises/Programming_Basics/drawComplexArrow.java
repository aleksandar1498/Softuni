package com.softuni;

import java.util.Scanner;

public class drawComplexArrow {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int size=Integer.parseInt(scanner.nextLine());
        int width=size+5;
        System.out.print(drawForm((width-1)/2,"_"));
        System.out.print("^");
        System.out.println(drawForm((width-1)/2,"_"));
        System.out.print(drawForm((width-2)/2,"_"));
        System.out.print("/|\\");
        System.out.println(drawForm((width-2)/2,"_"));
       for (int i = 0; i < size/2 ; i++) {
            System.out.print(drawForm((width-5)/2-i,"_"));
            System.out.print("/");
            System.out.print(drawForm(i,"."));
            System.out.print("|||");
            System.out.print(drawForm(i,"."));
            System.out.print("\\");
            System.out.println(drawForm((width-5)/2-i,"_"));
        }
        System.out.print(drawForm((width-9)/2,"_"));
        System.out.print("/..|||..\\");
        System.out.println(drawForm((width-9)/2,"_"));
        System.out.print(drawForm((width-7)/2,"_"));
        System.out.print("/.|||.\\");
        System.out.println(drawForm((width-7)/2,"_"));
        for (int i = 0; i < size; i++) {
            System.out.print(drawForm((width-3)/2,"_"));
            System.out.print("|||");
            System.out.println(drawForm((width-3)/2,"_"));
        }
        System.out.print(drawForm((width-3)/2,"_"));
        System.out.print("~~~");
        System.out.println(drawForm((width-3)/2,"_"));
        for (int i = 0; i < size/2 ; i++) {
            System.out.print(drawForm((width-5)/2-i,"_"));
            System.out.print("//");
            System.out.print(drawForm(i,"."));
            System.out.print("!");
            System.out.print(drawForm(i,"."));
            System.out.print("\\\\");
            System.out.println(drawForm((width-5)/2-i,"_"));
        }
    }

    public static String drawForm(int n,String sym){
        StringBuffer draw=new StringBuffer();
        for(int i=0;i<n;i++){
            draw.append(sym);
        }
        return  draw.toString();
    }
}
