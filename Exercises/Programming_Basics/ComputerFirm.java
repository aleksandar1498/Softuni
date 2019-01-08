package com.softuni;

import java.util.Scanner;

public class ComputerFirm {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double sumRating=0.0;
        double sumProbability=0.0;
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(scanner.nextLine());
            sumRating+=val%10;
            switch(val%10){
                case 2:
                    sumProbability+=0;
                    break;
                case 3:
                    sumProbability+=val%10*((int)val/10)*.50;
                    break;
                case 4:
                    sumProbability+=val%10*((int)val/10)*.70;
                    break;
                case 5:
                    sumProbability+=val%10*((int)val/10)*.85;
                    break;
                case 6:
                    sumProbability+=val%10*((int)val/10);
                    break;
            }

        }
        System.out.printf("%.2f\n%.2f",sumProbability/n,sumRating/n);
    }
}
