package com.softuni;

import java.util.Scanner;

public class RectangleWithStars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());;
        if(n%2 == 0){
            for (int i = 0; i <= n; i++) {
                if(i==0 || i== n) {
                    System.out.println(drawLine(n * 2,"%"));
                }else if(i== (n/2)){
                    System.out.print("%");
                    System.out.print(drawLine((n*2-4)/2," "));
                    System.out.print("**");
                    System.out.print(drawLine((n*2-4)/2," "));
                    System.out.println("%");
                }else{
                    System.out.print("%");
                    System.out.print(drawLine((n*2-2)," "));


                    System.out.println("%");
                }

            }
        }else{
            for (int i = 0; i < n+2; i++) {
                if(i==0 || i== n+1) {
                    System.out.println(drawLine(n * 2,"%"));
                }else if(i== ((n+1)/2)){
                    System.out.print("%");
                    System.out.print(drawLine((n*2-4)/2," "));
                    System.out.print("**");
                    System.out.print(drawLine((n*2-4)/2," "));
                    System.out.println("%");
                }else{
                    System.out.print("%");
                    System.out.print(drawLine((n*2-2)," "));


                    System.out.println("%");
                }

            }
        }

    }
    public  static String drawLine(int n,String f){
        StringBuffer bf=new StringBuffer();
        for(int i=0;i<n;i++){
            bf.append(f);
        }
        return bf.toString();
    }
}
