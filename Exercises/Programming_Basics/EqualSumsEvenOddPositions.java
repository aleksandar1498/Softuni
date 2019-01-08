package com.softuni;

import java.util.Scanner;

public class EqualSumsEvenOddPositions {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a=Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());
        for (int i = a; i <=b; i++) {
            int sumOdd=0,sumEven=0;
            String val=String.valueOf(i);
            for (int j = 0; j < val.length(); j++) {
                if(j%2 == 0){
                    sumEven+=Integer.parseInt(""+val.charAt(j));
                }else{
                    sumOdd+=Integer.parseInt(""+val.charAt(j));
                }
            }
            if(sumEven == sumOdd){
                System.out.print(i+" ");
            }
        }
    }
}
