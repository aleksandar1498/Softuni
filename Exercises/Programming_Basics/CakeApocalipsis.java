package com.softuni;

import java.util.Scanner;

public class CakeApocalipsis {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int width=Integer.parseInt(scanner.nextLine());
        int length=Integer.parseInt(scanner.nextLine());
        int numPieces=width*length;
        int eatenPieces=0;
        while(eatenPieces <= numPieces){
            String action=scanner.nextLine();
            if(action.equals("STOP")){

                break;
            }
            eatenPieces+=Integer.parseInt(action);

        }
        if(eatenPieces > numPieces){
            System.out.printf("No more cake left! You need %d pieces more.",eatenPieces-numPieces);
        }else{
            System.out.printf("%d pieces are left.",numPieces-eatenPieces);

        }
    }
}
