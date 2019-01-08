package com.softuni;

import java.util.Scanner;

public class EatCake {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int w=Integer.parseInt(scanner.nextLine());
        int l=Integer.parseInt(scanner.nextLine());
        int totPieces=w*l;
        int takenPieces=0;
        boolean avaible=true;
        while(takenPieces < totPieces){
            String action=scanner.nextLine();
            if(action.equals("STOP")){
                break;
            }
            int piece=Integer.parseInt(action);

            if((takenPieces+piece) >= totPieces){
                takenPieces+=piece;
                avaible=false;
            }else {
                takenPieces += piece;
            }
        }
        if(takenPieces > totPieces){
            System.out.printf("No more cake left! You need %d pieces more",takenPieces-totPieces);
        }else {
            System.out.printf("%d pieces are left.",totPieces-takenPieces);
        }
    }
}
