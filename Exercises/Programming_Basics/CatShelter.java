package com.softuni;

import java.util.Scanner;

public class CatShelter {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int boughtFood=Integer.parseInt(scanner.nextLine());;
boughtFood*=1000;
        boolean adopted=false;
        while (adopted == false){
            String action= scanner.nextLine();
            if(action.equals("Adopted")){
                adopted=true;

            }else{
                boughtFood-=Integer.parseInt(action);
            }

        }
        if(boughtFood >= 0){
            System.out.printf("Food is enough! Leftovers: %d grams",boughtFood);
        }else{
            System.out.printf("Food is not enough. You need %d grams mor",Math.abs(boughtFood));
        }
    }
}
