package com.softuni;

import java.util.Scanner;

public class BinaryConversion {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String bin=scanner.nextLine();
        char [] bit=bin.toCharArray();
        int val=0;
        for(int i=bit.length-1;i>=0;i--){
           // System.out.println("bit val " +bit[(bit.length-1)-i]+" index"+i);
            int digit=Integer.valueOf(String.valueOf(bit[(bit.length-1)-i]));
           val+=Math.pow(digit*2,i);

        }
        System.out.println(val);
    }
}
