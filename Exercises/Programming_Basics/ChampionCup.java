package com.softuni;

import java.util.Scanner;

public class ChampionCup {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());;
        int i=0;
        for(i=0;i<n/2;i++){
            System.out.print(drawCup(n+i,"."));
            System.out.print(drawCup(n*3-2*i,"#"));
            System.out.println(drawCup(n+i,"."));
        }
        int j=0;
        for(j=i;j<=i+n/2;j++){
            System.out.print(drawCup(n+j,"."));
            System.out.print("#");
            System.out.print(drawCup(5*n-((n+j)*2+2),"."));
            System.out.print("#");
            System.out.println(drawCup(n+j,"."));
        }
        System.out.print(drawCup(n*2,"."));
        System.out.print(drawCup(n,"#"));
        System.out.println(drawCup(n*2,"."));
        for (int k = 0; k < n/2 ; k++) {
            System.out.print(drawCup(n+j-3,"."));
            System.out.print(drawCup(n*5-((n+j-3)*2),"#"));
            System.out.println(drawCup(n+j-3,"."));
        }
        System.out.print(drawCup((n*5-10)/2,"."));
        System.out.print("D^A^N^C^E^");
        System.out.println(drawCup((n*5-10)/2,"."));
        for (int k = 0; k < n/2 ; k++) {
            System.out.print(drawCup(n+j-3,"."));
            System.out.print(drawCup(n*5-((n+j-3)*2),"#"));
            System.out.println(drawCup(n+j-3,"."));
        }

    }
    public static String drawCup(int n , String sym){
        StringBuffer builder=new StringBuffer();
        for(int i=0;i<n;i++){
            builder.append(sym);
        }
        return builder.toString();
    }
}
