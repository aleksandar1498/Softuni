package com.softuni;

import java.util.Scanner;

public class EqualSumsLeftRightPositions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a = Integer.parseInt(scanner.nextLine());
        int b = Integer.parseInt(scanner.nextLine());
        for (int i = a; i <= b; i++) {
            String val=String.valueOf(i);
            int sumLeft=0,sumRight=0;
            for (int j = 0; j < val.length()/2; j++) {
                sumLeft+=Integer.parseInt(""+val.charAt(j));
            }
            for (int j = val.length()/2+1; j < val.length(); j++) {
                sumRight+=Integer.parseInt(""+val.charAt(j));
            }
            if(sumLeft == sumRight){
                System.out.print(val+" ");
            }else{
                int temp=Math.min(sumLeft,sumRight)+Integer.parseInt(""+val.charAt(val.length()/2));
                if(temp == Math.max(sumLeft,sumRight)){
                    System.out.print(val+" ");
                }
            }
        }
    }
}
