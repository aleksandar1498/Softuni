package com.softuni;

import java.util.Scanner;

public class ChangeTiles2 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double budget=Integer.parseInt(scanner.nextLine());
        double widthFloor=Double.parseDouble(scanner.nextLine());
        double lengthFloor=Double.parseDouble(scanner.nextLine());
        double lengthTile=Double.parseDouble(scanner.nextLine());
        double heightTile=Double.parseDouble(scanner.nextLine());
        double pricePerOneTile=Double.parseDouble(scanner.nextLine());
        double workerSalary=Double.parseDouble(scanner.nextLine());
double areaFloor=widthFloor*lengthFloor;
double areaTile=(lengthTile*heightTile)/2;
int numTiles=(int)(Math.ceil(areaFloor/areaTile)+5);
double priceTiles=numTiles*pricePerOneTile;
if(priceTiles+workerSalary <= budget){
    System.out.printf("%.2f lv left",budget-(priceTiles+workerSalary));
}else{
    System.out.printf("You'll need %.2f lv more",priceTiles+workerSalary-budget);
}
    }
}
