package com.softuni;

import java.util.Scanner;

public class GenerateRectangles {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int area=Integer.parseInt(scanner.nextLine());
        int count=0;
        for (int left = -n; left < n ; left++) {
            for (int top = -n; top < n ; top++) {
                for (int right = left +1; right <=n; right++) {
                    for (int bottom = top +1; bottom <=n; bottom++) {
if((Math.max(top,bottom)-Math.min(top,bottom))*(Math.max(left,right)-Math.min(left,right))  >= area){
    System.out.printf("(%d,%d)(%d,%d)-> %d",left,top,right,bottom,(Math.max(top,bottom)-Math.min(top,bottom))*(Math.max(left,right)-Math.min(left,right)));                        }
                  count++;
                    }
                }
            }
        }
        if(count == 0){
            System.out.println("No");
        }
    }
}
