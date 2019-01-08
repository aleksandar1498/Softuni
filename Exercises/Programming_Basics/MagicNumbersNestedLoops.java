package com.softuni;

import java.util.Scanner;

public class MagicNumbersNestedLoops {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String result="";
        int n=Integer.parseInt(scanner.nextLine());
        for (int f = 1; f <= 9; f++) {
            for (int i = 1; i <= 9; i++) {
                for (int j = 1; j <= 9; j++) {
                    for (int k = 1; k <= 9; k++) {
                        for (int l = 1; l <= 9; l++) {
                            for (int m = 1; m <= 9; m++) {
                                if(f*i*j*k*l*m == n){
                                    // System.out.println(" "+f*i*j*k*l*m);
                                    result=result.concat(" "+f+""+i+""+j+""+k+""+l+""+m);
                                }
                            }
                        }
                    }
                }
            }
        }
        result=result.trim();
        System.out.println(result);
    }
}
