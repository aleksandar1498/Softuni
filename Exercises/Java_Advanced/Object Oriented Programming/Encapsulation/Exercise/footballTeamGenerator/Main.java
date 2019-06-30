package footballTeamGenerator;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    final static Map<String, Team> teams = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            parseCommand(command);
        }
    }

    private static void parseCommand(String command) {
        String[] token = command.split(";");
        String teamName = token[1];
        switch (token[0]) {
            case "Team":

                addTeam(new Team(teamName));
                break;
            case "Add":
                String playerName = token[2];
                int endurance = Integer.parseInt(token[3]);
                int sprint = Integer.parseInt(token[4]);
                int dribble = Integer.parseInt(token[5]);
                int passing = Integer.parseInt(token[6]);
                int shooting = Integer.parseInt(token[7]);
                try {
                    addPlayer(teamName, new Player(playerName, endurance, sprint, dribble, passing, shooting));
                }catch (IllegalArgumentException exception){
                    System.out.println(exception.getMessage());
                }

                break;
            case "Remove":
                String nameOfPlayerToRemove = token[2];
                removePlayer(teamName, nameOfPlayerToRemove);
                break;
            case "Rating":
                printRating(teamName);
                break;
        }
    }

    private static void printRating(String teamName) {
        if (!teams.containsKey(teamName)) {
            System.out.println("Team " + teamName + " does not exist.");
            return;
        }

        System.out.printf("%s - %d%n", teamName, Math.round(teams.get(teamName).getRating()));


    }

    private static void removePlayer(String teamName, String nameOfPlayerToRemove) {
        if (teams.containsKey(teamName)) {
            teams.get(teamName).removePlayer(nameOfPlayerToRemove);
        }
    }

    private static void addTeam(Team team) {
        teams.putIfAbsent(team.getName(), team);
    }

    private static void addPlayer(String teamName, Player player) {
        if (!teams.containsKey(teamName)) {
            System.out.println("Team " + teamName + " does not exist.");
            return;
        }
        teams.get(teamName).addPlayer(player);


    }

}
