package com.softuni;

import java.util.Scanner;

public class FlowersMagazine {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numH=Integer.parseInt(scanner.nextLine());
        int numR=Integer.parseInt(scanner.nextLine());
        int numL=Integer.parseInt(scanner.nextLine());
        String season=scanner.nextLine();
        String isHoliday=scanner.nextLine();
        double price=0.0;
        if(isHoliday.equals("Y")) {
            switch (season) {
                case "Spring":
                    case "Summer":
                    price=numH*(2.00*1.15);
                    price+=numR*(4.10 * 1.15);
                    price+=numL*(2.50*1.15);
                    break;
                case "Autumn":
                case "Winter":
                    price=numH*(3.75*1.15);
                    price+=numR*(4.50 * 1.15);
                    price+=numL*(4.15*1.15);
                    break;
            }


        }else{
            switch (season) {
                case "Spring":
                case "Summer":
                    price=numH*2.00;
                    price+=numR*4.10;
                    price+=numL*2.50;
                    break;
                case "Autumn":
                case "Winter":
                    price=numH*3.75;
                    price+=numR*4.50 ;
                    price+=numL*4.15;
                    break;
            }
    }
        if(season.equals("Spring") && numL > 7){
            price*=.95;
        }else if(numR >= 10 && season.equals("Winter")){
            price*=.90;
        }
        if(numH+numL+numR > 20){
            price*=.8;
        }
        price+=2;

        System.out.printf("%.2f",price);
    }
}
