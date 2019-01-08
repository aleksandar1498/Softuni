package com.softuni;

import java.util.Scanner;

public class TrainTheTrainers {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        double totSumOfMarks=0.0;
        int count=0;
        String action=scanner.nextLine();
        while (!action.equals("Finish")){
            double innerSumOfMarks=0.0;
            for (int i = 0; i < n; i++) {
                double mark=Double.parseDouble(scanner.nextLine());
                innerSumOfMarks+=mark;
                totSumOfMarks+=mark;
            }
            System.out.printf("%s - %.2f.\n",action,innerSumOfMarks/n);
       count++;
       action=scanner.nextLine();
        }
        System.out.printf("Student's final assessment is %.2f.",totSumOfMarks/(count*n));
    }
}
