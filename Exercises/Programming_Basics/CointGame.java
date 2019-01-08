package com.softuni;

import java.util.Scanner;

public class CointGame {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int numOfLaunch=Integer.parseInt(scanner.nextLine());
        int t=0,c=0;
        for(int i=0;i<numOfLaunch;i++){
            int launch=(int)(Math.random()*(2));
            if(launch == 0){
                t++;
            }else if(launch == 1){
                c++;
            }
            System.out.println(launch);
        }
        System.out.println("Num of t "+t);
        System.out.println("Num of c "+c);
        System.out.println("Statistic");
        System.out.println((t*100)/numOfLaunch+"% teste "+(c*100)/numOfLaunch+"% croci");


    }
}
