package com.softuni;


import java.util.Scanner;

public class histogram {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        int sum1=0,sum2=0,sum3=0,sum4=0,sum5=0;
        for(int i=0;i<n;i++){
            int val=Integer.parseInt(scanner.nextLine());
            if(val < 200){
                sum1++;
            }else if(val < 400){
                sum2++;
            }else if(val < 600){
                sum3++;
            }else if(val < 800){
                sum4++;
            }else{
                sum5++;
            }
        }

        System.out.printf("%.2f%%\n",((double)sum1/n)*100.0);
        System.out.printf("%.2f%%\n",((double)sum2/n)*100.0);
        System.out.printf("%.2f%%\n",((double)sum3/n)*100.0);
        System.out.printf("%.2f%%\n",((double)sum4/n)*100.0);
        System.out.printf("%.2f%%\n",((double)sum5/n)*100.0);
    }
}
