package com.softuni;

import java.util.Scanner;

public class ChangeTiles {
    public static void main(String [] args){
        double sizeOfTheLand=0,widthOfTheTiles=0,lengthOfTheTiles=0,widthOfTheBench=0,lengthOfTheBench=0,area=0,numOfTiles=0;
        Scanner input=new Scanner(System.in);
        sizeOfTheLand=Double.parseDouble(input.nextLine());
        widthOfTheTiles=Double.parseDouble(input.nextLine());
        lengthOfTheTiles=Double.parseDouble(input.nextLine());
        widthOfTheBench=Double.parseDouble(input.nextLine());
        lengthOfTheBench=Double.parseDouble(input.nextLine());
        area=(sizeOfTheLand*sizeOfTheLand)-(widthOfTheBench*lengthOfTheBench);
        numOfTiles=(area)/(widthOfTheTiles*lengthOfTheTiles);
        System.out.println(numOfTiles+"\n"+(numOfTiles * 0.2));

    }
}
