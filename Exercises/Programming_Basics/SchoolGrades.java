package com.softuni;

import java.util.Scanner;

public class SchoolGrades {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double average=0;
        int count=0,count1=0,count2=0,count3=0;
        for (int student = 0; student < n; student++) {
            double grade=Double.parseDouble(scanner.nextLine());
            if(grade>= 2.0 && grade <=2.99){
                count++;
            }else if(grade <= 3.99){
                count1++;
            }else if(grade <= 4.99){
                count2++;
            }else{
                count3++;
            }
            average+=grade;
        }
        average/=n;
        System.out.printf("Top students:%.2f%%\n",count3*100.0/n);
        System.out.printf("Between 4.00 and 4.99:%.2f%%\n",count2*100.0/n);
        System.out.printf("Between 3.00 and 3.99:%.2f%%\n",count1*100.0/n);
        System.out.printf("Fail:%.2f%%\n",count*100.0/n);
        System.out.printf("Average:%.2f",average);

    }
}
