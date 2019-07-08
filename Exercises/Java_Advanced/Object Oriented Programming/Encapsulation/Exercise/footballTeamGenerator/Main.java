package footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        Map<String, Team> teams = new LinkedHashMap<>();
        while (!"END".equals(command = scanner.nextLine())) {
            try {
                String[] token = command.split(";");
                String teamName = token[1];
                switch (token[0]) {
                    case "Team":

                        teams.putIfAbsent(teamName, new Team(teamName));
                        break;
                    case "Add":
                        String playerName = token[2];
                        int endurance = Integer.parseInt(token[3]);
                        int sprint = Integer.parseInt(token[4]);
                        int dribble = Integer.parseInt(token[5]);
                        int passing = Integer.parseInt(token[6]);
                        int shooting = Integer.parseInt(token[7]);
                        if (!teams.containsKey(teamName)) {
                            throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                        }
                        teams.get(teamName).addPlayer(new Player(playerName,endurance,sprint,dribble,passing,shooting));

                        break;
                    case "Remove":
                        String nameOfPlayerToRemove = token[2];
                        if (teams.containsKey(teamName)) {
                            teams.get(teamName).removePlayer(nameOfPlayerToRemove);
                        }
                        break;
                    case "Rating":
                        if (!teams.containsKey(teamName)) {
                            throw new IllegalArgumentException("Team " + teamName + " does not exist.");
                        }

                        System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));
                        break;
                }
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }











}
