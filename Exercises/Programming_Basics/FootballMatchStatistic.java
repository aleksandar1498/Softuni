package com.softuni;

import java.util.Scanner;

public class FootballMatchStatistic {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        String nameTeam=scanner.nextLine();
        int numPlayedGames=Integer.parseInt(scanner.nextLine());
        int sumTotTime=0;
        double averageDuration=0;
        int gameWithPenalities=0,gameWithAdditionalTime=0;
        for (int i = 0; i < numPlayedGames; i++) {
            int duration=Integer.parseInt(scanner.nextLine());
            sumTotTime+=duration;
            if(duration >90 && duration <= 120){
                gameWithAdditionalTime++;
            }else if(duration > 120){
                gameWithPenalities++;
            }
        }
        averageDuration=(double)sumTotTime/numPlayedGames;
        System.out.printf("%s has played %d minutes.\nAverage minutes per game:" +
                "%.2f\nGames with penalties: %d\nGames with additional time: %d",nameTeam,sumTotTime,averageDuration,gameWithPenalities,gameWithAdditionalTime);
    }
}
