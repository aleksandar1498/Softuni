package com.softuni;

import java.util.Scanner;

public class CompressFile {
    public static final int MAX_BLOCKS=1000;
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int usedBlock=0;
        do{
            double sizeOfTheFile=Integer.parseInt(scanner.nextLine());

            double compressedSize=sizeOfTheFile*.8;
            System.out.println("Compressed Size "+compressedSize+" bytes");
            int neededBlock=(int)(Math.ceil(compressedSize/568));
            System.out.println("Needed blocks "+neededBlock);
            if((neededBlock+usedBlock) > MAX_BLOCKS){
                System.out.println("Your file is too large");
            }else {
                usedBlock += neededBlock;
            }
            System.out.println("Used blocks "+usedBlock);
        }while(usedBlock < MAX_BLOCKS);
    }
}
