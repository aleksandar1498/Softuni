package com.softuni;

import java.util.Scanner;

public class Moving {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int widthRoom=Integer.parseInt(scanner.nextLine());
        int lengthRoom=Integer.parseInt(scanner.nextLine());
        int heightRoom=Integer.parseInt(scanner.nextLine());
        int roomVolume=widthRoom*lengthRoom*heightRoom;
        int boxVolume=0;
        String action=scanner.nextLine();

        while(!action.equals("Done") ){
            boxVolume+=Integer.parseInt(action);
            if(boxVolume >= roomVolume){
                break;
            }
            action=scanner.nextLine();

        }
        if(boxVolume > roomVolume){
            System.out.printf("No more free space! You need %d Cubic meters more.",boxVolume-roomVolume);
        }else{
            System.out.printf("%d Cubic meters left.",roomVolume-boxVolume);
        }
    }
}
