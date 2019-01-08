package com.softuni;

import java.util.Scanner;

public class SquarePants {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<n;i++){
            if(i!=0 && i!= (n-1)){
                System.out.print("|");
                System.out.print(createFrom(" -",n-2));
                System.out.println(" |");
            }else{
                System.out.print("+");
                System.out.print(createFrom(" -",n-2));
                System.out.println(" +");
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
