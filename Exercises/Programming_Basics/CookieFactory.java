package com.softuni;

import java.util.Scanner;

public class CookieFactory {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numBatches=Integer.parseInt(scanner.nextLine());
        int bakedBatches=0;
        String recipe="";
        while (bakedBatches < numBatches){

            String component=scanner.nextLine();
            while(!component.equals("Bake!")){
                recipe=recipe.concat(" "+component);
                component=scanner.nextLine();
            }
            if(recipe.contains("flour") && recipe.contains("eggs") && recipe.contains("sugar")){
                System.out.printf("Baking batch number %d...\n",bakedBatches+1);
                recipe="";
                bakedBatches++;
            }else{
                System.out.println("The batter should contain flour, eggs and sugar!");
            }
        }
    }
}
