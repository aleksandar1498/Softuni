package com.softuni;

import java.util.Scanner;

public class NumberSumCombinations {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int a =Integer.parseInt(scanner.nextLine());
        int b=Integer.parseInt(scanner.nextLine());
        int c=Integer.parseInt(scanner.nextLine());
        if(a+b ==c){
            System.out.printf("%d + %d = %d",Math.min(a,b),Math.max(b,a),c);
        }else if(a+c == b){
            System.out.printf("%d + %d = %d",Math.min(a,c),Math.max(a,c),b);

        }else if(b+c == a){
            System.out.printf("%d + %d = %d",Math.min(b,c),Math.max(b,c),a);

        }else{
            System.out.println("No");
        }
    }
}
