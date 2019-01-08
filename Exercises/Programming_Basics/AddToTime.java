package com.softuni;

import java.util.Scanner;

public class AddToTime {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int h=Integer.parseInt(scanner.nextLine());
        int m=Integer.parseInt(scanner.nextLine());
        if((m+15) >= 60){
            if((h+1) > 23){
                h=0;
                m=(m+15) % 60;

            }else{
                h++;
                m=(m+15) % 60;
            }
        }else{
            m+=15;
        }

            if(m < 10){
                System.out.println(h+":0"+m);
            }else{
                System.out.println(h+":"+m);
            }

    }
}
