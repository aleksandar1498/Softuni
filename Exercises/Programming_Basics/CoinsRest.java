package com.softuni;

import java.util.Scanner;

public class CoinsRest {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        double rest=Double.parseDouble(scanner.nextLine());
        double restInCent=rest*100;
        int coins=0;
        while(restInCent > 0){
            if(restInCent/200 >= 1){
                coins+=(int)restInCent/200;
                restInCent%=200;
                continue;
            }
            if(restInCent/100 >= 1){
                coins+=(int)restInCent/100;
                restInCent%=100;
                continue;
            }
            if(restInCent/50  >= 1){
                coins+=(int)restInCent/50;
                restInCent%=50;
                continue;
            }
            if(restInCent/20  >= 1){
                coins+=(int)restInCent/20;
                restInCent%=20;
                continue;
            }
            if(restInCent/10  >= 1){
                coins+=(int)restInCent/10;
                restInCent%=10;
                continue;
            }
            if(restInCent/5  >= 1){
                coins+=(int)restInCent/5;
                restInCent%=5;
                continue;
            }
            if(restInCent/2  >= 1){
                coins+=(int)restInCent/2;
                restInCent%=2;
                continue;
            }

            coins+=restInCent;
            restInCent=0;
        }
        System.out.println(coins);
    }
}
