package com.softuni;

import java.util.Scanner;

public class OnTimeForTheExam {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hExam = Integer.parseInt(scanner.nextLine());
        int mExam = Integer.parseInt(scanner.nextLine());
        int hArrive = Integer.parseInt(scanner.nextLine());
        int mArrive = Integer.parseInt(scanner.nextLine());
        int examInMinutes=hExam*60+mExam;
        int arriveInMinuts=hArrive*60+mArrive;
        if(arriveInMinuts > examInMinutes){
            int hDifference= (arriveInMinuts-examInMinutes)/60;
            int mDifference=((arriveInMinuts-hDifference*60)-examInMinutes)%60;
            if(hDifference > 0){
                if(mDifference < 10){
                    System.out.printf("Late %d:%02d hours after the Start",hDifference,mDifference);
                   // System.out.println("Late "+hDifference+":0"+mDifference+" hours after the start");

                }else{
                    System.out.println("Late "+hDifference+":"+mDifference+" hours after the start");

                }
            }else{

                System.out.println("Late "+mDifference+" minutes after the start");

            }

        }else if(Math.abs(arriveInMinuts-examInMinutes)> 30){
            int hDifference= (examInMinutes-arriveInMinuts)/60;
            int mDifference=((examInMinutes-hDifference*60)-arriveInMinuts)%60;
            if(hDifference > 0){
                if(mDifference < 10){
                    System.out.printf("Early %d:%02d hours before the start",hDifference,mDifference);
                  //  System.out.println("Early "+hDifference+":0"+mDifference+" hours before the start");

                }else{
                    System.out.println("Early "+hDifference+":"+mDifference+" hours before the start");

                }
            }else{
                System.out.println("Early "+mDifference+" minutes before the start");

            }
        }else if(arriveInMinuts == examInMinutes) {
            System.out.println("On time");
        }else{
            int hDifference= (examInMinutes-arriveInMinuts)/60;
            int mDifference=((examInMinutes-hDifference*60)-arriveInMinuts)%60;
            System.out.println("On time "+mDifference+" minutes before the start");

        }
    }
}
