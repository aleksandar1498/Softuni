package com.softuni;

import java.util.Scanner;

public class imagesOfStars {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());

        if(n%2 == 0){
            // create the top of the house
            int k=2;
            for (int i = 0; i < n/2; i++) {
                System.out.print(generateFrom(" ",(n-k)/2));
                System.out.print(generateFrom("*",k));
                System.out.println(generateFrom(" ",(n-k)/2));
                k+=2;
            }
            //Create the base of the house

            for (int i = 0; i < n/2; i++) {
                System.out.print("|");
                System.out.print(generateFrom("*",n-2));
                System.out.println("|");
            }
        }else{
            // create the top of the house
            int k=1;
            for (int i = 0; i < n/2+1; i++) {
                System.out.print(generateFrom("-",(n-k)/2));
                System.out.print(generateFrom("*",k));
                System.out.println(generateFrom("-",(n-k)/2));
                k+=2;
            }
            //Create the base of the house

            for (int i = 0; i <= n/2-1; i++) {
                System.out.print("|");
                System.out.print(generateFrom("*",n-2));
                System.out.println("|");
            }
        }

    }
    public static String generateFrom(String sym,int numOfStars){
        StringBuffer builder=new StringBuffer();
        for(int i=0;i<numOfStars;i++){
            builder.append(sym);
        }
        return  builder.toString();
    }
}
