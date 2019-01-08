package com.softuni;

import java.util.Scanner;

public class OrderStrings {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String [] strings=new String[4];
        for(int i=0;i<strings.length;i++){
            strings[i]=scanner.nextLine();
        }
        for(int x=0;x<strings.length-1;x++){
            for(int y=x+1;y<strings.length;y++){

                // greater than 0  ->  A > B
                // less than 0 -> A < B
                // equal to 0 -> A == B
                if(strings[x].compareTo(strings[y]) > 0){
                    String temp= strings[x];
                    strings[x]=strings[y];
                    strings[y]=temp;
                }
            }
        }
        for(String word: strings){
            System.out.print(" "+word);
        }

    }
}
