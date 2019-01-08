package com.softuni;

import java.util.Scanner;

public class Building {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int levels=Integer.parseInt(scanner.nextLine());
        int roomsPerLevel=Integer.parseInt(scanner.nextLine());
        for (int i = levels; i > 0; i--) {
            for (int j = 0; j < roomsPerLevel; j++) {
                if(i==levels){
                    System.out.printf("L%d%d ",i,j);
                }else if(i%2 == 0){
                    System.out.printf("O%d%d ",i,j);
                }else{
                    System.out.printf("A%d%d ",i,j);
                }
            }
            System.out.println();
        }
    }
}
