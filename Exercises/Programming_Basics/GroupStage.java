package com.softuni;

import java.util.Scanner;

public class GroupStage {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String teamName=scanner.nextLine();
        int playedGames=Integer.parseInt(scanner.nextLine());
        int points=0;
        int totReceivedGoals=0,totPerformedGoals=0;
        for (int i = 0; i < playedGames; i++) {
            int performedGoals=Integer.parseInt(scanner.nextLine());
            int receivedGoals=Integer.parseInt(scanner.nextLine());
            totPerformedGoals+=performedGoals;
            totReceivedGoals+=receivedGoals;
            if(performedGoals > receivedGoals){
                points+=3;
            }else if(performedGoals == receivedGoals){
                points++;
            }
        }
        if(totPerformedGoals > totReceivedGoals){
            System.out.printf("%s has finished the group phase with %d points.\n",teamName,points);
            System.out.printf("Goal difference: %d",totPerformedGoals-totReceivedGoals);
        }else{
            System.out.printf("%s has been eliminated from the group phase.\n",teamName,points);
            System.out.printf("Goal difference: %d",totReceivedGoals-totPerformedGoals);
        }
    }
}
