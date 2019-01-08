package com.softuni;

import java.util.Scanner;

public class Sunglasses {
    public static void main(String[] args) {
     Scanner scanner=new Scanner(System.in);
     int n=Integer.parseInt(scanner.nextLine());
        for (int i = 0; i <n ; i++) {
            if(i!=0 && i!= n-1){
                if(((n%2 == 0) && (i== (n/2)-1)) || ((n%2 == 1) && (i== (n+1)/2-1))){
                    System.out.print("*");
                    System.out.print(createFrom("/",n*2-2));
                    System.out.print("*");
                    System.out.print(createFrom("|",n));
                    System.out.print("*");
                    System.out.print(createFrom("/",n*2-2));
                    System.out.println("*");
                }else{
                    System.out.print("*");
                    System.out.print(createFrom("/",n*2-2));
                    System.out.print("*");
                    System.out.print(createFrom(" ",n));
                    System.out.print("*");
                    System.out.print(createFrom("/",n*2-2));
                    System.out.println("*");
                }
            }else{
                System.out.print(createFrom("*",n*2));
                System.out.print(createFrom(" ",n));
                System.out.println(createFrom("*",n*2));
            }

        }
    }
    public static String createFrom(String sym,int stars){
        StringBuffer toReturn=new StringBuffer();
        for (int i = 0; i < stars; i++) {
            toReturn.append(sym);
        }
        return toReturn.toString();
    }
}
