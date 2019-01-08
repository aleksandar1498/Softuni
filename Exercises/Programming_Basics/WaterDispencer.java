package com.softuni;

import java.util.Scanner;

public class WaterDispencer {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int volume=Integer.parseInt(scanner.nextLine());
        int dispenser=0;
        int tap=0;
        while(dispenser < volume){
            String action=scanner.nextLine();
            int val=0;
            switch (action){
                case "Hard":
                    val=200;
                    break;
                case "Medium":
                    val=100;
                    break;
                case "Easy":
                    val=50;
                    break;
            }

                tap++;
                dispenser+=val;


        }
        if(dispenser > volume){
            System.out.printf("%dml has been spilled.",dispenser-volume);
        }else{
            System.out.println("The dispenser has been tapped "+tap+" times.");
        }



    }
}
