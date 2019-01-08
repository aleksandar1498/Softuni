package com.softuni;

import java.util.Scanner;

public class Walking {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);

        String action=scanner.nextLine();
        int steps=0;
        if (action.equals("Going home")) {
            int stepsToHome = Integer.parseInt(scanner.nextLine());

            steps += stepsToHome;
        } else {
            steps += Integer.parseInt(action);
        }

        while(steps < 10000 && !action.equals("Going home")) {
            action = scanner.nextLine();
            if (action.equals("Going home")) {
                int stepsToHome = Integer.parseInt(scanner.nextLine());

                steps += stepsToHome;
            } else {
                steps += Integer.parseInt(action);
            }
        }
        if(steps>= 10000){
            System.out.println("Goal reached! Good job!");
        }else{
            System.out.printf("%d more steps to reach goal.",10000-steps);
        }
    }
}
