package com.softuni;

import java.util.Scanner;

public class Fishing {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numFishes=Integer.parseInt(scanner.nextLine());
        int numCaughtFishes=1;
        double spentMoney=0,earnedMoney=0;
        String action=scanner.nextLine();
       while(!action.equals("Stop")){

            double fishWeight=Double.parseDouble(scanner.nextLine());
            double fishPrice=0.0;
            for(char letter:action.toCharArray()){
                fishPrice+=(int)(letter);
            }
            fishPrice/=fishWeight;
            if(numCaughtFishes%3 == 0){
                earnedMoney+=fishPrice;
            }else{
                spentMoney+=fishPrice;
            }
            numCaughtFishes++;
            if(numCaughtFishes > numFishes){
                System.out.println("Lyubo fulfilled the quota!");
                break;
            }
            action=scanner.nextLine();
        }
        if(earnedMoney >= spentMoney){
            System.out.printf("Lyubo's profit from %d fishes is %.2f leva.",--numCaughtFishes,earnedMoney-spentMoney);
        }else{
            System.out.printf("Lyubo lost %.2f leva today.",spentMoney-earnedMoney);
        }
    }
}
