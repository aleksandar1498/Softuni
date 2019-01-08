package com.softuni;

import java.util.Scanner;

public class GroupStage1 {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedGames=Integer.parseInt(scanner.nextLine());

        int totScored=0,totReceived=0,points=0;
        for (int game = 0; game < playedGames; game++) {
            int scoredGoals=Integer.parseInt(scanner.nextLine());
            int receivedGoals=Integer.parseInt(scanner.nextLine());
            totScored+=scoredGoals;
            totReceived+=receivedGoals;
            if(scoredGoals > receivedGoals){
                points+=3;
            }else if(scoredGoals == receivedGoals){
                points++;
            }

        }
        System.out.println(totReceived+" "+totScored);
        if(totScored >= totReceived){
            System.out.printf("%s has finished the group phase with %d points.\nGoal difference : %d.",teamName,points,totScored-totReceived);
        }else{
            System.out.printf("%s has been eliminated from the group phase.\nGoal difference : %d.",teamName,totScored-totReceived);
        }
    }
}
