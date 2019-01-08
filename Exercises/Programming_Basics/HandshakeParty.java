package com.softuni;

import java.util.Scanner;

public class HandshakeParty {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOfGuests=Integer.parseInt(scanner.nextLine());
        for(int i=0;i<numOfGuests;i++){
            System.out.println("GUEST "+i);
            for(int j=0;j<i;j++){
                System.out.println("Guest "+i+" handshakes the "+j+" guest");
            }
            System.out.println();
        }
    }
}
