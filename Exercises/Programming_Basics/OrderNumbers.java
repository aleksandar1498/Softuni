package com.softuni;

import java.util.Scanner;

public class OrderNumbers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int [] a = new int[10];
        for(int i=0;i<a.length;i++){
            a[i]= (int) (Math.random()*10 + 1);
            System.out.print(" "+a[i]);
        }
        System.out.println();

        for(int x=0;x<a.length-1;x++){
            for(int y=x+1;y<a.length;y++){
                if(a[x] > a[y]){
                    int temp= a[x];
                    a[x]=a[y];
                    a[y]=temp;
                }
            }
        }
        for(int digit: a){
            System.out.print(" "+digit);
        }
    }
}
