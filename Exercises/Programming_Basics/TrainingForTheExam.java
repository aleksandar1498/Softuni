package com.softuni;

import java.util.Scanner;

public class TrainingForTheExam {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int allowedPoorGrades=Integer.parseInt(scanner.nextLine());
        int poorGrades=0;
        int problems=0;
        double sumGrades=0;
        int nGrades=0;
        String lastExam="";
        while(poorGrades<allowedPoorGrades){
            String input=scanner.nextLine();
            if(input.equals("Enough")){
                break;
            }
            lastExam=input;
            double grade=Integer.parseInt(scanner.nextLine());
            sumGrades+=grade;
            nGrades++;
            if(grade <= 4){
                poorGrades++;
            }
        }
        if(poorGrades >= allowedPoorGrades){
            System.out.printf("You need a break, %d poor grades.",poorGrades);
        }else {
            System.out.printf("Average score: %.2f%n", Double.valueOf(sumGrades / nGrades));
            System.out.printf("Number of problems: %d%n", nGrades);
            System.out.printf("Last problem: %s%n", lastExam);
        }
    }
}
