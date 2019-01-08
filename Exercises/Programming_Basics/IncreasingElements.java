package com.softuni;

import java.util.Scanner;

public class IncreasingElements {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int prevNumber=0;
        int countLongest=1;
        for(int i=0;i<n;i++){
            int x=Integer.parseInt(scanner.nextLine());


            if(x>prevNumber){
                countLongest++;
            }else{
                countLongest=1;
            }
            prevNumber=x;

        }
        System.out.println(countLongest);
    }
}
